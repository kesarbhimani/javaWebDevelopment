
package a1q6;
import java.util.Scanner;
import java.util.Random;

class RandomNumberException extends Exception {
    String s = "";

    RandomNumberException(String s){
        this.s = s;
    }

    @Override
    public String getMessage(){
        return ("Custom Exception =  " + s);
    }
}
public class A1q6 {
       
    public static void main(String[] args) {
        // TODO code application logic here
        int inputNumber = 0;
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("Enter a number between 1-100 : ");

        try {
            String input = sc.nextLine();
            boolean isNumberVariable = isNumber(input);
            if (isNumberVariable) {
                inputNumber = Integer.parseInt(input);
            } else {
                throw new RandomNumberException("Please enter a numeric value!!!");
            }

        } catch(RandomNumberException e) {
            System.out.println("error: " + e.getMessage());
        }

        int randNumber = rand.nextInt(100);
        if(inputNumber == randNumber)
            System.out.println("You Win");
        else
            System.out.println("You Lose");
    }

    public static boolean isNumber(String input) {
        return input.matches("^\\d+$");
    }

}    

