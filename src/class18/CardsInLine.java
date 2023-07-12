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

    static int win2(int[] arr) {
        int len = arr.length;
        int[][] fmap = new int[len][len];
        int[][] gmap = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                fmap[i][j] = -1;
                gmap[i][j] = -1;
            }
        }
        int first = f2(arr, 0, len - 1, fmap, gmap);
        int second = g2(arr, 0, len - 1, fmap, gmap);
        return Math.max(first, second);
    }

    static int f2(int[] arr, int L, int R, int[][] fmap, int[][] gmap) {
        if (fmap[L][R] != -1) return fmap[L][R];
        int ans = -1;
        if (L == R) {
            ans = arr[L];
        } else {
            int p1 = arr[L] + g2(arr, L + 1, R, fmap, gmap);
            int p2 = arr[R] + g2(arr, L, R - 1, fmap, gmap);
            ans = Math.max(p1, p2);
        }
        fmap[L][R] = ans;

        return ans;
    }

    static int g2(int[] arr, int L, int R, int[][] fmap, int[][] gmap) {
        if (gmap[L][R] != -1) return gmap[L][R];
        int ans = 0;
        if (L != R) {
            int p1 = f2(arr, L + 1, R, fmap, gmap);
            int p2 = f2(arr, L, R - 1, fmap, gmap);
            ans = Math.min(p1, p2);
        }
        gmap[L][R] = ans;
        return ans;
    }

    static int win3(int[] arr) {
        int len = arr.length;
        int[][] fmap = new int[len][len];
        int[][] gmap = new int[len][len];
        for (int i = 0; i < len; i++) {
            fmap[i][i] = arr[i];
            gmap[i][i] = 0;
        }
        for (int row = 1; row < len; row++) {
            int i = 0;//行号
            for (int j = row; j < len; j++) {
                fmap[i][j] = Math.max(arr[i] + gmap[i + 1][j], arr[j] + gmap[i][j - 1]);
                gmap[i][j] = Math.min(fmap[i + 1][j], fmap[i][j - 1]);
                i++;
            }

        }
        return Math.max(fmap[0][len - 1], gmap[0][len - 1]);
    }

    public static void main(String[] args) {
        System.out.println(win1(new int[]{1, 100, 1}));
        System.out.println(win2(new int[]{1, 100, 1}));
        System.out.println(win3(new int[]{1, 100, 1}));
    }
}
