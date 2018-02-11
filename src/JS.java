import javax.script.Bindings;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.FileReader;
import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by mikha on 08.03.2017.
 */
public class JS {
        public static void main(String args[]) throws Exception {
            ScriptEngine js = new ScriptEngineManager().getEngineByName("javascript");
            Bindings bindings = js.getBindings(ScriptContext.ENGINE_SCOPE);
          //  bindings.put("stdout", System.out);
            //bindings.put("read", System.in);


            Scanner s = new Scanner(System.in);
            String script = s.next();
            js.eval(new FileReader(script));

            // Prints "-1.0" to the standard output stream.
        }

}
