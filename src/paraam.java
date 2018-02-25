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
        String pattern = "var[ ]+[a-z]+[ ]+[:]+[ ]*vector[ ]*[(][ ]*([A-Za-z0-9])+[ ]*[,][ ]*([A-Za-z0-9])+[ ]*[,][ ]*([A-Za-z0-9])+[ ]*[)][;]";
        Pattern r = Pattern.compile(pattern);
        String s ="var  abc  :  vector (111,A23a,A32a);";
        Matcher m = r.matcher(s);
        if (m.matches()){
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

    }
}
