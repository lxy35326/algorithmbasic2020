import java.util.Scanner;

/**
 * 测试1s内 i7-12700h可以运行多少条指令
 * 2.69GHZ = 2.30 * 10^3 * 10^6 = 26900 00000HZ
 * 23亿条 / 4 =
 */
public class Test {
    // 5 * 10^9

    static void func1(long n){
        long k = 0;
        for (long i = 0; i < n; i++)
            k++;
    }

    //60000
    static void func2(long n){
        long k = 0;
        for (long i = 0; i < n; i++) {
            for (long j = 0; j < n; j++) {
                k++;
            }
        }
    }

    static void func3(long n) {
        long k = 0;
        for (long i = 0; i < n; i++) {
            for (long j = 1; j <= n; j = j * 2) {
                k++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("请输入n:");
            long n = in.nextLong();
            long startTime = System.currentTimeMillis();
            func1(n);
            long endTime = System.currentTimeMillis();
            System.out.println("花费时间为："+(endTime-startTime)+"ms");

        }

    }
}
