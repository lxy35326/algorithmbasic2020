import java.util.Scanner;
import java.util.regex.Pattern;

public class Test5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long res = 1;
        for (int i = 1; i <= n; i++)
            res *= i;
        System.out.println(n + "的阶乘是:" + res);

        Pattern compile = Pattern.compile("[1-9]\\d{5}(18|19|20)\\d{2}(0\\d|10|11|12)(0[1-9]|[1-2]\\d|30|31)\\d{3}[\\dXx]");
    }
}
