// MyScriptDemo.java

import java.io.*;

import javax.script.*;

public class MyScriptDemo
{
    public static void main (String [] args) throws Exception
    {

        // Verify correct command-line arguments.

        if (args.length == 0 || args.length > 2 ||
                (args.length == 2 && !args [1].equalsIgnoreCase ("file")))
        {
            System.err.println ("usage: java MyScriptDemo script [file]");
            return;
        }

        // Create a ScriptEngineManager that discovers all script engine
        // factories (and their associated script engines) that are visible to
        // the current thread’s classloader.

        ScriptEngineManager manager = new ScriptEngineManager ();
        manager.registerEngineName("MyScriptForMinexp", new MyScriptEngineFactory());

        // Obtain a ScriptEngine that supports the MyScriptForMinexp short name.

        ScriptEngine engine = manager.getEngineByName ("MyScriptForMinexp");

        // Execute the specified script, output the returned object, and prove
        // that this object is an Integer.

        Object o;
        if (args.length == 1)
            o = engine.eval (args [0]);
        else
            o = engine.eval (new FileReader (args [0]));

        System.out.println ("Object value: " + o);
        System.out.println ("Is integer: " + (o instanceof Integer));
    }
}