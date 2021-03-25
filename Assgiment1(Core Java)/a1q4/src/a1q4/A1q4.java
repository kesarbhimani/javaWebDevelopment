
package a1q4;
import  java.util.Scanner;
import java.util.regex.Pattern;

public class A1q4 {
     public static boolean isValid(String email) 
    { 
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$"; 
 
        Pattern pat = Pattern.compile(emailRegex); 
        if (email == null) 
            return false; 
        return pat.matcher(email).matches(); 
    } 
    public static void main(String[] args) {
        // TODO code application logic here
        String emailId;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your email ID : ");
        emailId = sc.next();
        if(isValid(emailId))
            System.out.println("Valid ! ");
        else
            System.out.println("Invalid ! ");

    }
    
}
    