package class32;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        int x;
        Scanner in = new Scanner(System.in);
        x = in.nextInt();
        double y;
        if (x <= 15) y = 4 * x / 3.0;
        else {
            y = 2.5 * x - 17.5;
        }
        System.out.printf("应交水费：%.2f元",y);
    }
}
