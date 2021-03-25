
package a1q2;
import java.util.Scanner;

abstract public class A1q2 {
    int n1;
    int n2;
    public void get_value(int n1, int n2){
        this.n1=n1;
        this.n2=n2;
    }
    abstract public void area();
    public static void main(String[] args) {
        // TODO code application logic here.
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Length : ");
        int num1 = sc.nextInt();
        System.out.println("Enter Width : ");
        int num2 = sc.nextInt();
        
        square S = new square();
        S.get_value(num1, num2);
        S.area();
        triangle T = new triangle();
        T.get_value(num1, num2);
        T.area();
        circle C = new circle();
        C.get_value(num1, num2);
        C.area();
        rectangle R = new rectangle();
        R.get_value(num1, num2);
        R.area();
    }
    
}

class square extends A1q2{
    @Override
    public void area(){
        int area = this.n1*this.n1;
        System.out.println("Area of Square : "+area);
    }
}

class triangle extends A1q2{
    @Override
    public void area(){
        int area = (this.n1*this.n2)/2;
        System.out.println("Area of Triangle : "+area);
    }
}

class circle extends A1q2{
    @Override
    public void area(){
        double area = this.n1*this.n1*3.14;
        System.out.println("Area of Circle : "+area);
    }
}

class rectangle extends A1q2{
    @Override
    public void area(){
        int area = this.n1*this.n2;
        System.out.println("Area of Rectangle : "+area);
    }
}
