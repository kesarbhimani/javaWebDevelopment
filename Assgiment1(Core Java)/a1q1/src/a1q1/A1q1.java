
package a1q1;
import java.util.Scanner;

public class A1q1 {

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sn = new Scanner( System.in );
        int tblNum;
        int counter=1;
        System.out.println("Enter table number :");
        tblNum = sn.nextInt();
        
        System.out.println("");
        for(int i=1;i<=tblNum;i++){
            for(int j=1;j<=i;j++){
                System.out.print(tblNum*counter+" ");
                counter++;
            }
            System.out.println("");
        }
    }
    
}
