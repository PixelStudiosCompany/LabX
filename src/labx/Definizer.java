package labx;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by mikha on 23.02.2018.
 */
public class Definizer {
  static   String objpattrn ="var[ ]+[a-z]+[ ]+[:]+[ ]*object[ ]*[(][ ]*([0-9])+[ ]*[,][ ]*([0-9])+[ ]*[,][ ]*([0-9])+[ ]*[,][ ]*([0-9])+[ ]*[,][ ]*([0-9])+[ ]*[,][ ]*([0-9])+[ ]*[,][ ]*([0-9])+[ ]*[,][ ]*([0-9])+[ ]*[,][ ]*([0-9])+[ ]*[,][ ]*([0-9])+[ ]*[)][;]";
   static String forcepattrn  = "var[ ]+[a-z]+[ ]+[:]+[ ]*force[ ]*[(][ ]*([0-9])+[ ]*[,][ ]*([0-9])+[ ]*[,][ ]*([0-9])+[ ]*[)][;]";
   static String vectpattrn = "var[ ]+[a-z]+[ ]+[:]+[ ]*vector[ ]*[(][ ]*([0-9])+[ ]*[,][ ]*([0-9])+[ ]*[,][ ]*([0-9])+[ ]*[)][;]";
    public static class object{
        int m;
        int x;
        int y;
        int z;
        int vx;
        int vy;
        int vz;
        int ax;
        int ay;
        int az;
        object(int m1,int x1,int y1,int z1,int vx1,int vy1,int vz1,int ax1,int ay1,int az1){
            m=m1;
            x=x1;
            y=y1;
            z=z1;
            vx=vx1;
            vy=vy1;
            vz=vz1;
            ax=ax1;
            ay=ay1;
            az=az1;
        }

