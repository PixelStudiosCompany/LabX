//package scripter;

import com.alee.laf.WebLookAndFeel;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebView;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Scanner;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rtextarea.RTextScrollPane;

/**
 * Created by mikha on 08.03.2017.
 */
public class IDE {
    public static boolean isinit = false;
    public static File ff;
    public static RSyntaxTextArea area = new RSyntaxTextArea();
    public static JTextPane pane = new JTextPane();
    public static boolean isreading = false;
    public static JPanel p2 = new JPanel();
    static JFrame frame = new JFrame("LabX v0.1");
    static String projtype;
    public static boolean isWindows() {

        String os = System.getProperty("os.name").toLowerCase();
        //windows
        return (os.indexOf("win") >= 0);

    }

    public static boolean isMac() {

        String os = System.getProperty("os.name").toLowerCase();
        //Mac
        return (os.indexOf("mac") >= 0);

    }

    public static boolean isUnix() {

        String os = System.getProperty("os.name").toLowerCase();
        //linux or unix
        return (os.indexOf("nix") >= 0 || os.indexOf("nux") >= 0);

    }


    static String action = "";



static class physx{
    static void printquard(){
        System.out.print("Kvadrat");
    }
}


IDE(String fname, String projtype){
    ff=new File(fname);
}

    public static void init() throws UnsupportedLookAndFeelException {


        UIManager.setLookAndFeel(new WebLookAndFeel());

        try {
            BufferedImage imgg = ImageIO.read(IDE.class.getClassLoader().getResource("ico.png"));
            ImageIcon icon = new ImageIcon(imgg);
            frame.setIconImage(icon.getImage());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setUndecorated(false);

        JPanel p1 = new JPanel();


        JTable table = new JTable();


        p1.setLayout(new BorderLayout());
        p2.setLayout(new BorderLayout());


        frame.setPreferredSize(new Dimension(640, 480));
        JMenuBar menuBar = new JMenuBar();



        JMenu file = new JMenu("File");

        JMenu help = new JMenu("Help");

        JMenu tocode = new JMenu("To Code...");

        JMenu settings = new JMenu("Settings");


        area.setForeground(Color.BLACK);





        JButton run = new JButton("Run");


        JMenuItem open = new JMenuItem("Open file", KeyEvent.VK_O);

        open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
        JMenuItem create = new JMenuItem("Create file", KeyEvent.VK_N);

        create.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
        JMenuItem save = new JMenuItem("Save file", KeyEvent.VK_S);

        save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
        JMenuItem info = new JMenuItem("Info", KeyEvent.VK_I);

        info.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_DOWN_MASK));
        JMenuItem print = new JMenuItem("Print", KeyEvent.VK_P);

