import com.alee.laf.WebLookAndFeel;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebView;

import javax.imageio.ImageIO;
import javax.media.CannotRealizeException;
import javax.media.Manager;
import javax.media.NoPlayerException;
import javax.media.Player;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by mikha on 13.02.2018.
 */
public class WIZARD {
    static JFrame frame;
    static IDE ide;
    static void init() throws UnsupportedLookAndFeelException{
        frame= new JFrame("LabX v0.1");
        try {
            UIManager.setLookAndFeel(new WebLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        Image im3=null;
        Image im4=null;
        Image im5=null;
        Image im6=null;
        try {
            BufferedImage imgg = ImageIO.read(WIZARD.class.getClassLoader().getResource("ico.png"));
            im3 = ImageIO.read(WIZARD.class.getClassLoader().getResource("video.png"));
            im4= ImageIO.read(WIZARD.class.getClassLoader().getResource("Chinematics.png"));
            im5= ImageIO.read(WIZARD.class.getClassLoader().getResource("Dynamics.png"));
            im6=ImageIO.read(WIZARD.class.getClassLoader().getResource("Statics.png"));
            im3= im3.getScaledInstance(20,20,1);
            ImageIcon icon = new ImageIcon(imgg);
            frame.setIconImage(icon.getImage());
        } catch (IOException e) {
            e.printStackTrace();
        }
        JPanel mpanel = new JPanel(new BorderLayout());
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1,3));
        JButton chenematics = new JButton();
        chenematics.setIcon(new ImageIcon(im4));
        JButton dynamics = new JButton();
        dynamics.setIcon(new ImageIcon(im5));
        JButton statics = new JButton();
        statics.setIcon(new ImageIcon(im6));
        panel.add(chenematics);
        panel.add(dynamics);
        panel.add(statics);
        mpanel.add(panel,"Center");
        JPanel footer = new JPanel(new BorderLayout());
        JMenuBar bar = new JMenuBar();

        JButton openp = new JButton("Open project");
        JButton info = new JButton("?");
        info.setToolTipText("Get information about LabX");
        JButton video = new JButton();
        video.setToolTipText("View a simple tutorial");
        bar.add(openp);
        bar.add(info);
        bar.add(video);
        openp.addActionListener(e -> {
            SwingUtilities.invokeLater(()->{
                try {
                    IDE.init();
                } catch (UnsupportedLookAndFeelException e1) {
                    e1.printStackTrace();
                }
            });

                IDE.isreading = true;
            IDE.isinit = false;
            IDE.area.setText("");
            IDE.pane.setText("STATUS: opening...");
            JFileChooser chooser= new JFileChooser();
            chooser.setDialogTitle("Open file");
            chooser.setApproveButtonText("Open");
            //chooser.setSelectedFile(new File(IDE.ff.getName()));
                int approw = chooser.showSaveDialog(null);

                if (approw == JFileChooser.APPROVE_OPTION) {
                    IDE.ff = chooser.getSelectedFile();
                    if (IDE.ff != null) {
                        IDE.area.setEditable(true);

                        try {
                            Scanner s = new Scanner(new File(IDE.ff.getAbsolutePath()));
                            String str="";
                            while (s.hasNext()){
                                str+=s.nextLine()+"\n";
                            }
                            if (str.length()>0) str=str.substring(0,str.length()-1);
                            IDE.area.setText(str);
                        } catch (FileNotFoundException e1) {
                            e1.printStackTrace();
                        }
                        IDE.isreading = false;
                        frame.setTitle("LabX v0.1 [" + IDE.ff.getName() + "]");

                        IDE.pane.setText("STATUS: Coming soon...");
                        frame.repaint();
                    }

                }
                //ide = new IDE(IDE.ff.getName(),"",false);
        });


        video.setIcon(new ImageIcon(im3));

          footer.add(bar,"West");
        mpanel.add(footer,"South");


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

            //scrollPane1.getHorizontalScrollBar().setValue(scrollPane1.getHorizontalScrollBar().getMaximum() / 2);
            F.add(scrollPane1);

            F.setPreferredSize(new Dimension(680, 780));

            F.pack();
            F.setVisible(true);
            F.repaint();


        });
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setPreferredSize(new Dimension((int) screenSize.getWidth() / 5 * 2, (int) screenSize.getHeight() / 9*4));
        frame.setLocationByPlatform(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(mpanel);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String args[]) throws Exception{
        SwingUtilities.invokeLater(() -> {
            try {
                init();
            } catch (UnsupportedLookAndFeelException e) {
                e.printStackTrace();
            }
        });
    }
}
