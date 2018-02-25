import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;
import javax.swing.*;
import java.awt.*;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.StringTokenizer;


/**
 * Created by mikha on 22.02.2018.
 */
public class LabXPanel extends JPanel {
    String predcode;
    String maincode;
    void process(String s){
        s=Definizer.Define(s);
        paintComponent(this.getGraphics());

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
