//package scripter;

import com.alee.laf.WebLookAndFeel;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebView;
import javax.imageio.ImageIO;
import javax.script.*;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rtextarea.RTextScrollPane;
import org.fife.*;

/**
 * Created by mikha on 08.03.2017.
 */
public class IDE {
    static {
//        disableSSLVerification();
    }

    static class words {
        String name, description, rusdescription;
    }

   // public static JTextArea left = new JTextArea();
    public static ArrayList<String> list = new ArrayList<>();
    public static JTextField t = new JTextField();
    public static String string = "ECMAScript";
    public static JButton bb = new JButton("Chose");
    public static boolean isinit = false;
    public static File ff;
    private static int strings = 1;
    private static int cou = 9;
    //public static JEditorPane area = new JEditorPane();
    public static RSyntaxTextArea area = new RSyntaxTextArea();
    public static JLabel l = new JLabel();
    public static JTextPane pane = new JTextPane();
    public static ArrayList<words> comands = new ArrayList<>();
    static int h = 1000;
    static int w = 1000;
    public static boolean ERR = false;
    public static boolean isreading = false;
    static int Strok = 1;
    public static int lastint = 1;
    public static char lastkey = ' ';
    public static JProgressBar bar = new JProgressBar();
    public static JPanel p2 = new JPanel();
    public HashMap map = new HashMap();
    static String curpath = "";
    static JFrame frame = new JFrame("ECMAScripter v0.1 - "+string);
    public static String inform;
    public static boolean bol = false;

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

    // public static   String Comands[] ={"",""};
    static String action = "";



static class physx{
    static void printquard(){
        System.out.print("Kvadrat");
    }
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
        //JTextArea area = new JTextArea();


        //scrollPane.add(left);
        //  scrollPane.add(area);


        JMenu file = new JMenu("File");
        // JMenu compile = new JMenu("Export");
        JMenu help = new JMenu("Help");

        //JMenu toimg = new JMenu("To Image...");
        JMenu tocode = new JMenu("To Code...");

        JMenu settings = new JMenu("Settings");

