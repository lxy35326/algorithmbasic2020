package class21;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] coins = {1, 2, 5};
        final int amount = 11;
        solution.coinChange(coins, amount);
        solution.coinChange1(coins, amount);
        solution.coinChange2(coins, amount);
    }
    //暴力递归解法
    //     int process(int[] coins, int rest, int cur) {
//         if (rest == 0) {
//             return 0;
//         }
//         if (cur == coins.length) {
//             return rest == 0 ? 0 : -1;
//         }
//         //cur没到最后一个
//         int numbers = Integer.MAX_VALUE;
//         boolean flag = false;
//         for (int i = 0; i * coins[cur] <= rest; i++) {
//             int next =  process(coins, rest - i * coins[cur], cur + 1);
//             if (next != -1 && numbers > i + next) {
//                 numbers = i + next;
//                 flag = true;
//             }

//         }
//         if (!flag)
//             return -1;
//         return numbers;
//     }

    //二维dp
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int len = coins.length;
        int[][] dp = new int[amount + 1][len + 1];
        //dp[0][i]全为0
        // dp[0][len] = 0;
        for (int i = 1; i < amount + 1; i++)
            dp[i][len] = -1;
        for (int j = len - 1; j >= 0; j--) {
            //dp[i][j]:代表rest = i, curIndex= j; dp[i][]
            for (int i = 1; i < amount + 1; i++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int count = 0; count * coins[j] <= i; count++) {
                    int temp = dp[i - count * coins[j]][j + 1];
                    if (temp != -1) {
                        dp[i][j] = Math.min(dp[i][j], temp + count);
                    }
                }
                if (dp[i][j] == Integer.MAX_VALUE)
                    dp[i][j] = -1;
            }

        }
        System.out.println("二维dp为：");
        for (int j = len; j >= 0; j--) {
            for (int i = 0; i < amount + 1; i++) {
                System.out.printf("%d\t", dp[i][j]);
            }
            System.out.println();
        }
        int r = dp[amount][0];
        if (r == 0) return -1;
        return r;
    }

    //一维dp
    public int coinChange1(int[] coins, int amount) {
        if (amount == 0) return 0;
        int len = coins.length;
        int[] dp = new int[amount + 1];
        System.out.println("一维dp为：");

        for (int i = 1; i < amount + 1; i++)
            dp[i] = -1;
        for (int i = 0; i < amount + 1; i++) {
            System.out.printf("%d\t", dp[i]);
        }
        System.out.println();
        for (int j = len - 1; j >= 0; j--) {
            for (int i = amount; i >= 0; i--) {
                //这里要算dp[i]
                int temp = Integer.MAX_VALUE;
                for (int count = 0; count * coins[j] <= i; count++) {
                    int next = dp[i - count * coins[j]];
                    if (next != -1) {
                        temp = Math.min(temp, next + count);
                    }
                }
                if (temp == Integer.MAX_VALUE)
                    dp[i] = -1;
                else
                    dp[i] = temp;
            }
            for (int i = 0; i < amount + 1; i++) {
                System.out.printf("%d\t", dp[i]);
            }
            System.out.println();
        }
        int r = dp[amount];
        if (r == 0) return -1;
        return r;
    }

    //一维dp省去枚举！！！
    public int coinChange2(int[] coins, int amount) {
        System.out.println("省去枚举过程为：");
        if (amount == 0) return 0;
        int len = coins.length;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 0; i < dp.length; i++) {
            System.out.printf("%d\t", dp[i]);
        }
        System.out.println();
//        int r = dp[amount];
        for (int j = len - 1; j >= 0; j--) {
            for (int i = coins[j]; i < amount + 1; i++) {
//                if (dp[i - coins[j]] != -1) {
//                    if (dp[i] == -1) {
//                        dp[i] = dp[i - coins[j]] + 1;
//                    } else {
                dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]);
//                    }
//                }
            }
            for (int i = 0; i < dp.length; i++) {
                System.out.printf("%d\t", dp[i]);
            }
            System.out.println();
        }

        int r = dp[amount];
        if (r > amount) return -1;
        return r;
    }

}
