package class24;

import java.util.Arrays;

class Solution {
    static int magic = Integer.MAX_VALUE;


    //二维
    public static int coinChange1(int[] coins, int amount) {
        int len = coins.length;
        int[][] dp = new int[len + 1][amount + 1];
        Arrays.fill(dp[len], amount + 1);
        dp[len][0] = 0;
        System.out.println("二维的时候的变化：");
        for (int i = 0; i < amount + 1; i++) {
            System.out.printf("%d\t",dp[len][i]);
        }
        System.out.println();
        //dp[i][j]表示：下标为i及之后的位置的硬币可以任意选择，组成j价格时，需要的最小硬币数
        //dp[2][2] dp[2][5]依赖于dp[2][3] dp[2][1].      dp[2][7]
        for (int index = len - 1; index >= 0; index--) {
            for (int rest = 0; rest < amount + 1; rest++) {
                int ans = magic;
                for(int count = 0; ; count++) {
                    int temp = rest - count * coins[index];
                    if (temp < 0) {
                        break;
                    }

                        ans = Math.min(dp[index + 1][temp] + count, ans);

                }
                dp[index][rest] = ans;
            }
            for (int i = 0; i < amount + 1; i++) {
                System.out.printf("%d\t",dp[index][i]);
            }
            System.out.println();
        }
        return dp[0][amount];
    }

    //一维
    public static int coinChange2(int[] coins, int amount) {
        int len = coins.length;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        System.out.println("一维的时候的变化：");
        for (int i = 0; i < amount + 1; i++) {
            System.out.printf("%d\t",dp[i]);
        }
        System.out.println();
        for (int index = len - 1; index >= 0; index--) {
            for (int rest = 0; rest < amount + 1; rest++) {
                int ans = magic;
                for (int temp = rest, count = 0; temp >= 0; temp -= coins[index], count++) {

                        ans = Math.min(ans, dp[temp] + count);
                }
                dp[rest] = ans ;
            }
            for (int i = 0; i < amount + 1; i++) {
                System.out.printf("%d\t",dp[i]);
            }
            System.out.println();
        }
        return dp[amount];
    }

    public static int coinChange(int[] coins, int amount) {
        int len = coins.length;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        System.out.println("状态压缩完之后的变化：");
        for (int i = 0; i < amount + 1; i++) {
            System.out.printf("%d\t",dp[i]);
        }
        System.out.println();
        for (int index = len - 1; index >= 0; index--) {
            for (int temp = coins[index]; temp <= amount; temp++) {
                    dp[temp] = Math.min(dp[temp],dp[temp - coins[index]] + 1);

            }
            for (int i = 0; i < amount + 1; i++) {
                System.out.printf("%d\t",dp[i]);
            }
            System.out.println();
        }
        int r = dp[amount];
        if (r > amount) r = -1;
        return r;
    }

    public static void main(String[] args) {
        System.out.println(coinChange1(new int[]{1, 2, 5}, 11));
        System.out.println(coinChange2(new int[]{1, 2, 5}, 11));
        System.out.println(coinChange(new int[]{1, 2, 5}, 11));

    }

}