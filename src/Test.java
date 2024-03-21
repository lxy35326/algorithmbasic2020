
public class Test {
    //计算1/n!的值
    static double f(int n){
        long sum = 1;
        for (int i = 1; i <= n ; i++) {
            sum *= i;
        }
        return 1.0/sum;
    }
    public static void main(String[] args) {
        double sum = 0;
        for (int i = 1; i <= 20; i++) {
            sum += f(i);
        }
        System.out.println(sum);
    }
}
