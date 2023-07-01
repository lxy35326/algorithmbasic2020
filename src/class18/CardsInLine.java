package class18;

public class CardsInLine {
    /**
     * 根据规则，返回获胜者的分数
     *
     * @param arr
     * @return
     */
    static int win1(int[] arr) {
        int len = arr.length;
        int first = f(arr, 0, len - 1);
        int second = g(arr, 0, len - 1);
        return Math.max(first, second);
    }

    static int f(int[] arr, int L, int R) {
        if (L == R) return arr[L];
        int p1 = arr[L] + g(arr, L + 1, R);
        int p2 = arr[R] + g(arr, L, R - 1);
        return Math.max(p1, p2);
    }

    static int g(int[] arr, int L, int R) {

        if (L == R) return 0;
        int p1 = f(arr, L + 1, R);
        int p2 = f(arr, L, R - 1);
        return Math.min(p1, p2);
    }

    public static void main(String[] args) {
        System.out.println(win1(new int[]{1, 100, 1}));
    }
}
