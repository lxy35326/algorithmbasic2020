import java.util.Scanner;

class MyMath {
    public static double sum(double[] x) {
        double sum = 0;
        for (double v : x) {
            sum += v;
        }
        return sum;
    }

    public double mean(double[] x) {
        if (x == null || x.length == 0) return 0;
        return sum(x)/x.length;
    }
}
class TestMyMath{
    public static void main(String[] args) {
        double[] arr = new double[6];
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 6; i++) {
            arr[i]=in.nextDouble();
        }
        MyMath mymath1 = new MyMath();
        System.out.println("数值和是"+mymath1.sum(arr));
        System.out.println("平均值是"+mymath1.mean(arr));
    }
}