        public void set(int m1,int x1,int y1,int z1,int vx1,int vy1,int vz1,int ax1,int ay1,int az1) {
            m=m1;
            x=x1;
            y=y1;
            z=z1;
            vx=vx1;
            vy=vy1;
            vz=vz1;
            ax=ax1;
            ay=ay1;
            az=az1;
        }
    }
    public static class force{
        int fx;
        int fy;
        int fz;
        force(int fx1,int fy1,int fz1){
            fx=fx1;
            fy=fy1;
            fz=fz1;
        }
    }
    public static class vector{
        int vx;
        int vy;
        int vz;
        vector(int vx1,int vy1,int vz1){
            vx=vx1;
            vy=vy1;
            vz=vz1;
        }
    }
 public   static HashMap<String,object> ObjMap = new HashMap<>();
   public static HashMap<String,force> ForceMap = new HashMap<>();
   public static HashMap<String,vector> VectMap = new HashMap<>();
   public static String finprog;
   public static String Define(String s){
        String str=s;
        boolean b=false;
       String ss="";


        while (!b){
            b=true;
            Pattern r = Pattern.compile(objpattrn);
            int start=str.indexOf("var");
            int end = str.indexOf(';');
            if (start!=-1 && end!=-1) {
                 ss = str.substring(start, end + 1);
              Matcher  ma = r.matcher(ss);
                if (ma.matches()) {
                    str = str.replace(ss, " ");
                    ss = ss.replace(",", " ");
                    ss = ss.replace(";", " ");
                    ss = ss.replace("(", " ");
                    ss = ss.replace(")", " ");
                    ss = ss.replace(":", " ");
                    ss = ss.replace("var", " ");
                    ss = ss.replace("object", " ");
                    StringTokenizer tok = new StringTokenizer(ss);
                    String name = tok.nextToken();
                    int m = Integer.valueOf(tok.nextToken());
                    int x = Integer.valueOf(tok.nextToken());
                    int y = Integer.valueOf(tok.nextToken());
                    int z = Integer.valueOf(tok.nextToken());
                    int vx = Integer.valueOf(tok.nextToken());
                    int vy = Integer.valueOf(tok.nextToken());
                    int vz = Integer.valueOf(tok.nextToken());
                    int ax = Integer.valueOf(tok.nextToken());
                    int ay = Integer.valueOf(tok.nextToken());
                    int az = Integer.valueOf(tok.nextToken());
                    object ob1 = new object(m, x, y, z, vx, vy, vz, ax, ay, az);
                    ObjMap.put(name, ob1);
                    b = false;

                }
            }
            r = Pattern.compile(forcepattrn);
            start=str.indexOf("var");
            end = str.indexOf(';');
            if (start!=-1 && end!=-1) {
                ss = str.substring(start,end + 1);
             Matcher   ma = r.matcher(ss);
                if (ma.matches()){
                    str =str.replace(ss," ");
                    ss=ss.replace(","," ");
                    ss=ss.replace(";"," ");
                    ss=ss.replace("("," ");
                    ss=ss.replace(")"," ");
                    ss=ss.replace(":"," ");
                    ss=ss.replace("var"," ");
                    ss=ss.replace("force"," ");
                    StringTokenizer tok = new StringTokenizer(ss);
                    String name=tok.nextToken();
                    int fx=Integer.valueOf(tok.nextToken());
                    int fy=Integer.valueOf(tok.nextToken());
                    int fz=Integer.valueOf(tok.nextToken());
                    force for1= new force(fx,fy,fz);
                    ForceMap.put(name,for1);
                    b=false;

                }
            }

             r = Pattern.compile(vectpattrn);
            start=str.indexOf("var");
            end = str.indexOf(';');
            if (start!=-1 && end!=-1) {
                ss = str.substring(start,end + 1);
              Matcher  ma = r.matcher(ss);
                if (ma.matches()) {
                    str = str.replace(ss, " ");
                    ss = ss.replace(",", " ");
                    ss = ss.replace(";", " ");
                    ss = ss.replace("(", " ");
                    ss = ss.replace(")", " ");
                    ss = ss.replace(":", " ");
                    ss = ss.replace("var", " ");
                    ss = ss.replace("vector", " ");
                    StringTokenizer tok = new StringTokenizer(ss);
                    String name = tok.nextToken();
                    int vx = Integer.valueOf(tok.nextToken());
                    int vy = Integer.valueOf(tok.nextToken());
                    int vz = Integer.valueOf(tok.nextToken());
                    vector vect1 = new vector(vx, vy, vz);
                    VectMap.put(name, vect1);
                    b = false;

                }
            }
        }

        String js="";
        for (int i=0;i<ObjMap.values().size();i++){
            object o = (object) ObjMap.values().toArray()[i];
            String name = (String) ObjMap.keySet().toArray()[i];
            String s1="var "+ name +"= new Object; "+name+".m="+o.m+"; "+name+".x="+o.x+"; "+name+".y="+o.y+"; "+name+".z="+o.z+"; "+name+".vx="+o.vx+"; "+name+".vy="+o.vy+"; "+name+".vz="+o.vz+"; "+name+".ax="+o.ax+"; "+name+".ay="+o.ay+"; "+name+".az="+o.az+"; ";
            js+="\n"+s1;
        }
        finprog=js+ "while (END) {"+str;
       //StringWriter.getBuffer().toString()

       finprog+="TUNIT.sleep(100); sw.flush(); pane.setText(sw.getBuffer()); pane.revalidate();";

       String js2="";
       for (int i=0;i<ObjMap.values().size();i++){
           object o = (object) ObjMap.values().toArray()[i];
           String name = (String) ObjMap.keySet().toArray()[i];

           String s1="ObjMap.get(\""+name+"\").set("+name+".m, " + name + ".x,"+name+".y,"+name+".z,"+name+".vx,"+name+".vy,"+name+".vz," + name + ".ax, "+name+".ay," +name+".az); ";
           js2+="\n"+s1;
       }
       finprog+=js2+" lab.updatePanel();}";

        return str;
    }
}
