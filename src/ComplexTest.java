import java.util.Scanner;

public class ComplexTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double r1, i1, r2, i2;
        r1 = in.nextDouble();
        i1 = in.nextDouble();
        r2 = in.nextDouble();
        i2 = in.nextDouble();
        Complex complex1 = new Complex(r1, i1);
        Complex complex2 = new Complex(r2, i2);
        System.out.println("第一个复数是 "+complex1);
        System.out.println("第二个复数是 "+complex2);
        System.out.println("第一个复数的模是"+complex1.mod());
        System.out.println("两个复数的和是"+complex1.add(complex2));
        if(complex1.equals(complex2)){
            System.out.println("两个复数相等");
        } else {
            System.out.println("两个复数不等");
        }
    }
}
