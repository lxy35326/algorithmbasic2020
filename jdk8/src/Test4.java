import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        char[] buffer = s.toCharArray();
        int len = buffer.length;
        int offset = 2;//在这里指定偏移量，比如2
        for (int i = 0; i < len; i++) {
            buffer[i] += offset;
            if (buffer[i] > 'z')
                buffer[i] -= 26;
        }
        String res = new String(buffer);
        System.out.println("加密后为：" + res);
    }
}
