package class20;

class Solution {
    static long[][][] dp;
    public static double knightProbability(int n, int k, int row, int column) {
        // 0 - n
        dp = new long[k + 1][n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n ; j++)
                dp[0][i][j] = 1;
        for (int t = 1; t <= k; t++) {
            System.out.println("t:"+ t);
            for (int i = 0 ; i < n ; i++)
                for (int j = 0; j < n ; j++) {
                    long p1 = pick(n, t - 1, i - 2, j - 1);
                    long p2 = pick(n, t - 1, i - 2, j + 1);
                    long p3 = pick(n, t - 1, i + 2, j - 1);
                    long p4 = pick(n, t - 1, i + 2, j + 1);
                    long p5 = pick(n, t - 1, i - 1, j - 2);
                    long p6 = pick(n, t - 1, i - 1, j + 2);
                    long p7 = pick(n, t - 1, i + 1, j - 2);
                    long p8 = pick(n, t - 1, i + 1, j + 2);
                    dp[t][i][j] = p1 + p2 + p3 + p4 + p5 + p6 + p7 + p8;

                        System.out.println(dp[t][i][j]);
                }
            System.out.println("************************");

        }

        return dp[k][row - 1][column - 1] / Math.pow(8, k);
    }
    static long pick(int n, int k, int row, int column) {
        if (row < 0 || row > n - 1 || column < 0 || column > n - 1)
            return 0;
        return dp[k][row][column];
    }

    public static void main(String[] args) {
        System.out.println(Math.pow(8,30));
        knightProbability(8,30,6,4);

    }
}
