public class ComplexTest {
    public static void main(String[] args) {
        Complex complex = new Complex(2, 2);
        Complex complex2 = new Complex(2, 2);
        boolean flag = complex.equals(complex2);
        System.out.print("复数" + complex + "与" + complex2);
        if (!flag)
            System.out.print("不");
        System.out.print("相等，相加结果为: " + (complex.add(complex2)).toString());
    }
}
