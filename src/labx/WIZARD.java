package labx;

import com.alee.laf.WebLookAndFeel;
import com.chrisrm.idea.MTLaf;
import com.chrisrm.idea.MTLightLaf;
import com.chrisrm.idea.MTThemes;
import com.chrisrm.idea.themes.MTThemeable;
import de.javasoft.plaf.synthetica.SyntheticaPlainLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaWhiteVisionLookAndFeel;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebView;
import mdlaf.MaterialLookAndFeel;


import javax.imageio.ImageIO;


import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.synth.SynthLookAndFeel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import de.javasoft.*;


/**
 * Created by mikha on 13.02.2018.
 */
public class WIZARD {
    static double deffontsize = UIManager.getDefaults().getFont("TabbedPane.font").getSize() + 5;
    static String defkatalog="";
    static JFrame frame;
    static ArrayList<IDE> ide = new ArrayList<>();

    static JButton dynamics;
    static JButton statics;
    static JButton chenematics;
    static JButton empty;

    static void doDynamics() {
        //dynamics.doClick();
        JDialog creat = new JDialog();
        creat.setTitle("Создать проект");
        BufferedImage imgg = null;
        try {
            imgg = ImageIO.read(WIZARD.class.getClassLoader().getResource("ico.png"));
            ImageIcon icon = new ImageIcon(imgg);
            creat.setIconImage(icon.getImage());
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        creat.setPreferredSize(new Dimension((int) (frame.getWidth() / 4), (int) (frame.getWidth() / 5 / 1.6)));
        JPanel p = new JPanel();
        JTextField name = new JTextField(15);
        JButton ok = new JButton("Ok");
        creat.getRootPane().setDefaultButton(ok);
        JButton cancel = new JButton("Отмена");
        ok.setFont(new Font(Font.DIALOG, Font.BOLD, (int) deffontsize));
        ok.setBackground(Color.BLUE);
        name.setFont(new Font(Font.DIALOG, Font.BOLD, (int) deffontsize));
        cancel.setFont(new Font(Font.DIALOG, Font.BOLD, (int) deffontsize));
        p.add(name, "North");
        p.add(ok, "South");
        p.add(cancel, "south");
        creat.setResizable(false);
        creat.pack();
        final File[] ff = {null};


        cancel.addActionListener(e13 -> {
            creat.setVisible(false);
            creat.dispose();

        });
        ok.addActionListener(e14 -> {
                    if (!name.getText().equals("")) {
                        ff[0] = new File(name.getText() + ".labx");
                        String temp = "var a : object(10,10,10,0,0,0,0,\"red\");\nvar f : force(50,50);\nsetforce(a,f);";
                        ide.add(new IDE(ff[0].getName(), "", false, ide.size(), temp));
                        ide.get(ide.size() - 1).source = temp;
                        // ide.get(ide.size() - 1).LoadTextFromFile(ff[0]);

                        frame.setTitle("LabX v0.1 [" + ff[0].getName() + "]");
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


        creat.setVisible(true);
    }


    static void doStatics() {
        // statics.doClick();
        JDialog creat = new JDialog();
        creat.setTitle("Создать проект");
        BufferedImage imgg = null;
        try {
            imgg = ImageIO.read(WIZARD.class.getClassLoader().getResource("ico.png"));
            ImageIcon icon = new ImageIcon(imgg);
            creat.setIconImage(icon.getImage());
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        creat.setPreferredSize(new Dimension((int) (frame.getWidth() / 4), (int) (frame.getWidth() / 5 / 1.6)));
        JPanel p = new JPanel();
        JTextField name = new JTextField(15);
        JButton ok = new JButton("Ok");
        creat.getRootPane().setDefaultButton(ok);
        JButton cancel = new JButton("Cancel");
        ok.setFont(new Font(Font.DIALOG, Font.BOLD, (int) deffontsize));
        ok.setBackground(Color.BLUE);
        name.setFont(new Font(Font.DIALOG, Font.BOLD, (int) deffontsize));
        cancel.setFont(new Font(Font.DIALOG, Font.BOLD, (int) deffontsize));
        p.add(name, "North");
        p.add(ok, "South");
        p.add(cancel, "south");
        creat.setResizable(false);
        creat.pack();
        final File[] ff = {null};


        cancel.addActionListener(e13 -> {
            creat.setVisible(false);
            creat.dispose();

        });
        ok.addActionListener(e14 -> {
                    if (!name.getText().equals("")) {
                        ff[0] = new File(name.getText() + ".labx");
                        String temp = "";
                        ide.add(new IDE(ff[0].getName(), "", false, ide.size(), temp));
                        ide.get(ide.size() - 1).source = temp;
                        // ide.get(ide.size() - 1).LoadTextFromFile(ff[0]);

                        frame.setTitle("LabX v0.1 [" + ff[0].getName() + "]");
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


        creat.setVisible(true);
    }

    static void doEmpty() {
        //chenematics.doClick();
        JDialog creat = new JDialog();
        creat.setTitle("Создать проект");
        BufferedImage imgg = null;
        try {
            imgg = ImageIO.read(WIZARD.class.getClassLoader().getResource("ico.png"));
            ImageIcon icon = new ImageIcon(imgg);
            creat.setIconImage(icon.getImage());
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        creat.setPreferredSize(new Dimension((int) (frame.getWidth() / 4), (int) (frame.getWidth() / 5 / 1.6)));
        JPanel p = new JPanel();
        JTextField name = new JTextField(15);
        JButton ok = new JButton("Ok");
        creat.getRootPane().setDefaultButton(ok);
        JButton cancel = new JButton("Cancel");
        ok.setFont(new Font(Font.DIALOG, Font.BOLD, (int) deffontsize));
        ok.setBackground(Color.BLUE);
        name.setFont(new Font(Font.DIALOG, Font.BOLD, (int) deffontsize));
        cancel.setFont(new Font(Font.DIALOG, Font.BOLD, (int) deffontsize));
        p.add(name, "North");
        p.add(ok, "South");
        p.add(cancel, "south");
        creat.setResizable(false);
        creat.pack();
        final File[] ff = {null};


        cancel.addActionListener(e13 -> {
            creat.setVisible(false);
            creat.dispose();

        });
        ok.addActionListener(e14 -> {
                    if (!name.getText().equals("")) {
                        ff[0] = new File(name.getText() + ".labx");
                        ide.add(new IDE(ff[0].getName(), "", false, ide.size(), ""));
                        // ide.get(ide.size() - 1).LoadTextFromFile(ff[0]);

                        frame.setTitle("LabX v0.1 [" + ff[0].getName() + "]");
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


        creat.setVisible(true);
    }


    static void doChenematics() {
        //chenematics.doClick();
        JDialog creat = new JDialog();
        creat.setTitle("Создать проект");
        BufferedImage imgg = null;
        try {
            imgg = ImageIO.read(WIZARD.class.getClassLoader().getResource("ico.png"));
            ImageIcon icon = new ImageIcon(imgg);
            creat.setIconImage(icon.getImage());
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        creat.setPreferredSize(new Dimension((int) (frame.getWidth() / 4), (int) (frame.getWidth() / 5 / 1.6)));
        JPanel p = new JPanel();
        JTextField name = new JTextField(15);
        JButton ok = new JButton("Ok");
        creat.getRootPane().setDefaultButton(ok);
        JButton cancel = new JButton("Cancel");
        ok.setFont(new Font(Font.DIALOG, Font.BOLD, (int) deffontsize));
        ok.setBackground(Color.BLUE);
        name.setFont(new Font(Font.DIALOG, Font.BOLD, (int) deffontsize));
        cancel.setFont(new Font(Font.DIALOG, Font.BOLD, (int) deffontsize));
        p.add(name, "North");
        p.add(ok, "South");
        p.add(cancel, "south");
        creat.setResizable(false);
        creat.pack();
        final File[] ff = {null};


        cancel.addActionListener(e13 -> {
            creat.setVisible(false);
            creat.dispose();

        });
        ok.addActionListener(e14 -> {
                    if (!name.getText().equals("")) {
                        ff[0] = new File(name.getText() + ".labx");
                        String temp = "var a : object(10,10,10,0,0,0,9.8,\"red\");\n";
                        ide.add(new IDE(ff[0].getName(), "", false, ide.size(), temp));
                        //ide.get(ide.size() - 1).LoadTextFromFile(ff[0]);
                        ide.get(ide.size() - 1).source = temp;
                        frame.setTitle("LabX v0.1 [" + ff[0].getName() + "]");
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


        creat.setVisible(true);
    }


    static void init() throws UnsupportedLookAndFeelException {
        frame = new JFrame("LabX v0.1");
        try {

            UIManager.setLookAndFeel(new WebLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        Image im3 = null;
        Image im4 = null;
        Image im5 = null;
        Image im6 = null;
        try {
            BufferedImage imgg = ImageIO.read(WIZARD.class.getClassLoader().getResource("ico.png"));
            im3 = ImageIO.read(WIZARD.class.getClassLoader().getResource("video.png"));
            im4 = ImageIO.read(WIZARD.class.getClassLoader().getResource("KinematicsRU.png"));
            im5 = ImageIO.read(WIZARD.class.getClassLoader().getResource("DynamicsRU.png"));
            im6 = ImageIO.read(WIZARD.class.getClassLoader().getResource("Statics2RU.png"));
            im3 = im3.getScaledInstance(20, 20, 1);
            ImageIcon icon = new ImageIcon(imgg);
            frame.setIconImage(icon.getImage());
        } catch (IOException e) {
            e.printStackTrace();
        }
        JPanel mpanel = new JPanel(new BorderLayout());
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 3));
        chenematics = new JButton();
        chenematics.setIcon(new ImageIcon(im4));

        chenematics.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doChenematics();
            }
        });


        empty = new JButton("Пустой проект");
        empty.setFont(new Font(Font.DIALOG, Font.BOLD, (int) deffontsize));
        empty.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doEmpty();
            }
        });

        dynamics = new JButton();


        dynamics.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doDynamics();
            }
        });

        statics = new JButton();
        statics.setEnabled(false);


        statics.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doStatics();
            }
        });
        panel.add(chenematics);
        panel.add(dynamics);
        panel.add(statics);
        mpanel.add(panel, "Center");
        JPanel footer = new JPanel(new BorderLayout());
        JMenuBar bar = new JMenuBar();

        JButton openp = new JButton("Открыть проект");
        openp.setFont(new Font(Font.DIALOG, Font.BOLD, (int) deffontsize));
        JButton info = new JButton();
        Image is = null;
        try {
            is = ImageIO.read(WIZARD.class.getClassLoader().getResource("is.png"));
            is = is.getScaledInstance(20, 20, 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        info.setIcon(new ImageIcon(is));

        info.setToolTipText("Информация о LabX");
        JButton video = new JButton();
        video.setToolTipText("Посмотреть обучающее видео");
        bar.add(openp);
        bar.add(empty);
        bar.add(info);
        bar.add(video);
        openp.addActionListener(e -> {
            //this code throws exception when you close the IDE window
            JFileChooser chooser = new JFileChooser();
            File ff = null;
            chooser.setCurrentDirectory(new File(defkatalog));
            chooser.setDialogTitle("Открыть проект");
            chooser.setApproveButtonText("Открыть");
            //chooser.setSelectedFile(new File(ff.getName()));
            int approw = chooser.showSaveDialog(null);

            if (approw == JFileChooser.APPROVE_OPTION) {
                ff = chooser.getSelectedFile();
                ide.add(new IDE(ff.getAbsolutePath(), "", false, ide.size(), ""));
                ide.get(ide.size() - 1).LoadTextFromFile(ff);

            }

        });


        video.setIcon(new ImageIcon(im3));

        footer.add(bar, "West");
        mpanel.add(footer, "North");


        info.addActionListener((ActionEvent e) -> {
            JFrame F = new JFrame("Информация о LabX");
            //Some information about LabX
            try {
                Image imgg = ImageIO.read(IDE.class.getClassLoader().getResource("ico.png"));
                ImageIcon icon = new ImageIcon(imgg);
                F.setIconImage(icon.getImage());
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            JFXPanel pane1 = new JFXPanel();
            //HTMLEditorKit kit  =new HTMLEditorKit();


            pane1.setFont(new Font(Font.DIALOG, Font.PLAIN, (int) deffontsize));


            int ii = 0;


            Platform.runLater(() -> {
                WebView webView = new WebView();
                pane1.setScene(new Scene(webView));
                webView.getEngine().load(WIZARD.class.getResource("doc/LABX.html").toExternalForm());
            });
            JScrollPane scrollPane1 = new JScrollPane(pane1);
            //scrollPane1.getHorizontalScrollBar().setValue(scrollPane1.getHorizontalScrollBar().getMaximum() / 2);
            F.add(scrollPane1);

            F.setPreferredSize(new Dimension(780, 780));

            F.pack();
            F.setVisible(true);
            F.repaint();


        });
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setPreferredSize(new Dimension((int) screenSize.getWidth() / 7 * 2, (int) (screenSize.getWidth() / 7 * 2 / 1.7)));
        // frame.setLocationByPlatform(true);
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();


        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(mpanel);

        frame.setResizable(false);

        frame.pack();
        frame.setLocation((int) (screensize.getWidth() / 2 - frame.getWidth() / 2), (int) (screensize.getHeight() / 2 - frame.getHeight() / 2));
        im5 = im5.getScaledInstance((int) (dynamics.getWidth() * 0.9), (int) (dynamics.getWidth() * 0.9), 1);
        im6 = im6.getScaledInstance((int) (statics.getWidth() * 0.9), (int) (statics.getWidth() * 0.9), 1);
        im4 = im4.getScaledInstance((int) (chenematics.getWidth() * 0.9), (int) (chenematics.getWidth() * 0.9), 1);
        dynamics.setIcon(new ImageIcon(im5));
        statics.setIcon(new ImageIcon(im6));
        chenematics.setIcon(new ImageIcon(im4));


        //dynamics.add(svgDynamics,"CENTER");


        frame.setVisible(true);
    }

    public static void main(String args[]) throws Exception {
        Thread.sleep(500);

        SwingUtilities.invokeLater(() -> {
            try {
                try {

                    UIManager.setLookAndFeel(new WebLookAndFeel());
                } catch (UnsupportedLookAndFeelException e) {
                    e.printStackTrace();
                }
                File f = new File(System.getProperty("user.home")+"/.labx/properties");
                if (!f.exists()) {
                    File fe=new File(System.getProperty("user.home")+"/.labx");
                    fe.mkdir();
                    f.createNewFile();
                    JFrame f2 = new JFrame("Начальная установка");
                    JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
                    splitPane.setResizeWeight(0.3);
                    splitPane.setEnabled(false);
                    splitPane.setDividerSize(0);



                    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                    f2.setPreferredSize(new Dimension((int) screenSize.getWidth() / 9 * 2, (int) (screenSize.getWidth() / 7 * 2 / 1.7)));
                    JPanel lx = new JPanel();

                    JPanel controll = new JPanel();
                    controll.setBackground(Color.WHITE);
                    Image im = ImageIO.read(WIZARD.class.getClassLoader().getResource("pep.png"));

                    JLabel image = new JLabel();
                    im=im.getScaledInstance((int) (f2.getPreferredSize().getHeight()/2), (int) f2.getPreferredSize().getHeight(),1);
                    image.setIcon(new ImageIcon(im));
                    image.setPreferredSize(new Dimension((int) image.getWidth(),(int)image.getHeight()));

                    splitPane.add(image);

                    // f2.setResizable(false);
                    JEditorPane l = new JEditorPane();
                    l.setContentType("text/html");
                    l.setEditable(false);
                    l.setFont(new Font(Font.DIALOG,1, (int) deffontsize+4));
                    l.setText("<b><h1>Добро пожаловать в LabX v0.1.1!</h1> <p>Вы запускаете LabX в первый раз.</p>  <p>Выберете каталог хранения проектов.</p></b>");

                    JTextField fi = new JTextField(10);
                    fi.setText(System.getProperty("user.home"));
                    controll.add(l,"Center");
                    controll.add(fi,"South");
                    splitPane.add(controll);
                    f2.setResizable(false);

                    JButton set = new JButton("Сохранить");
                    controll.add(set);

                    set.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try {
                                FileWriter wr = new FileWriter(f);
                                wr.write(fi.getText()+"\\LabXProjects");
                                wr.flush();
                                wr.close();
                                File ff = new File(fi.getText()+"\\LabXProjects");
                                if (!ff.exists()){
                                    ff.mkdir();
                                }
                                defkatalog=ff.getAbsolutePath();

                                f2.setVisible(false);
                                init();
                            } catch (UnsupportedLookAndFeelException e1) {
                                e1.printStackTrace();
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        }
                    });

                    f2.add(splitPane);
                    f2.pack();
                    f2.setVisible(true);
                } else{
                    File fiv = new File(System.getProperty("user.home")+"\\.labx\\properties");
                    Scanner s = new Scanner(fiv);
                    String su = s.nextLine();
                    defkatalog=su;
                    init();
                }
            } catch (UnsupportedLookAndFeelException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
