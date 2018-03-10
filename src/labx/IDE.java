package labx;

import com.alee.laf.WebLookAndFeel;
import com.sun.org.apache.xpath.internal.operations.Bool;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebView;

import javax.imageio.ImageIO;
import javax.script.ScriptException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;



import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rtextarea.RTextScrollPane;

/**
 * Created by mikha on 08.03.2017.
 */

public class IDE {
    public class start {
        boolean state;
        boolean isimpuls;

        public void set(boolean b) {
            state = b;
        }

        public boolean get() {
            return state;
        }

        public void setimpuls(boolean b) {
            isimpuls = b;
        }

        public boolean getimpuls() {
            return isimpuls;
        }

    }

    public boolean isinit = false;
    static double deffontsize =UIManager.getDefaults().getFont("TabbedPane.font").getSize()+5;
    public start strt = new start();
    public File ff;
    public RSyntaxTextArea area = new RSyntaxTextArea();
    public JTextPane pane = new JTextPane();
    public boolean isreading = false;
    boolean issaved;
    public JPanel p2 = new JPanel();
    JFrame frame = new JFrame("LabX v0.1");
    String projtype;
    String title;
    String sav;
    String source;
    String template;
    boolean istemplate;


    LabXPanel labXPanel;
    int num;
    repaintThread t2;

    class repaintThread extends Thread {
        public void run() {
            labXPanel.paintComponent(labXPanel.getGraphics());
        }
    }

    public boolean isWindows() {

        String os = System.getProperty("os.name").toLowerCase();
        //windows
        return (os.indexOf("win") >= 0);

    }

    public boolean isMac() {
        String os = System.getProperty("os.name").toLowerCase();
        //Mac
        return (os.indexOf("mac") >= 0);

    }

    public boolean isUnix() {

        String os = System.getProperty("os.name").toLowerCase();
        //linux or unix
        return (os.indexOf("nix") >= 0 || os.indexOf("nux") >= 0);

    }


    String action = "";


    IDE(String fname, String project, boolean istemp, int number, String template2) {
        ff = new File(fname);

        projtype = project;
        istemplate = istemp;
        strt.state = false;
        num = number;
        template = template2;
        area.setText(template);
        area.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVASCRIPT);

