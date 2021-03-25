
package a1q3;
import java.util.Scanner;

public class A1q3 {  
    public static void main(String[] args) {
        // TODO code application logic here
        int i, number, temp, counter=0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Any Number : ");
        number = sc.nextInt();
        System.out.println("");
        temp = number;
        while(temp>0){
            counter++;
            temp = temp/10;              
        }
        double num = Math.pow(10, counter-1);
        i = (int)num;
        for (;i>0;i/=10){
            System.out.println(number/i%10);  

        }
    } 
}
