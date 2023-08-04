package class21;

import java.util.HashMap;
import java.util.Map.Entry;

/**
 * 这个题目是：给定一个Arr数组，其中每个值认为是一张货币，求能够组成目标金额aim的方法数。
 */
public class Code04_CoinsWaySameValueSamePapper {

    public static class Info {
        public int[] coins;
        public int[] zhangs;

        public Info(int[] c, int[] z) {
            coins = c;
            zhangs = z;
        }
    }

    public static Info getInfo(int[] arr) {
        HashMap<Integer, Integer> counts = new HashMap<>();
        for (int value : arr) {
            counts.put(value, counts.getOrDefault(value, 0) + 1);
        }
        int N = counts.size();
        int[] coins = new int[N];
        int[] zhangs = new int[N];
        int index = 0;
        for (Entry<Integer, Integer> entry : counts.entrySet()) {
            coins[index] = entry.getKey();
            zhangs[index++] = entry.getValue();
        }
        return new Info(coins, zhangs);
    }

    public static int coinsWay(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        Info info = getInfo(arr);
        return process(info.coins, info.zhangs, 0, aim);
    }

    // coins 面值数组，正数且去重
    // zhangs 每种面值对应的张数
    public static int process(int[] coins, int[] zhangs, int index, int rest) {
        if (index == coins.length) {
            return rest == 0 ? 1 : 0;
        }
        int ways = 0;
        for (int zhang = 0; zhang * coins[index] <= rest && zhang <= zhangs[index]; zhang++) {
            ways += process(coins, zhangs, index + 1, rest - (zhang * coins[index]));
        }
        return ways;
    }

    public static int dp1(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        Info info = getInfo(arr);
        int[] coins = info.coins;
        int[] zhangs = info.zhangs;
        int N = coins.length;
        int[][] dp = new int[N + 1][aim + 1];
        dp[N][0] = 1;
        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 0; rest <= aim; rest++) {
                int ways = 0;
                for (int zhang = 0; zhang * coins[index] <= rest && zhang <= zhangs[index]; zhang++) {
                    ways += dp[index + 1][rest - (zhang * coins[index])];
                }
                dp[index][rest] = ways;
            }
            for (int i = 0; i < aim + 1; i++) {
                System.out.printf("%d\t",dp[index][i]);
            }
            System.out.println();
        }
        return dp[0][aim];
    }

    //斜率优化
    static int dp2_(int[] arr, int aim) {
        if (arr == null || arr.length < 1 || aim < 0) return 0;
        Info info = getInfo(arr);
        int[] coins = info.coins;
        int[] zhangs = info.zhangs;
        //index: 0 - arr.length aim : 0-aim
        int len = coins.length;
        int[][] dp = new int[2][aim + 1];
        int curLine = len % 2;
        dp[curLine][0] = 1;
        for (int index = len - 1; index >= 0; index--) {
            curLine = 1 ^ curLine;
            int prevLine = 1 ^ curLine;//0变为1  1变为0
            if (coins[index] >= 0) System.arraycopy(dp[prevLine], 0, dp[curLine], 0, coins[index]);
            for (int rest = coins[index]; rest <= aim; rest++) {
                int prev = rest - coins[index];
                dp[curLine][rest] = dp[prevLine][rest] + dp[curLine][prev];
                //过期下标
                int first = prev - coins[index] * zhangs[index];
                if (first >= 0)
                    dp[curLine][rest] -= dp[prevLine][first];
            }
            for (int i = 0; i < aim + 1; i++) {
                System.out.printf("%d\t",dp[curLine][i]);
            }
            System.out.println();

        }
        return dp[0][aim];
    }




    public static int dp2(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        Info info = getInfo(arr);
        int[] coins = info.coins;
        int[] zhangs = info.zhangs;
        int N = coins.length;
        int[][] dp = new int[N + 1][aim + 1];
        dp[N][0] = 1;
        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 0; rest <= aim; rest++) {
                dp[index][rest] = dp[index + 1][rest];
                if (rest - coins[index] >= 0) {
                    dp[index][rest] += dp[index][rest - coins[index]];
                }
                if (rest - coins[index] * (zhangs[index] + 1) >= 0) {
                    dp[index][rest] -= dp[index + 1][rest - coins[index] * (zhangs[index] + 1)];
                }
            }
        }
        return dp[0][aim];
    }

    // 为了测试
    public static int[] randomArray(int maxLen, int maxValue) {
        int N = (int) (Math.random() * maxLen);
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = (int) (Math.random() * maxValue) + 1;
        }
        return arr;
    }

    // 为了测试
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // 为了测试
    public static void main(String[] args) {
        System.out.println(dp1(new int[]{1, 1, 16, 17}, 18));
        System.out.println(dp2_(new int[]{1, 1, 16, 17}, 18));
//        int maxLen = 10;
//        int maxValue = 20;
//        int testTime = 1000000;
//        System.out.println("测试开始");
//        for (int i = 0; i < testTime; i++) {
//            int[] arr = randomArray(maxLen, maxValue);
//            int aim = (int) (Math.random() * maxValue);
//            int ans1 = coinsWay(arr, aim);
//            int ans2 = dp1(arr, aim);
//            int ans3 = dp2(arr, aim);
//            int ans2_ = dp2_(arr, aim);
//            if (ans1 != ans2 || ans1 != ans3 || ans1 != ans2_) {
//                System.out.println("Oops!");
//                printArray(arr);
//                System.out.println(aim);
//                System.out.println(ans1);
//                System.out.println(ans2);
//                System.out.println(ans3);
//                System.out.println(ans2_);
//                break;
//            }
//        }
        System.out.println("测试结束");
    }

}
