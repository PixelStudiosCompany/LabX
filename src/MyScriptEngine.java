import java.io.*;

import javax.script.*;

public class MyScriptEngine extends AbstractScriptEngine
{
    ScriptEngine intEngine;
    public MyScriptEngine(ScriptEngine engine) {
        intEngine = engine;
    }

    public Bindings createBindings ()
    {
        return null; // Uninitialized bindings not needed because Minexp does
        // not support bindings.
    }

    public Object eval (Reader reader, ScriptContext context)
            throws ScriptException
    {
        if (reader == null || context == null)
            throw new NullPointerException ();

        StringBuffer sb = new StringBuffer (50); // Assume scripts <= 50 chars

        try
        {
            int ch;
            while ((ch = reader.read ()) != -1)
                sb.append ((char) ch);
        }
        catch (IOException e)
        {
            throw new ScriptException ("Unable to read stream", "<unknown>",
                    -1, -1);
        }

        return eval (sb.toString (), context);
    }

    public Object eval (String script, ScriptContext context)
            throws ScriptException
    {
        if (script == null || context == null)
            throw new NullPointerException ();

        // Create a tokenizer to return tokens from the script.

     /*   Tokenizer t = new Tokenizer (script);

        // Use the tokenizer to help execute the script expression.

        int i = expr (t);

        // A valid expression contains no extra characters.

        if (t.getType () != Tokenizer.EOS)
            throw new ScriptException ("Extra characters: " + t.getToken (),
                    "<unknown>", -1,
                    t.getPos ()-1);

        return new Integer (i);*/
        return intEngine.eval(script, context);
    }

    public ScriptEngineFactory getFactory ()
    {
        return new MyScriptEngineFactory ();
    }

    private int expr (Tokenizer t) throws ScriptException
    {
        int res = term (t);

        String tok = t.getToken ();

        while (tok.equals ("+") || tok.equals ("-"))
        {
            if (tok.equals ("+"))
                res += term (t);
            else
            if (tok.equals ("-"))
                res -= term (t);

            tok = t.getToken ();
        }

        return res;
    }

    private int term (Tokenizer t) throws ScriptException
    {
        int res = factor (t);

        String tok = t.getToken ();

        while (tok.equals ("*") || tok.equals ("/") || tok.equals ("%"))
        {
            if (tok.equals ("*"))
                res *= factor (t);
            else
            if (tok.equals ("/"))
                try
                {
                    res /= factor (t);
                }
                catch (ArithmeticException e)
                {
                    throw new ScriptException ("Divide by zero",
                            "<unknown>", -1, t.getPos ()-1);
                }
            else
            if (tok.equals ("%"))
                try
                {
                    res %= factor (t);
                }
                catch (ArithmeticException e)
                {
                    throw new ScriptException ("Divide by zero",
                            "<unknown>", -1, t.getPos ()-1);
                }

            tok = t.getToken ();
        }

        return res;
    }

    private int factor (Tokenizer t) throws ScriptException
    {
        t.nextToken ();

        String tok = t.getToken ();

        if (t.getType () == Tokenizer.NUMBER)
            try
            {
                int i = Integer.parseInt (tok);

                t.nextToken ();

                return i;
            }
            catch (NumberFormatException e)
            {
                throw new ScriptException ("Invalid number: " + tok,
                        "<unknown>", -1,
                        t.getPos ()-1);
            }

        if (tok.equals ("-"))
            return -factor (t);

        if (tok.equals ("("))
        {
            int res = expr (t);

            tok = t.getToken ();

            if (!tok.equals (")"))
                throw new ScriptException ("Missing )",
                        "<unknown>", -1, t.getPos ());

            t.nextToken ();

            return res;
        }

        if (t.getType () == Tokenizer.EOS)
            throw new ScriptException ("Missing token",
                    "<unknown>", -1, t.getPos ());
        else
            throw new ScriptException ("Invalid token: " + tok,
                    "<unknown>", -1, t.getPos ()-1);
    }

    private class Tokenizer
    {
        final static int EOS  = 0; // end of string
        final static int NUMBER = 1; // integer
        final static int OTHER = 2; // single character

        private String text, token;
        private int len, pos, type;

        Tokenizer (String text)
        {
            this.text = text;
            len = text.length ();
            pos = 0;
        }

        int getPos ()
        {
            return pos;
        }

        String getToken ()
        {
            return token;
        }

        int getType ()
        {
            return type;
        }

        void nextToken ()
        {
            // Skip leading whitespace.

            while (pos < len && Character.isWhitespace (text.charAt (pos)))
                pos++;

            // Test for NUMBER token.

            if (pos < len && Character.isDigit (text.charAt (pos)))
            {
                StringBuffer sb = new StringBuffer ();

                do
                {
                    sb.append (text.charAt (pos++));
                }
                while (pos < len && Character.isDigit (text.charAt (pos)));

                type = NUMBER;
                token = sb.toString ();
                return;
            }

            // Must be either a single-character OTHER token or an EOS token.

            if (pos < len)
            {
                token = "" + text.charAt (pos++);
                type = OTHER;
            }
            else
            {
                token = "";
                type = EOS;
            }
        }
    }
}