import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by mikha on 23.02.2018.
 */
public class paraam {
    public static void main(String args[]){
       //object
        // String pattern ="var[ ]+[a-z]+[ ]+[:]+[ ]*object[ ]*[(][ ]*([A-Za-z0-9)+[ ]*[,][ ]*([A-Za-z0-9])+[ ]*[,][ ]*([A-Za-z0-9])+[ ]*[,][ ]*([A-Za-z0-9])+[ ]*[,][ ]*([A-Za-z0-9])+[ ]*[,][ ]*([A-Za-z0-9])+[ ]*[,][ ]*([A-Za-z0-9])+[ ]*[,][ ]*([A-Za-z0-9])+[ ]*[,][ ]*([A-Za-z0-9])+[ ]*[,][ ]*([A-Za-z0-9])+[ ]*[)][;]";
        //force
        //String pattern = "var[ ]+[a-z]+[ ]+[:]+[ ]*force[ ]*[(][ ]*([A-Za-z0-9])+[ ]*[,][ ]*([A-Za-z0-9])+[ ]*[,][ ]*([A-Za-z0-9])+[ ]*[)][;]";
        //vector
      String   objpattrn ="var[ ]+[a-z]+[ ]+[:]+[ ]*object[ ]*[(][ ]*([0-9])+[ ]*[,][ ]*([0-9])+[ ]*[,][ ]*([0-9])+[ ]*[,][ ]*([0-9])+[ ]*[,][ ]*([0-9])+[ ]*[,][ ]*([0-9])+[ ]*[,][ ]*([0-9])+[ ]*[,][ ]*([0-9])+[ ]*[,][ ]*([0-9])+[ ]*[,][ ]*([0-9])+[ ]*[,][ ]*([a-z]+)[ ]*[)][;]";
        Pattern r = Pattern.compile(objpattrn);
        String s ="var  abc  :  object (1,2,3,4,5,6,7,8,9,10,red);";
        Matcher m = r.matcher(s);
        if (m.matches()){
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

    }
}
