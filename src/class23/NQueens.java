package class23;

public class NQueens {
    /**
     * N皇后问题的第1种解法
     *
     * @param n
     * @return
     */
    static int num1(int n) {
        if (n < 1) return 0;
        int[] record = new int[n];
        return process1(0, record, n);
    }

    static int process1(int i, int[] record, int n) {
        if (i == n) {


        }
        int res = 0;
        for (int j = 0; j < n; j++) {
            if (isValid(record, i, j)) {
                record[i] = j;
                res += process1(i + 1, record, n);
            }
        }
        return res;
    }

    static boolean isValid(int[] record, int i, int j) {
        for (int k = 0; k < i; k++) {
            if (j == record[k] || Math.abs(i - k) == Math.abs(j - record[k])) return false;
        }
        return true;
    }
}
