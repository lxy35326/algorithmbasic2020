package class24;

public class Solution2 {

    public static int change(int amount, int[] coins) {
        int len = coins.length;
        //dp[i][j]表示i及之后的位置任选，能够构成j总额的硬币组合数。
        //dp[i][j] dp[i][j + coins[index]]依赖于
        int[][] dp = new int[len + 1][amount + 1];
        dp[len][0] = 1;
        for (int index = len - 1; index >= 0; index--) {
            for (int j = 0; j < amount + 1; j++) {
                int ans = 0;
                for (int count = 0; ; count++) {
                    int temp = j - count * coins[index];
                    if (temp >= 0) {
                        ans += dp[index + 1][temp];
                    } else break;
                }
                dp[index][j] = ans;
            }
        }
        return dp[0][amount];
    }

    public static int change1(int amount, int[] coins) {
        int len = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int index = len - 1; index >= 0; index--) {
            for (int j = amount; j >= 0; j--) {
                int ans = 0;
                for (int count = 0; ; count++) {
                    int temp = j - count * coins[index];
                    if (temp >= 0) {
                        ans += dp[temp];
                    } else break;
                }
                dp[j] = ans;
            }
        }
        return dp[amount];
    }
    public static int change2(int amount, int[] coins) {
        int len = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int index = len - 1; index >= 0; index--) {
            for (int j = coins[index]; j < amount + 1; j++) {
                dp[j] += dp[j - coins[index]];
            }
        }
        return dp[amount];
    }
    static int process(int[] coins, int index, int rest) {
        int len = coins.length;
        if (index == len) {
            if (rest == 0) {
                return 1;
            }
            return 0;
        }
        int ans = 0;
        for (int count = 0; ; count++) {
            int temp = rest - count * coins[index];
            if (temp >= 0) {
                ans += process(coins, index + 1, temp);
            } else break;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(change(5, new int[]{1,2,5}));
        System.out.println(change1(5, new int[]{1,2,5}));
        System.out.println(change2(5, new int[]{1,2,5}));
    }

}
