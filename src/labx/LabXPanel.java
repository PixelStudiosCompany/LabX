package labx;
import javax.script.*;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.StringWriter;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;


/**
 * Created by mikha on 22.02.2018.
 */
public class LabXPanel extends JPanel {
    TimerTask tt = new TimerTask() {

        @Override
        public void run() {
            // тут наш код
        }
    };

    public class engineThread extends Thread{
        public void run(){

             sw = new StringWriter();
            b.put("sw",sw);
            engine.getContext().setWriter(sw);
            try {
                engine.eval(finproj,b);
                engine.getContext().getWriter().flush();
            } catch (ScriptException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            out=sw.toString();

        }
    }
    String predcode;
    String maincode;
String finproj;
  String out;
  engineThread t;
    StringWriter sw = new StringWriter();
    ScriptEngine engine= new ScriptEngineManager().getEngineByName("js");
    Bindings b = new SimpleBindings();
    void process(String s) throws ScriptException, IOException {
        s=Definizer.Define(s);
        paintComponent(this.getGraphics());
        finproj=Definizer.finprog;
        engine.getContext().setWriter(sw);
        b= new SimpleBindings();

        b.put("TUNIT", TimeUnit.MILLISECONDS);
        b.put("pane",WIZARD.ide.get(0).pane);

        t = new engineThread();
        t.start();

    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        for (int i=0;i<Definizer.ObjMap.values().size();i++){
          Definizer.object o = (Definizer.object) Definizer.ObjMap.values().toArray()[i];
          g.draw3DRect(o.x,o.y,100,100,true);
        }

    }
}
