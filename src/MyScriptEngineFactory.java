// MyScriptEngineFactory.java

import java.util.*;

import javax.script.*;

public class MyScriptEngineFactory implements ScriptEngineFactory
{
    public String getEngineName ()
    {
        return "My Scripting Engine for Minexp";
    }

    public String getEngineVersion ()
    {
        return "1.0";
    }

    public List<String> getExtensions ()
    {
        List<String> list = new ArrayList<String> ();
        list.add ("me");
        return Collections.unmodifiableList (list);
    }

    public String getLanguageName ()
    {
        return "Minexp";
    }

    public String getLanguageVersion ()
    {
        return "0.1";
    }

    public String getMethodCallSyntax (String obj, String m, String... args)
    {
        return null; // Minexp has no methods
    }

    public List<String> getMimeTypes ()
    {
        List<String> list = new ArrayList<String> ();
        list.add ("text/Minexp"); // Illustration only -- not official
        return Collections.unmodifiableList (list);
    }

    public List<String> getNames ()
    {
        List<String> list = new ArrayList<String> ();
        list.add ("MyScriptForMinexp");
        return Collections.unmodifiableList (list);
    }

    public String getOutputStatement (String toDisplay)
    {
        return null; // Minexp has no I/O capability
    }

    public Object getParameter (String key)
    {
        // I’m not sure what to do with ScriptEngine.ARGV and
        // ScriptEngine.FILENAME -- not even Rhino JavaScript recognizes these
        // keys.

        if (key.equals (ScriptEngine.ENGINE))
            return getEngineName ();
        else
        if (key.equals (ScriptEngine.ENGINE_VERSION))
            return getEngineVersion ();
        else
        if (key.equals (ScriptEngine.NAME))
            return getNames ().get (0);
        else
        if (key.equals (ScriptEngine.LANGUAGE))
            return getLanguageName ();
        else
        if (key.equals (ScriptEngine.LANGUAGE_VERSION))
            return getLanguageVersion ();
        else
        if (key.equals ("THREADING"))
            return null; // Until thoroughly tested.
        else
            return null;
    }

    public String getProgram (String... statements)
    {
        return null; // Minexp does not understand statements
    }

    public ScriptEngine getScriptEngine ()
    {
        ScriptEngineManager factory = new ScriptEngineManager();
        ScriptEngine engine = factory.getEngineByName("JavaScript");
        return new MyScriptEngine (engine);
    }
}