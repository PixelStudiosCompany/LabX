package labx;

import javax.script.*;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;


/**
 * Created by mikha on 22.02.2018.
 */
public class LabXPanel extends JPanel {
    int w = 50;
    int h = 50;
    int stroke = 3;
    boolean enablegrid = false;
    boolean enambler = false;

    public static Color stringToColor(final String value) {
        if (value == null) {
            return Color.black;
        }
        try {
            // get color by hex or octal value
            return Color.decode(value);
        } catch (NumberFormatException nfe) {
            // if we can't decode lets try to get it by name
            try {
                // try to get a color by name using reflection
                final Field f = Color.class.getField(value);

                return (Color) f.get(null);
            } catch (Exception ce) {
                // if we can't get any color return black
                return Color.black;
            }
        }
    }

    int num = 0;

    LabXPanel(int num) {
        this.num = num;
    }

    TimerTask tt = new TimerTask() {

        @Override
        public void run() {
            // тут наш код
        }
    };


    public void updatePanel() {
        SwingUtilities.invokeLater(() -> {
            getParent().repaint();
        });
    }

    public class engineThread extends Thread {
        public void run() {

            sw = new StringWriter();
            b.put("sw", sw);
            engine.getContext().setWriter(sw);
            try {
                engine.eval(finproj, b);
                engine.getContext().getWriter().flush();
                paintComponent(WIZARD.ide.get(num).labXPanel.getGraphics());
                WIZARD.ide.get(num).pane.setText(String.valueOf(sw.getBuffer()));
                WIZARD.ide.get(num).pane.revalidate();
            } catch (ScriptException e) {
                e.printStackTrace();
                WIZARD.ide.get(num).pane.setText(e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }

            out = sw.toString();

        }
    }

    String predcode;
    String maincode;
    String finproj;
    String out;
    engineThread t;


    StringWriter sw = new StringWriter();
    ScriptEngine engine = new ScriptEngineManager().getEngineByName("js");
    Bindings b = new SimpleBindings();

    void process(String s) throws ScriptException, IOException {
        s = Definizer.Define(s, w, h);

        paintComponent(this.getGraphics());
        finproj = Definizer.finprog;
        System.out.println(finproj);
        engine.getContext().setWriter(sw);
        b = new SimpleBindings();

        b.put("TUNIT", TimeUnit.MILLISECONDS);
        b.put("pane", WIZARD.ide.get(num).pane);
        WIZARD.ide.get(num).strt.state = true;
        b.put("Running", WIZARD.ide.get(num).strt);
        b.put("ObjMap", Definizer.ObjMap);
        b.put("lab", WIZARD.ide.get(num).labXPanel);


        t = new engineThread();
        t.start();


    }

    @Override
    protected void paintComponent(Graphics g2d) {
        Graphics2D g = (Graphics2D) g2d;
        super.paintComponent(g);
        Color c = g.getColor();
        g.setColor(Color.white);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        g.setColor(c);
        g.setStroke(new BasicStroke(2));
        g.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
        if (enablegrid) {
            for (int i = 0; i < this.getWidth(); i += 100) {
                if (i != 0) g.drawString(String.valueOf(i / 100), i, 20);
                g.drawLine(i, 0, i, this.getHeight());
            }
            for (int i = 0; i < this.getHeight(); i += 100) {
                if (i != 0) g.drawString(String.valueOf(i / 100), 8, i);
                g.drawLine(0, i, this.getWidth(), i);
            }
        }
        for (int i = 0; i < Definizer.ObjMap.values().size(); i++) {
            Definizer.object o = (Definizer.object) Definizer.ObjMap.values().toArray()[i];
            String s = o.color.replace("\"", "");
            Color cc = stringToColor(s);
            g.setColor(cc);
            g.fillOval((int) (o.x) - w / 2, (int) (o.y) - h / 2, w, h);
            g.setColor(Color.BLACK);
            g.setStroke(new BasicStroke(stroke));
            g.drawOval((int) (o.x) - w / 2, (int) (o.y) - h / 2, w, h);


            for (int j = 0; j < o.forces.size(); j++) {
                Stroke st = g.getStroke();
                g.setStroke(new BasicStroke(stroke + 2));
                Definizer.force f = o.forces.get(j);
                double xforce = f.fx;
                double yforce = f.fy;

                if (xforce > 0) {
                    xforce = Math.log(xforce);
                } else {
                    if (xforce < 0) {
                        xforce = -Math.log(-xforce);
                    } else {
                        if (xforce == 0) {
                            xforce = 0;
                        }
                    }
                }
                if (yforce > 0) {
                    yforce = Math.log(yforce);
                } else {
                    if (yforce < 0) {
                        yforce = -Math.log(-yforce);
                    } else {
                        if (yforce == 0) {
                            yforce = 0;
                        }
                    }
                }
                xforce = xforce * w / 10;
                yforce = yforce * h / 10;


                double x = o.x - w / 2;
                double y = o.y - h / 2;
                int k = 5;
                double l = 5;

                double dl = Math.sqrt(xforce * xforce + yforce * yforce);

                double dlx = (yforce / dl) * k;
                double dly = -(xforce / dl) * k;
                double fx = -xforce / dl * k;
                double fy = -yforce / dl * k;

                g.drawLine((int) Math.round(x + xforce + w / 2), (int) Math.round(y + yforce + h / 2), (int) Math.round(x + xforce + w / 2 - dlx + fx), (int) Math.round(y + yforce + h / 2 - dly + fy));
                g.drawLine((int) Math.round(x + xforce + w / 2), (int) Math.round(y + yforce + h / 2), (int) Math.round(x + xforce + w / 2 + dlx + fx), (int) Math.round(y + yforce + h / 2 + dly + fy));
                g.drawLine((int) (x + w / 2), (int) (y + h / 2), (int) (x + xforce + w / 2), (int) (y + yforce + h / 2));
                g.setStroke(st);
            }

        }

    }
}