        //area.setBackground(Color.darkGray);
        //area.setCaretColor(Color.WHITE);
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
                 //   numirating('+');
                    //   highlight();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if ((e.getKeyCode() == KeyEvent.VK_V) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
                  //  numirating('+');
                    //   highlight();
                    action = "ctrlv";
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if ((e.getKeyCode() == KeyEvent.VK_V) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
               //     numirating('+');
                    //  highlight();
                }
            }
        });

        JMenuItem topng = new JMenuItem("PNG");
        JMenuItem tojpg = new JMenuItem("JPG");
        JMenuItem tojava = new JMenuItem("to Java");
        JMenuItem tosvg = new JMenuItem("SVG");
        JMenuItem licensing = new JMenuItem("License");
        JMenuItem wh = new JMenuItem("Width & Height");

        JFileChooser chooser = new JFileChooser();

        file.add(open);
        file.add(save);
        file.add(create);
        file.add(print);


        help.add(info);
        help.add(licensing);

        JMenuItem font = new JMenuItem("Font size");
        JMenuItem script = new JMenuItem("Script");
        settings.add(wh);
        settings.add(font);
        settings.add(script);

        menuBar.add(file);
        // menuBar.add(compile);
        menuBar.add(run);
        menuBar.add(help);
        menuBar.add(settings);
        //  menuBar.add(settings);

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
        //JScrollPane scrollPane = new JScrollPane(p2);


        //scrollPane.setAutoscrolls(true);
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
        wh.setFont(new Font(Font.DIALOG,Font.BOLD,20));
        font.setFont(new Font(Font.DIALOG,Font.BOLD,20));
        print.setFont(new Font(Font.DIALOG,Font.BOLD,20));
        script.setFont(new Font(Font.DIALOG,Font.BOLD,20));

        area.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVASCRIPT);
        area.setHighlightCurrentLine(false);
        frame.setUndecorated(true);

        licensing.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame jFrame = new JFrame("License");
                jFrame.setPreferredSize(new Dimension(520, 400));
                JTextArea l = new JTextArea();
                l.setEditable(false);
                jFrame.setResizable(false);
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
                jFrame.add(l);
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

                jFrame.add(panel);
                jFrame.setResizable(false);
                jFrame.setVisible(true);
                jFrame.setPreferredSize(new Dimension(400, 140));
                jFrame.pack();


                button.addActionListener(e12 -> {

                    area.setFont(new Font(l1.getSelectedItem().toString(), 1, Integer.parseInt(f1.getText())));
                  //  left.setFont(new Font(l1.getSelectedItem().toString(), 1, Integer.parseInt(f1.getText())));
                    jFrame.setVisible(false);
                });
                //  highlight();

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
                l1.setEditable(true);
                l1.addItem(area.getFont().getFamily());
                for (int i = 0; i < fontNames.length; i++) {
                    l1.addItem(fontNames[i]);
                }
                JMenuItem button = new JMenuItem("Apply");

                panel.setLayout(new BorderLayout());
                po.setLayout(new BorderLayout());

                po.add(f1, "North");
                po.add(l1, "South");

                panel.add(po, "Center");
                panel.add(button, "South");
                jFrame.setIconImage(imgg);

                jFrame.add(panel);

                jFrame.setVisible(true);
                jFrame.setPreferredSize(new Dimension(400, 140));

                button.addActionListener(e12 -> {

                    area.setFont(new Font(l1.getSelectedItem().toString(), 1, Integer.parseInt(f1.getText())));
                 //   left.setFont(new Font(l1.getSelectedItem().toString(), 1, Integer.parseInt(f1.getText())));
                    jFrame.setVisible(false);
                });
                //  highlight();

            }
        });

        cut.addActionListener(e -> {
            if (e.getSource() == cut) {
                action = "cut";
                area.cut();
            //    numirating('-');
                //   highlight();
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
                action = "paste";
                area.paste();
             //   numirating('+');
                // highlight();
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

             //   left.setText("");
                isreading = true;
                isinit = false;
                area.setText("");
                pane.setText("STATUS: opening...");
                chooser.setDialogTitle("Open file");
                chooser.setApproveButtonText("Open");
                int approw = chooser.showSaveDialog(null);

                if (approw == JFileChooser.APPROVE_OPTION) {
                    ff = chooser.getSelectedFile();
                    if (ff != null) {
                        area.setEditable(true);

                        isreading = false;
                        frame.setTitle("ECMAScripter v0.1 [" + ff.getName() + "]");
                    }
                }
                pane.setText("STATUS: Coming soon...");
                frame.repaint();
                isreading = false;
                frame.setTitle("ECMAScripter v0.1 [" + ff.getName() + "] - "+string);
            }
        });

        save.addActionListener(e -> {
            if (e.getSource() == save ) {
                String name = "";
                char c = ' ';
                int i = 0;
                ff=chooser.getSelectedFile();
                pane.setText("STATUS: saving");
                chooser.setDialogTitle("Save file");
                pane.setText("STATUS: Coming soon...");
                String s="";
                  if (ff.exists()){
                      s = ff.getParent();
                      if (isWindows()) s += "\\";
                      else s += "/";
                  }


                    int sub = ff.getName().lastIndexOf(".");
                    String okn="";
                    switch (string) {
                        case "python":
                            okn = ".py";
                            break;
                        case "ruby":
                            okn = ".rb";
                            break;
                        case "Kotlin":
                            okn = ".kt";
                            break;
                        case "Groovy":
                            okn = ".groovy";
                            break;
                        case "ECMAScript":
                            okn=".js";
                            break;
                    }
                if (sub > 0) {
                    ff = new File(s + ff.getName().substring(0, sub)+okn);
                } else ff = new File(s + ff.getName() + okn);
                System.out.println(ff.getName());
                chooser.setSelectedFile(new File(ff.getAbsolutePath()));


                int res = chooser.showSaveDialog(chooser);
                    if (res == JFileChooser.APPROVE_OPTION){
                        ff=chooser.getSelectedFile();
                       sub = ff.getName().lastIndexOf(".");
                        okn="";
                        switch (string) {
                            case "python":
                                okn = ".py";
                                break;
                            case "ruby":
                                okn = ".rb";
                                break;
                            case "Kotlin":
                                okn = ".kt";
                                break;
                            case "Groovy":
                                okn = ".groovy";
                                break;
                            case "ECMAScript":
                                okn=".js";
                                break;
                        }
                        if (sub > 0) {
                            ff = new File(s + ff.getName().substring(0, sub)+okn);
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

        });




        run.addActionListener(e -> {

        });



            create.addActionListener(e -> {
                if (e.getSource() == create) {
                    lastint = 0;

                    area.setEditable(true);
                   chooser.setDialogTitle("Create new file");
                    chooser.setDialogType(JFileChooser.CUSTOM_DIALOG);
                    chooser.setApproveButtonText("Create");
                    ff=null;
                    int res = chooser.showSaveDialog(chooser);

                    if (ff != null) {
                        frame.setTitle("ECMAScripter v0.1 [" + ff.getName()+".js" + "]");
                    }

                    area.setText("");

                    lastint = 1;

                }

            });


            info.addActionListener((ActionEvent e) -> {
                JFrame F = new JFrame("Info");
                JTabbedPane p11 = new JTabbedPane();
                p11.setFont(new Font(Font.DIALOG,Font.BOLD,20));
                F.add(p11);

                JFXPanel pane1 = new JFXPanel();

                pane1.setFont(new Font(Font.DIALOG, Font.PLAIN, 15));

                JScrollPane scrollPane1 = new JScrollPane(pane1);

                int ii = 0;



                    Platform.runLater(() -> {
                        WebView webView = new WebView();
                       pane1.setScene(new Scene(webView));
                        webView.getEngine().load("https://www.ecma-international.org/ecma-262/5.1/");
                    });



                JFXPanel pane2 = new JFXPanel();
                Platform.runLater(() -> {
                    WebView webView = new WebView();
                    pane2.setScene(new Scene(webView));
                    webView.getEngine().load("https://wiki.python.org/jython/UserGuide");
                });

                p11.addTab("JS",scrollPane1);

                JScrollPane scrollpane2 = new JScrollPane(pane2);
                p11.addTab("JPython",scrollpane2);


                JFXPanel pane3 = new JFXPanel();
                Platform.runLater(() -> {
                    WebView webView = new WebView();
                    pane3.setScene(new Scene(webView));
                    webView.getEngine().load("http://groovy-lang.org/syntax.html");
                });

                JScrollPane scrollpane3 = new JScrollPane(pane3);
                p11.addTab("Groovy",scrollpane3);

                try {
                    BufferedImage imgg = ImageIO.read(IDE.class.getClassLoader().getResource("ico.png"));
                    ImageIcon icon = new ImageIcon(imgg);
                    F.setIconImage(icon.getImage());
                } catch (IOException ee) {
                    ee.printStackTrace();
                }
                F.add(p11);

                F.setPreferredSize(new Dimension(1200, 750));

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