        title = "LabX v0.1 [" + ff.getName() + "]";
        frame.setTitle(title);
        labXPanel = new LabXPanel(num);
        Font fo = new Font("Century Gothic", Font.BOLD, (int) deffontsize+8);
        area.setFont(fo);
        SwingUtilities.invokeLater(() -> {
            try {
                init();

            } catch (UnsupportedLookAndFeelException e) {
                e.printStackTrace();
            }
        });
    }

    public void LoadTextFromFile(File f) {
        if (f != null) {
            area.setEditable(true);
            if (f.exists()) {
                try {
                    Scanner s = new Scanner(new File(f.getAbsolutePath()));
                    String str = "";
                    while (s.hasNext()) {
                        str += s.nextLine() + "\n";
                    }
                    if (str.length() > 0) str = str.substring(0, str.length() - 1);
                    int start=str.indexOf("<--");
                    int end=str.indexOf("-->")+4;

                    if (start!=-1 && end!=-1 && end>start) {
                        String obrab = str.substring(start, end);
                        str = str.replace(obrab, "");
                        str=str.replace("-->","");
                        str= str.replace("<--","");
                        obrab=obrab.replace("<--","");
                        obrab=obrab.replace("-->","");

                        String fontname = obrab.substring(obrab.indexOf("<"),obrab.indexOf(">")+1);
                        obrab= obrab.replace(fontname,"");
                        fontname=fontname.replace("<","");
                        fontname=fontname.replace(">","");
                        StringTokenizer tok = new StringTokenizer(obrab);
                        int lxstroke = Integer.parseInt(tok.nextToken());
                        int lxw = Integer.parseInt(tok.nextToken());
                        int lxh = Integer.parseInt(tok.nextToken());
                        boolean isgrid = Boolean.parseBoolean(tok.nextToken());
                        boolean isimpulse = Boolean.parseBoolean(tok.nextToken());
                        int strsize = Integer.parseInt(tok.nextToken());


                        labXPanel.stroke = lxstroke;
                        labXPanel.w = lxw;
                        labXPanel.h = lxh;
                        labXPanel.enablegrid = isgrid;
                        strt.setimpuls(isimpulse);
                        area.setFont(new Font(fontname, 1, strsize));
                    }

                    area.setText(str);
                    source = str;
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
            isreading = false;
            title = "LabX v0.1 [" + f.getName() + "]";
            frame.setTitle(title);

           // pane.setText("STATUS: Coming soon...");
            frame.repaint();
        }
    }

    void comparetext(File f) {
        if (f.length() != area.getText().length()) {
            issaved = false;
            sav = "*";
        } else {
            boolean b = true;
            for (int i = 0; i < f.length(); i++) {
                if (source.toCharArray()[i] != area.getText().toCharArray()[i]) {
                    issaved = false;
                    sav = "*";
                    b = false;
                    break;
                }
            }
            if (b) {
                issaved = true;
                sav = "";
            }
        }
    }

    public void init() throws UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(new WebLookAndFeel());
        try {
            BufferedImage imgg = ImageIO.read(IDE.class.getClassLoader().getResource("ico.png"));
            ImageIcon icon = new ImageIcon(imgg);
            frame.setIconImage(icon.getImage());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        //frame.setUndecorated(false);

        JPanel p1 = new JPanel();


        JTable table = new JTable();


        p1.setLayout(new BorderLayout());
        p2.setLayout(new BorderLayout());


        //frame.setPreferredSize(new Dimension(640, 480));
        JMenuBar menuBar = new JMenuBar();


        JMenu file = new JMenu("Файл");

        JMenu help = new JMenu("Помощь");

        //JMenu tocode = new JMenu("To Code...");

        JMenu settings = new JMenu("Настройки");


        area.setForeground(Color.BLACK);


        JButton run = new JButton("Запуск");


        JMenuItem open = new JMenuItem("Открыть проект", KeyEvent.VK_O);

        open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
        JMenuItem create = new JMenuItem("Создать проект", KeyEvent.VK_N);

        create.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
        JMenuItem save = new JMenuItem("Сохранить проект", KeyEvent.VK_S);

        save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
        JMenuItem info = new JMenuItem("Информация", KeyEvent.VK_I);

        info.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_DOWN_MASK));
        JMenuItem print = new JMenuItem("Печать", KeyEvent.VK_P);

        print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_DOWN_MASK));

        JMenuItem object = new JMenuItem("Настройки движка", KeyEvent.VK_O);
        object.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));


        area.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                comparetext(ff);
                frame.setTitle(title + sav);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                comparetext(ff);
                frame.setTitle(title + sav);
               /* try {
                    labXPanel.process(area.getText());
                } catch (ScriptException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
*/
            }

            @Override
            public void keyReleased(KeyEvent e) {
                comparetext(ff);
                frame.setTitle(title + sav);
                // labXPanel.t.interrupt();
            }
        });


        JMenuItem licensing = new JMenuItem("Лицензия");


        JFileChooser chooser = new JFileChooser();

        // file.add(open);
        file.add(save);
        file.add(create);
        file.add(print);


        help.add(info);
        help.add(licensing);

        JMenuItem font = new JMenuItem("Размер шрифта");

        settings.add(font);
        settings.add(object);


        menuBar.add(file);
        menuBar.add(run);
        menuBar.add(help);
        menuBar.add(settings);

        area.setAutoscrolls(true);


        pane.setEditable(false);
        //pane.setText("STATUS: Coming soon...");
        pane.setSelectionColor(Color.BLUE);
        pane.setForeground(Color.BLACK);

        frame.add(menuBar, "North");


        //p1.add(pane, "South");


        p2.add(area, "Center");

        Font fo = new Font("Century Gothic", Font.BOLD, (int) deffontsize+8);
        Font fo1 = new Font("Century Gothic", Font.PLAIN, (int) (deffontsize+10));

        // left.setFont(fo1);
        frame.setFont(fo1);
        pane.setFont(new Font("Century Gothic", Font.BOLD, (int) deffontsize));
        menuBar.setFont(fo1);
        JSplitPane splitPane = new JSplitPane();

        RTextScrollPane scrollPane = new RTextScrollPane(area, true, Color.BLACK);
        scrollPane.setFont(new Font(Font.DIALOG, Font.BOLD, (int) (deffontsize+5)));

        p1.add(scrollPane, "Center");

        area.setEditable(true);

        JPopupMenu jpu = new JPopupMenu();
        JMenuItem cut = new JMenuItem("Cut");
        JMenuItem copy = new JMenuItem("Copy");
        JMenuItem paste = new JMenuItem("Paste");

        labXPanel.setBorder(BorderFactory.createSoftBevelBorder(2));
        Definizer.ObjMap= new HashMap<>();
        Definizer.ForceMap= new HashMap<>();

        jpu.add(cut);
        jpu.add(copy);
        jpu.add(paste);

        help.setFont(new Font(Font.DIALOG, Font.BOLD,  (int) deffontsize));
        file.setFont(new Font(Font.DIALOG, Font.BOLD,  (int) deffontsize));
        run.setFont(new Font(Font.DIALOG, Font.BOLD,  (int) deffontsize));
        settings.setFont(new Font(Font.DIALOG, Font.BOLD,  (int) deffontsize));
        info.setFont(new Font(Font.DIALOG, Font.BOLD,  (int) deffontsize));
        licensing.setFont(new Font(Font.DIALOG, Font.BOLD,  (int) deffontsize));
        open.setFont(new Font(Font.DIALOG, Font.BOLD,  (int) deffontsize));
        create.setFont(new Font(Font.DIALOG, Font.BOLD,  (int) deffontsize));
        save.setFont(new Font(Font.DIALOG, Font.BOLD,  (int) deffontsize));
        font.setFont(new Font(Font.DIALOG, Font.BOLD,  (int) deffontsize));
        print.setFont(new Font(Font.DIALOG, Font.BOLD,  (int) deffontsize));
        object.setFont(new Font(Font.DIALOG, Font.BOLD,  (int) deffontsize));

        area.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVASCRIPT);
        area.setHighlightCurrentLine(false);

        licensing.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame jFrame = new JFrame("Лицензия");
                BufferedImage icon = null;
                try {
                    icon = ImageIO.read(IDE.class.getClassLoader().getResource("ico.png"));
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                jFrame.setIconImage(icon);
                jFrame.setPreferredSize(new Dimension(520, 420));
                JTextArea l = new JTextArea();
                l.setFont(new Font("Times New Roman", Font.PLAIN,  (int) deffontsize));
                l.setEditable(false);
                InputStream stream = IDE.class.getResourceAsStream("LICENSE.TXT");
                BufferedInputStream inFile = new BufferedInputStream(stream);
                int c;
                String s;
                s = "";
                try {
                    while ((c = inFile.read()) != -1) {
                        s += (char) c;
                    }
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                l.setText(s);
                l.setCaretPosition(0);
                JScrollPane p = new JScrollPane(l);
                p.getVerticalScrollBar().setValue(0);
                p.getHorizontalScrollBar().setValue(0);
                jFrame.add(p);
                jFrame.pack();
                jFrame.setVisible(true);

            }
        });


        font.addActionListener(e -> {
            if (e.getSource() == font) {
                BufferedImage imgg = null;
                try {
                    imgg = ImageIO.read(IDE.class.getClassLoader().getResource("ico.png"));
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                ImageIcon icon = new ImageIcon(imgg);
                JDialog jFrame= new JDialog(frame);
                jFrame.setTitle("Размер шрифта");

                JPanel panel = new JPanel();
                JPanel po = new JPanel();
                JTextField f1 = new JTextField(area.getFont().getSize());
                f1.setFont(new Font(Font.DIALOG,1, (int) deffontsize));
                GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
                String fontNames[] = environment.getAvailableFontFamilyNames();
                JComboBox l1 = new JComboBox();
                jFrame.setLocation(frame.getX() + frame.getWidth() / 2 - jFrame.getWidth() / 2, frame.getY() + frame.getHeight() / 2 - jFrame.getHeight() / 2);
                l1.setFont(new Font(Font.DIALOG, Font.BOLD,  (int) deffontsize));
                l1.setEditable(true);
                f1.setText(Integer.toString(area.getFont().getSize()));
                l1.addItem(area.getFont().getFamily());
                for (int i = 0; i < fontNames.length; i++) {
                    l1.addItem(fontNames[i]);
                }
                JMenuItem button = new JMenuItem("Подтвердить");
                button.setFont(new Font(Font.DIALOG, Font.BOLD,  (int) deffontsize));

                panel.setLayout(new BorderLayout());
                po.setLayout(new GridLayout(2,1));

                po.add(f1);
                po.add(l1);

                panel.add(po, "Center");
                panel.add(button, "South");
                jFrame.setIconImage(imgg);

                button.addActionListener(e12 -> {
                    area.setFont(new Font(l1.getSelectedItem().toString(), 1, Integer.parseInt(f1.getText())));
                    jFrame.setVisible(false);
                });

                jFrame.add(panel);
                jFrame.setPreferredSize(new Dimension((int) (frame.getWidth() / 4*1.3), (int) (frame.getWidth() / 7 / 1.6*1.3)));
                jFrame.setResizable(false);
                jFrame.pack();

                jFrame.setVisible(true);
            }
        });

        object.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BufferedImage imgg = null;
                try {
                    imgg = ImageIO.read(IDE.class.getClassLoader().getResource("ico.png"));
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                ImageIcon icon = new ImageIcon(imgg);
                JDialog jFrame = new JDialog(frame, "Настройки движка");
                JPanel panel = new JPanel();
                JPanel po = new JPanel();
                JButton ok = new JButton("Ok");
                JButton cancel = new JButton("Отмена");


                jFrame.setPreferredSize(new Dimension((int) (frame.getWidth() / 4*1.3), (int) (frame.getWidth() / 5 / 1.6*1.3)));
                jFrame.setLocation(frame.getX() + frame.getWidth() / 2 - jFrame.getWidth() / 2, frame.getY() + frame.getHeight() / 2 - jFrame.getHeight() / 2);

                JTextField f1 = new JTextField(area.getFont().getSize());

                panel.setLayout(new GridLayout(6, 2));
                po.setLayout(new GridLayout(1, 2));
                po.add(ok);
                po.add(cancel);
                jFrame.getRootPane().setDefaultButton(ok);

                JLabel stroke = new JLabel("Ширина линий");

                JLabel width = new JLabel("Ширина объектов");

                JLabel height = new JLabel("Высота объектов");
                JLabel grid = new JLabel("Координатная сетка");
                JLabel isbouncing = new JLabel("Взаимодействие объектов");
                JCheckBox gridb = new JCheckBox();
                JCheckBox impulse = new JCheckBox();
                gridb.setSelected(labXPanel.enablegrid);
                impulse.setSelected(WIZARD.ide.get(num).strt.isimpuls);

                stroke.setFont(new Font(Font.DIALOG, Font.BOLD,  (int) deffontsize));
                width.setFont(new Font(Font.DIALOG, Font.BOLD,  (int) deffontsize));
                height.setFont(new Font(Font.DIALOG, Font.BOLD,  (int) deffontsize));
                ok.setFont(new Font(Font.DIALOG, Font.BOLD,  (int) deffontsize));
                cancel.setFont(new Font(Font.DIALOG, Font.BOLD,  (int) deffontsize));

                JTextField strokef = new JTextField(String.valueOf(labXPanel.stroke));

                JTextField widthf = new JTextField(String.valueOf(labXPanel.w));

                JTextField heightf = new JTextField(String.valueOf(labXPanel.h));

                strokef.setFont(new Font(Font.DIALOG, Font.PLAIN,  (int) deffontsize));
                widthf.setFont(new Font(Font.DIALOG, Font.PLAIN,  (int) deffontsize));
                heightf.setFont(new Font(Font.DIALOG, Font.PLAIN,  (int) deffontsize));
                grid.setFont(new Font(Font.DIALOG, Font.BOLD,  (int) deffontsize));
                isbouncing.setFont(new Font(Font.DIALOG, Font.BOLD,  (int) deffontsize));

                panel.add(stroke);
                panel.add(strokef);
                panel.add(width);
                panel.add(widthf);
                panel.add(height);
                panel.add(heightf);
                panel.add(grid);
                panel.add(gridb);
                panel.add(isbouncing);
                panel.add(impulse);
                panel.add(ok);
                panel.add(cancel);


                gridb.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        labXPanel.enablegrid = gridb.isSelected();
                    }
                });
                impulse.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        WIZARD.ide.get(num).strt.isimpuls = impulse.isSelected();
                    }
                });


                jFrame.add(panel, "Center");
                //jFrame.add(po,"South");

                jFrame.pack();
                jFrame.setVisible(true);


                ok.addActionListener(e15 -> {
                    labXPanel.stroke = Integer.valueOf(strokef.getText());
                    labXPanel.w = Integer.valueOf(widthf.getText());
                    labXPanel.h = Integer.valueOf(heightf.getText());
                    jFrame.setVisible(false);
                });
                cancel.addActionListener(e16 -> {
                    jFrame.setVisible(false);
                });
            }
        });


        cut.addActionListener(e -> {
            if (e.getSource() == cut) {
                area.cut();
            }
        });
        copy.addActionListener(e -> {
            if (e.getSource() == copy) {
                area.copy();
            }
        });
        paste.addActionListener(e -> {
            if (e.getSource() == paste) {
                String s = "";
                area.paste();
            }
        });
        area.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.isPopupTrigger())
                    jpu.show(e.getComponent(), e.getX(), e.getY());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger())
                    jpu.show(e.getComponent(), e.getX(), e.getY());
            }
        });


        area.add(jpu);

        print.addActionListener(e -> {
            if (e.getSource() == print) {


            }
        });


       /* open.addActionListener(e -> {
            if (e.getSource() == open) {
                isreading = true;
                isinit = false;
                area.setText("");
                pane.setText("STATUS: opening...");
                chooser.setDialogTitle("Open file");
                chooser.setApproveButtonText("Open");
                chooser.setSelectedFile(new File(ff.getName()));
                int approw = chooser.showSaveDialog(null);

                if (approw == JFileChooser.APPROVE_OPTION) {
                    ff = chooser.getSelectedFile();
                    LoadTextFromFile(ff);

                }
            }
        });*/

        save.addActionListener(e -> {
            if (e.getSource() == save && ff != null) {
                File U = new File("");
                try {
                    ff.createNewFile();

                    U = ff;
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                String name = "";
                char c = ' ';
                int i = 0;

                //pane.setText("STATUS: saving");
                chooser.setDialogTitle("Сохранить проект");
                //chooser.setSelectedFile(new File(ff.getName()));

               // pane.setText("STATUS: Coming soon...");
                String s = "";


                int sub = ff.getName().lastIndexOf(".");
                String okn = ".labx";

                if (sub > 0) {
                    ff = new File(s + ff.getName().substring(0, sub) + okn);
                } else ff = new File(s + ff.getName() + okn);
               // System.out.println(ff.getName());
                chooser.setSelectedFile(new File(WIZARD.defkatalog+"\\"+ff.getName()));


                chooser.setDialogType(JFileChooser.SAVE_DIALOG);

                int res = chooser.showSaveDialog(chooser);
                if (res == JFileChooser.APPROVE_OPTION) {
                    //  ff = chooser.getSelectedFile();
                    File uu = chooser.getCurrentDirectory();
                    s = uu.getAbsolutePath() + "/";
                    sub = ff.getName().lastIndexOf(".");
                    okn = ".labx";
                    if (sub > 0) {
                        ff = new File(s + ff.getName().substring(0, sub) + okn);
                    } else ff = new File(s + ff.getName() + okn);
                    PrintWriter w1 = null;
                    try {
                        ff.createNewFile();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }

                    String textgen="<--  "+labXPanel.stroke+"  "+labXPanel.w+" "+labXPanel.h+" "+labXPanel.enablegrid+" "+strt.getimpuls()+" <"+area.getFont().getFontName()+"> "+area.getFont().getSize()+" --> ";

                    try {
                        // System.out.println(ff.getAbsolutePath());
                        ff.createNewFile();
                        w1 = new PrintWriter(ff.getAbsoluteFile());
                        w1.print(textgen);
                        w1.print(area.getText());
                        w1.flush();
                        w1.close();
                    } catch (FileNotFoundException e1) {
                        e1.printStackTrace();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    ff = new File(chooser.getSelectedFile().getAbsolutePath());
                    issaved = true;
                    source=area.getText();


                    comparetext(ff);
                    frame.setTitle(title + sav);
                }


            }
            if (ff == null) {
                JOptionPane.showMessageDialog(frame, "Пожалуйста, создайте или выберите проект!");
            }
        });


        run.addActionListener(e -> {
            if (!strt.state) {
                WIZARD.ide.get(num).strt.state = true;
                try {
                    try {
                        labXPanel.process(area.getText());
                        t2 = new repaintThread();
                        t2.start();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    // pane.setText(labXPanel.engine.getContext().getWriter().toString());

                } catch (ScriptException e1) {
                    e1.printStackTrace();
                }
                labXPanel.paintComponent(labXPanel.getGraphics());
                run.setText("Стоп");


            } else {
                run.setText("Запуск");

                WIZARD.ide.get(num).strt.state = false;
                // labXPanel.t.interrupt();
            }


        });


        create.addActionListener(e -> {
            if (e.getSource() == create) {
                JDialog creat = new JDialog();
                creat.setTitle("Создать новый проект");
                BufferedImage imgg = null;
                try {
                    imgg = ImageIO.read(IDE.class.getClassLoader().getResource("ico.png"));
                    ImageIcon icon = new ImageIcon(imgg);
                    creat.setIconImage(icon.getImage());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                creat.setPreferredSize(new Dimension(300, 120));
                JPanel p = new JPanel();
                JTextField name = new JTextField(15);
                JButton ok = new JButton("Ok");
                JButton cancel = new JButton("Отмена");
                ok.setFont(new Font(Font.DIALOG, Font.BOLD,  (int) deffontsize));
                ok.setBackground(Color.BLUE);
                name.setFont(new Font(Font.DIALOG, Font.BOLD,  (int) deffontsize));
                cancel.setFont(new Font(Font.DIALOG, Font.BOLD,  (int) deffontsize));
                p.add(name, "North");
                p.add(ok, "South");
                p.add(cancel, "south");
                creat.setResizable(false);
                creat.pack();


                cancel.addActionListener(e13 -> {
                    creat.setVisible(false);
                    creat.dispose();

                });
                ok.addActionListener(e14 -> {
                            if (!name.getText().equals("")) {
                                area.setEditable(true);
                                ff = new File(name.getText() + ".labx");
                                frame.setTitle("LabX v0.1 [" + ff.getName() + "]");
                                creat.setVisible(false);
                                creat.dispose();
                            } else {
                                JOptionPane.showMessageDialog(frame, "Пожалуйста, введите корректное название проекта!");
                            }

                        }
                );

                creat.add(p);
                creat.setModal(true);
                creat.setLocation(frame.getX() + frame.getWidth() / 2 - creat.getWidth() / 2, frame.getY() + frame.getHeight() / 2 - creat.getHeight() / 2);


                area.setText("");
                creat.setVisible(true);
            }


        });


        info.addActionListener((ActionEvent e) -> {
            JFrame F = new JFrame("Информация");
            try {
               Image imgg = ImageIO.read(IDE.class.getClassLoader().getResource("ico.png"));
                ImageIcon icon = new ImageIcon(imgg);
                F.setIconImage(icon.getImage());
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            //Some information about LabX
            JFXPanel pane1 = new JFXPanel();
            //HTMLEditorKit kit  =new HTMLEditorKit();

            //pane1.setEditable(false);

            pane1.setFont(new Font(Font.DIALOG, Font.PLAIN,  (int) deffontsize));



            int ii = 0;


            Platform.runLater(() -> {
                WebView webView = new WebView();
                pane1.setScene(new Scene(webView));
                webView.getEngine().load(IDE.class.getResource("doc/LABX.html").toExternalForm());
            });
            JScrollPane scrollPane1 = new JScrollPane(pane1);
            //scrollPane1.getHorizontalScrollBar().setValue(scrollPane1.getHorizontalScrollBar().getMaximum() / 2);
            F.add(scrollPane1);

            F.setPreferredSize(new Dimension(780, 780));

            F.pack();
            F.setVisible(true);
            F.repaint();
        });

       // LoadTextFromFile(ff);


        frame.setPreferredSize(new Dimension((int) screenSize.getWidth() / 2, (int) ((screenSize.getWidth() / 2) /1.7)));

        frame.setLocationByPlatform(true);
        JScrollPane Scroll = new JScrollPane(pane);
        JSplitPane pane2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, labXPanel, Scroll);

        pane2.setOneTouchExpandable(true);
        pane2.setResizeWeight(0.85);
        pane2.setDividerSize(15);
        splitPane.setDividerSize(15);

        splitPane.setLeftComponent(scrollPane);
        splitPane.setRightComponent(pane2);
        splitPane.setOneTouchExpandable(true);
        splitPane.setResizeWeight(0.5);

        frame.add(splitPane, "Center");
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        frame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                if (!issaved) {
                    JDialog creat = new JDialog();
                    creat.setTitle("Сохранить изменения?");
                    BufferedImage imgg = null;
                    try {
                        imgg = ImageIO.read(IDE.class.getClassLoader().getResource("ico.png"));
                        ImageIcon icon = new ImageIcon(imgg);
                        creat.setIconImage(icon.getImage());
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    creat.setPreferredSize(new Dimension((int) (WIZARD.frame.getWidth()/4.5), (int) (WIZARD.frame.getWidth()/5/1.7)));
                    JPanel p = new JPanel();
                    JButton ok = new JButton("Ok");
                    JButton cancel = new JButton("Отмена");
                    ok.setFont(new Font(Font.DIALOG, Font.BOLD,  (int) deffontsize));
                    ok.setBackground(Color.BLUE);
                    cancel.setFont(new Font(Font.DIALOG, Font.BOLD,  (int) deffontsize));
                    p.add(ok, "South");
                    p.add(cancel, "south");
                    creat.setResizable(false);
                    creat.pack();


                    cancel.addActionListener(e13 -> {
                        creat.setVisible(false);
                        creat.dispose();

                    });
                    ok.addActionListener(e14 -> {
                                JFileChooser chooser = new JFileChooser();
                                if (!ff.exists()) {
                                    //File ff=null;
                                    File U = new File("");
                                    try {

                                        ff.createNewFile();
                                        U = ff;
                                        chooser.setSelectedFile(new File(WIZARD.defkatalog+"\\"+ff.getName()));
                                    } catch (IOException e1) {
                                        e1.printStackTrace();
                                    }
                                    chooser.setDialogTitle("Сохранить проект");
                                    chooser.setApproveButtonText("Сохранить");
                                    //chooser.setSelectedFile(new File(ff.getName()));
                                    int approw = chooser.showSaveDialog(null);

                                    if (approw == JFileChooser.APPROVE_OPTION) {
                                        ff = new File(chooser.getCurrentDirectory() + "\\" + ff.getName());
                                        try {
                                            ff.createNewFile();
                                            String textgen="<--  "+labXPanel.stroke+"  "+labXPanel.w+" "+labXPanel.h+" "+labXPanel.enablegrid+" "+strt.getimpuls()+" <"+area.getFont().getFontName()+"> "+area.getFont().getSize()+" --> ";
                                            try {
                                                PrintWriter wr = new PrintWriter(ff);
                                                wr.print(textgen);
                                                wr.print(area.getText());
                                                // System.out.println(area.getText());
                                                wr.flush();
                                                wr.close();
                                            } catch (IOException e1) {
                                                e1.printStackTrace();
                                            }
                                        } catch (IOException e1) {
                                            e1.printStackTrace();
                                        }
                                        //chooser.setVisible(false);
                                        U.delete();
                                        issaved = true;
                                    }
                                    //chooser.setVisible(false);
                                } else {
                                    String textgen="<--  "+labXPanel.stroke+"  "+labXPanel.w+" "+labXPanel.h+" "+labXPanel.enablegrid+" "+strt.getimpuls()+" <"+area.getFont().getFontName()+"> "+area.getFont().getSize()+" --> ";
                                    PrintWriter wr = null;
                                    try {
                                        wr = new PrintWriter(ff);
                                    } catch (FileNotFoundException e1) {
                                        e1.printStackTrace();
                                    }
                                    wr.print(textgen);
                                    wr.print(area.getText());

                                    //System.out.println(area.getText());
                                    wr.flush();
                                    wr.close();

                                }
                                creat.setVisible(false);
                            });

                    creat.add(p);
                    creat.setModal(true);
                    creat.setLocation(frame.getX() + frame.getWidth() / 2 - creat.getWidth() / 2, frame.getY() + frame.getHeight() / 2 - creat.getHeight() / 2);
                    creat.setVisible(true);


                }

                labXPanel=null;
                WIZARD.ide.remove(num);
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });


    }


}
