
package a1q11;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class A1q11 {

    public static void main(String[] args) {
        // TODO code application logic here
        List<Integer> numbersDivisibleBy2 = new ArrayList<>();
        numbersDivisibleBy2.add(2);
        numbersDivisibleBy2.add(4);
        numbersDivisibleBy2.add(6);
        numbersDivisibleBy2.add(8);
        numbersDivisibleBy2.add(10);

        List<Integer> numbersDivisibleBy4 = new ArrayList<>();
        numbersDivisibleBy4.add(4);
        numbersDivisibleBy4.add(8);
        numbersDivisibleBy4.add(12);
        numbersDivisibleBy4.add(16);
        numbersDivisibleBy4.add(20);

        // Creating a HashSet from another collection (ArrayList)
        Set<Integer> numbersDivisibleBy2Or4 = new HashSet<>(numbersDivisibleBy2);

        // Adding all the elements from an existing collection to a HashSet
        numbersDivisibleBy2Or4.addAll(numbersDivisibleBy4);

        System.out.println(numbersDivisibleBy2Or4);
    }
    
}
