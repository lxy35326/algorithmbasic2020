package class39;

import class11.Tree;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Code02_SnacksWays {

    public static int ways1(int[] arr, int w) {
        // arr[0...]
        return process(arr, 0, w);
    }

    // 从左往右的经典模型
    // 还剩的容量是rest，arr[index...]自由选择，
    // 返回选择方案
    // index ： 0～N
    // rest : 0~w
    public static int process(int[] arr, int index, int rest) {
        if (rest < 0) { // 没有容量了
            // -1 无方案的意思
            return -1;
        }
        // rest>=0,
        if (index == arr.length) { // 无零食可选
            return 1;
        }
        // rest >=0
        // 有零食index
        // index号零食，要 or 不要
        // index, rest
        // (index+1, rest)
        // (index+1, rest-arr[i])
        int next1 = process(arr, index + 1, rest); // 不要
        int next2 = process(arr, index + 1, rest - arr[index]); // 要
        return next1 + (next2 == -1 ? 0 : next2);
    }

    static int dp1(int[] arr, int W) {
        int len = arr.length;
        int[][] dp = new int[len + 1][W + 1];
        Arrays.fill(dp[len], 1);
        for (int i = len - 1; i >= 0; i--) {
            for (int j = 0; j <= W; j++) {
                dp[i][j] = dp[i + 1][j];
                if (j - arr[i] >= 0) {
                    dp[i][j] += dp[i + 1][j - arr[i]];
                }
            }
        }
        return dp[0][W];
    }

    static int ways(int[] arr, int W) {
        int len = arr.length;
        int mid = arr.length - 1 >> 1;
        TreeMap<Integer, Integer> map1 = new TreeMap<>(),
                map2 = new TreeMap<>();
        int ways = 0;
        ways += process2(arr, W, 0, mid, 0, map1);
        ways += process2(arr, W, mid + 1, len - 1, 0, map2);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : map2.entrySet()) {
            sum += entry.getValue();
            map.put(entry.getKey(), sum);
        }
        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            Map.Entry<Integer, Integer> entry1 = map.floorEntry(W - key);
            if (entry1 != null)
                ways += value * entry1.getValue();

        }
        return ways + 1;

    }

    static int process2(int[] arr, int W, int index, int end, int sum, Map<Integer, Integer> map) {
        if (sum > W) return 0;
        if (index > end) {

            if (sum != 0) {
                if (!map.containsKey(sum)) {
                    map.put(sum, 1);
                } else {
                    map.put(sum, map.get(sum) + 1);
                }
                return 1;
            } else {
                return 0;
            }

        } else {
            int ways = 0;
            ways += process2(arr, W, index + 1, end, sum, map);
            ways += process2(arr, W, index + 1, end, arr[index] + sum, map);
            return ways;
        }
    }

    public static int ways2(int[] arr, int w) {
        int N = arr.length;
        int[][] dp = new int[N + 1][w + 1];
        for (int j = 0; j <= w; j++) {
            dp[N][j] = 1;
        }
        for (int i = N - 1; i >= 0; i--) {
            for (int j = 0; j <= w; j++) {
                dp[i][j] = dp[i + 1][j] + ((j - arr[i] >= 0) ? dp[i + 1][j - arr[i]] : 0);
            }
        }
        return dp[0][w];
    }

    public static int ways3(int[] arr, int w) {
        int N = arr.length;
        int[][] dp = new int[N][w + 1];
        for (int i = 0; i < N; i++) {
            dp[i][0] = 1;
        }
        if (arr[0] <= w) {
            dp[0][arr[0]] = 1;
        }
        for (int i = 1; i < N; i++) {
            for (int j = 1; j <= w; j++) {
                dp[i][j] = dp[i - 1][j] + ((j - arr[i]) >= 0 ? dp[i - 1][j - arr[i]] : 0);
            }
        }
        int ans = 0;
        for (int j = 0; j <= w; j++) {
            ans += dp[N - 1][j];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 9, 3};
        int w = 3;
        System.out.println(ways1(arr, w));
        System.out.println(ways2(arr, w));
        System.out.println(ways3(arr, w));
        System.out.println(dp1(arr, w));
        System.out.println(ways(arr, w));

    }

}
