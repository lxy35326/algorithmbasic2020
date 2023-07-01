package class18;

public class RobotWalk {
    static int ways1(int N, int aim, int start, int K) {
        return process1(start, K, aim, N);
    }

    static int process1(int cur, int rest, int aim, int N) {
        if (rest == 0) {
            return aim == cur ? 1 : 0;
        }
        if (cur == 1) {
            return process1(2, rest - 1, aim, N);
        }
        if (cur == N) {
            return process1(N - 1, rest - 1, aim, N);
        }
        return process1(cur - 1, rest - 1, aim, N) + process1(cur + 1, rest - 1, aim, N);
    }

    //[cur, rest]: cur范围：1-N, rest: 0-K
    static int ways2(int N, int aim, int start, int K) {
        int[][] dp = new int[N + 1][K + 1];
        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < K + 1; j++) {
                dp[i][j] = -1;
            }
        }
        return process2(start, K, aim, N, dp);
    }

    static int process2(int cur, int rest, int aim, int N, int[][] dp) {
        if (dp[cur][rest] != -1) return dp[cur][rest];
        int ans = 0;
        if (rest == 0) {
            ans = cur == aim ? 1 : 0;
        } else if (cur == 1) {
            ans = process2(cur + 1, rest - 1, aim, N, dp);
        } else if (cur == N) {
            ans = process2(cur - 1, rest - 1, aim, N, dp);
        } else
            ans = process2(cur - 1, rest - 1, aim, N, dp) + process2(cur + 1, rest - 1, aim, N, dp);
        dp[cur][rest] = ans;
        return ans;
    }

    static int ways3(int N, int aim, int start, int K) {
        int[][] dp = new int[N + 1][K + 1];
        dp[aim][0] = 1;
        for (int i = 1; i < K + 1; i++) {
            dp[1][i] = dp[2][i - 1];
            dp[N][i] = dp[N - 1][i - 1];
            for (int j = 2; j < N; j++) {
                dp[j][i] = dp[j - 1][i - 1] + dp[j + 1][i - 1];
            }
        }
        return dp[start][K];
    }


    public static void main(String[] args) {
        System.out.println(ways1(4, 2, 4, 4));
        System.out.println(ways2(4, 2, 4, 4));
        System.out.println(ways3(4, 2, 4, 4));
    }
}