        print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_DOWN_MASK));


        area.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if ((e.getKeyCode() == KeyEvent.VK_V) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {

                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if ((e.getKeyCode() == KeyEvent.VK_V) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {

                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if ((e.getKeyCode() == KeyEvent.VK_V) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {

                }
            }
        });

        JMenuItem topng = new JMenuItem("PNG");
        JMenuItem tojpg = new JMenuItem("JPG");
        JMenuItem tojava = new JMenuItem("to Java");
        JMenuItem tosvg = new JMenuItem("SVG");
        JMenuItem licensing = new JMenuItem("License");


        JFileChooser chooser = new JFileChooser();

        file.add(open);
        file.add(save);
        file.add(create);
        file.add(print);


        help.add(info);
        help.add(licensing);

        JMenuItem font = new JMenuItem("Font size");

        settings.add(font);


        menuBar.add(file);
        menuBar.add(run);
        menuBar.add(help);
        menuBar.add(settings);

        area.setAutoscrolls(true);


        pane.setEditable(false);
        pane.setText("STATUS: Coming soon...");
        pane.setSelectionColor(Color.BLUE);
        pane.setForeground(Color.white);

        p1.add(menuBar, "North");


        p1.add(pane, "South");


        p2.add(area, "Center");

        Font fo = new Font("Century Gothic", Font.BOLD, 20);
        Font fo1 = new Font("Century Gothic", Font.PLAIN, 20);
        area.setFont(fo);
       // left.setFont(fo1);
        frame.setFont(fo1);
        pane.setFont(fo);
        menuBar.setFont(fo1);

        RTextScrollPane scrollPane = new RTextScrollPane(area,true,Color.BLACK);
        scrollPane.setFont(new Font(Font.DIALOG,Font.BOLD,25));

        p1.add(scrollPane, "Center");

        area.setEditable(false);

        JPopupMenu jpu = new JPopupMenu();
        JMenuItem cut = new JMenuItem("Cut");
        JMenuItem copy = new JMenuItem("Copy");
        JMenuItem paste = new JMenuItem("Paste");

        jpu.add(cut);
        jpu.add(copy);
        jpu.add(paste);

       help.setFont(new Font(Font.DIALOG,Font.BOLD,20));
        file.setFont(new Font(Font.DIALOG,Font.BOLD,20));
        run.setFont(new Font(Font.DIALOG,Font.BOLD,20));
        settings.setFont(new Font(Font.DIALOG,Font.BOLD,20));
        info.setFont(new Font(Font.DIALOG,Font.BOLD,20));
        licensing.setFont(new Font(Font.DIALOG,Font.BOLD,20));
        open.setFont(new Font(Font.DIALOG,Font.BOLD,20));
        create.setFont(new Font(Font.DIALOG,Font.BOLD,20));
        save.setFont(new Font(Font.DIALOG,Font.BOLD,20));
        font.setFont(new Font(Font.DIALOG,Font.BOLD,20));
        print.setFont(new Font(Font.DIALOG,Font.BOLD,20));

        area.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVASCRIPT);
        area.setHighlightCurrentLine(false);

        licensing.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame jFrame = new JFrame("License");
                BufferedImage icon = null;
                try {
                    icon = ImageIO.read(IDE.class.getClassLoader().getResource("ico.png"));
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                jFrame.setIconImage(icon);
                jFrame.setPreferredSize(new Dimension(520, 420));
                JTextArea l = new JTextArea();
                l.setFont(new Font("Times New Roman",Font.PLAIN,15));
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
                jFrame.add(new JScrollPane(l));
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
                JFrame jFrame = new JFrame("Font size");
                JPanel panel = new JPanel();
                JPanel po = new JPanel();
                JTextField f1 = new JTextField(area.getFont().getSize());
                GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
                String fontNames[] = environment.getAvailableFontFamilyNames();
                JComboBox l1 = new JComboBox();
                l1.setFont(new Font(Font.DIALOG,Font.BOLD,20));
                l1.setEditable(true);
                f1.setText(Integer.toString(area.getFont().getSize()));
                l1.addItem(area.getFont().getFamily());
                for (int i = 0; i < fontNames.length; i++) {
                    l1.addItem(fontNames[i]);
                }
                JMenuItem button = new JMenuItem("Apply");
                button.setFont(new Font(Font.DIALOG,Font.BOLD,20));

                panel.setLayout(new BorderLayout());
                po.setLayout(new BorderLayout());

                po.add(f1, "North");
                po.add(l1, "South");

                panel.add(po, "Center");
                panel.add(button, "South");
                jFrame.setIconImage(imgg);

                button.addActionListener(e12 -> {
                    area.setFont(new Font(l1.getSelectedItem().toString(), 1, Integer.parseInt(f1.getText())));
                    jFrame.setVisible(false);
                });

                jFrame.add(panel);
                jFrame.setPreferredSize(new Dimension(400, 140));
                jFrame.setResizable(false);
                jFrame.pack();

                jFrame.setVisible(true);
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


        open.addActionListener(e -> {
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
                    if (ff != null) {
                        area.setEditable(true);

                        try {
                            Scanner s = new Scanner(new File(ff.getAbsolutePath()));
                            String str="";
                            while (s.hasNext()){
                                str+=s.nextLine()+"\n";
                            }
                            if (str.length()>0) str=str.substring(0,str.length()-1);
                            area.setText(str);
                        } catch (FileNotFoundException e1) {
                            e1.printStackTrace();
                        }
                        isreading = false;
                        frame.setTitle("LabX v0.1 [" + ff.getName() + "]");

                        pane.setText("STATUS: Coming soon...");
                        frame.repaint();
                    }

                }
            }
        });

        save.addActionListener(e -> {
            if (e.getSource() == save && ff!=null) {
                    String name = "";
                    char c = ' ';
                    int i = 0;

                    pane.setText("STATUS: saving");
                    chooser.setDialogTitle("Save file");
                    //chooser.setSelectedFile(new File(ff.getName()));

                    pane.setText("STATUS: Coming soon...");
                    String s = "";


                    int sub = ff.getName().lastIndexOf(".");
                    String okn = ".labx";

                    if (sub > 0) {
                        ff = new File(s + ff.getName().substring(0, sub) + okn);
                    } else ff = new File(s + ff.getName() + okn);
                    System.out.println(ff.getName());
                    chooser.setSelectedFile(new File(ff.getAbsolutePath()));
                    chooser.setDialogType(JFileChooser.SAVE_DIALOG);

                    int res = chooser.showSaveDialog(chooser);
                    if (res == JFileChooser.APPROVE_OPTION) {
                        ff = chooser.getSelectedFile();
                        sub = ff.getName().lastIndexOf(".");
                        okn = ".labx";
                        if (sub > 0) {
                            ff = new File(s + ff.getName().substring(0, sub) + okn);
                        } else ff = new File(s + ff.getName() + okn);
                        PrintWriter w1 = null;
                        try {
                            // System.out.println(ff.getAbsolutePath());
                            ff.createNewFile();
                            w1 = new PrintWriter(ff.getAbsoluteFile());
                            w1.print(area.getText());
                            w1.flush();
                            w1.close();
                        } catch (FileNotFoundException e1) {
                            e1.printStackTrace();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    }

            }
            if (ff==null){
                JOptionPane.showMessageDialog(frame,"Please, create or choose a file!");
            }
        });




        run.addActionListener(e -> {

        });



            create.addActionListener(e -> {
                if (e.getSource() == create) {
                    JDialog creat = new JDialog();
                    creat.setTitle("Create new file");
                    BufferedImage imgg = null;
                    try {
                        imgg = ImageIO.read(IDE.class.getClassLoader().getResource("ico.png"));
                        ImageIcon icon = new ImageIcon(imgg);
                        creat.setIconImage(icon.getImage());
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    creat.setPreferredSize(new Dimension(300,120));
                    JPanel p = new JPanel();
                    JTextField name = new JTextField(15);
                   JButton ok  = new JButton("Ok");
                   JButton cancel = new JButton("Cancel");
                    ok.setFont(new Font(Font.DIALOG,Font.BOLD,20));
                    ok.setBackground(Color.BLUE);
                    name.setFont(new Font(Font.DIALOG,Font.BOLD,20));
                    cancel.setFont(new Font(Font.DIALOG,Font.BOLD,20));
                    p.add(name,"North");
                    p.add(ok,"South");
                    p.add(cancel,"south");
                    creat.setResizable(false);
                    creat.pack();


                    cancel.addActionListener(e13 -> {
                        creat.setVisible(false);
                        creat.dispose();

                    });
                    ok.addActionListener(e14 -> {
                                if (!name.getText().equals("")){
                                    area.setEditable(true);
                                    ff=new File(name.getText()+".labx");
                                    frame.setTitle("LabX v0.1 [" + ff.getName() + "]");
                                    creat.setVisible(false);
                                    creat.dispose();
                                } else{
                                    JOptionPane.showMessageDialog(frame,"Please, type a valid name of the file!");
                                }

                            }
                    );

                    creat.add(p);
                    creat.setModal(true);
                    creat.setLocation(frame.getX()+frame.getWidth()/2-creat.getWidth()/2,frame.getY()+frame.getHeight()/2-creat.getHeight()/2);




                    area.setText("");
                    creat.setVisible(true);
                }


            });


            info.addActionListener((ActionEvent e) -> {
                JFrame F = new JFrame("Info");
               //Some information about LabX
                JFXPanel pane1 = new JFXPanel();
                //HTMLEditorKit kit  =new HTMLEditorKit();

                //pane1.setEditable(false);

                pane1.setFont(new Font(Font.DIALOG, Font.PLAIN, 15));

                JScrollPane scrollPane1 = new JScrollPane(pane1);

                int ii = 0;



                Platform.runLater(() -> {
                    WebView webView = new WebView();
                    pane1.setScene(new Scene(webView));
                    webView.getEngine().load(IDE.class.getResource("doc/PhysX_Docomentation_v0.1.html").toExternalForm());
                });

                scrollPane1.getHorizontalScrollBar().setValue(scrollPane1.getHorizontalScrollBar().getMaximum()/2);
                F.add(scrollPane1);

                F.setPreferredSize(new Dimension(680, 780));

                F.pack();
                F.setVisible(true);
                F.repaint();
            });


            frame.setPreferredSize(new Dimension((int) screenSize.getWidth() / 2, (int) screenSize.getHeight() / 2));

            frame.setLocationByPlatform(true);
            frame.add(p1);
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);


        }


        public static void main(String args[]) throws Exception {
            BufferedReader inFile;

            SwingUtilities.invokeLater(() -> {


                try {
                   init();

                } catch (UnsupportedLookAndFeelException e) {
                    e.printStackTrace();
                }


            });


        }




}
