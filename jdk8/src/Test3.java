import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int xiao, da, shuzi;
        xiao = da = shuzi = 0;
        char[] buffer = s.toCharArray();
        int len = buffer.length;
        for (int i = 0; i < len; i++) {
            if (buffer[i] >= 'A' && buffer[i] <= 'Z')
                da++;
            else if (buffer[i] >= 'a' && buffer[i] <= 'z')
                xiao++;
            else if (buffer[i] >= '0' && buffer[i] <= '9')
                shuzi++;

        }
        System.out.println("大写字母有" + da + "个");
        System.out.println("小写字母有" + xiao + "个");
        System.out.println("数字有" + shuzi + "个");
    }
}
