package class08;

public class Test {
    public static void main(String[] args) {
        int res = 0;
        for (int i = 1; i <= 100000; i++) {
            res += func(i);
        }
        System.out.println(res);

        System.out.println( (int)Math.pow(9,5));
    }

    static int func(int val) {
        int res = 0;
        int p = val;
        int r = 0;
        while (p != 0) {
            res++;
            p /= 10;
        }
        for (int i = 0; i < res; i++) {
            if (val / ((int) Math.pow(10, i)) % 10 == 9) {
                r++;
            }
        }
        return r;
    }
}
