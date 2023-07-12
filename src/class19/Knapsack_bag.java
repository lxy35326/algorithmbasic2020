package class19;

public class Knapsack_bag {
    static int maxValue(int[] w, int[] v, int bag) {
        return process(w, v, 0, bag);
    }

    static int process(int[] w, int[] v, int index, int rest) {
        if (rest < 0) return -1;
        if (index == w.length) return 0;
        int p1 = process(w, v, index + 1, rest);
        int p2 = 0;
        if (rest - w[index] >= 0)
            p2 = v[index] + process(w, v, index + 1, rest - w[index]);
        return Math.max(p1, p2);

    }

    static int dp(int[] w, int[] v, int rest) {
        //index: 0 - len, bag :0-bag
        int n = w.length;
        int[][] dp = new int[n + 1][rest + 1];
        for (int i = 0; i < rest + 1; i++) {
            dp[n][i] = 0;
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < rest + 1; j++) {
                int p1 = dp[i + 1][j];
                int p2 = 0;
                if (j - w[i] >= 0) {
                    p2 = v[i] + dp[i + 1][j - w[i]];
                }
                dp[i][j] = Math.max(p1, p2);
            }
        }
        return dp[0][rest];
    }

    public static void main(String[] args) {
        int[] weights = {3, 2, 4, 7, 3, 1, 7};
        int[] values = {5, 6, 3, 19, 12, 4, 2};
        int bag = 15;
        System.out.println(maxValue(weights, values, bag));
        System.out.println(dp(weights, values, bag));
    }
}
