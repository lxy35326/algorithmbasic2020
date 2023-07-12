package class19;

public class bag {
    static int bag(int[] weight, int[] value, int v) {
        int len = weight.length;
        int[][] dp = new int[len + 1][v + 1];
        for (int i = 0; i < len + 1; i++) {
            for (int j = 0; j < v + 1; j++) {
                dp[i][j] = -1;
            }
        }

        return process(weight, value, 0, v, dp);
    }

    static int bag1(int[] weight, int[] value, int v) {
        int len = weight.length;
        int[][] dp = new int[len + 1][v + 1];
        //index == weight.length: 0
        for (int j = 0; j < v + 1; j++) {
            dp[len][j] = 0;
        }
        for (int i = len - 1 ; i >=0; i--)
            for (int j = 0; j < v + 1; j++) {
                dp[i][j] = dp[i + 1][j];
                if (j >= weight[i]){
                    int p2 = dp[i + 1][j - weight[i]] + value[i];
                    if(dp[i][j] < p2)
                        dp[i][j] = p2;
                }
            }

        return dp[0][v];
    }
    static int process(int[] weight, int[] value, int index, int v, int[][] dp) {
        if (dp[index][v] != -1) return dp[index][v];
        if (index == weight.length) return 0;
        if (v == 0) return 0;

        //index:0 - len v: 0 - v
        int ans = process(weight, value, index + 1, v, dp);
        if (v - weight[index] >= 0) {
            ans = Math.max(ans, value[index] + process(weight, value, index + 1, v - weight[index], dp));
        }
        dp[index][v] = ans;
        return ans;
    }

    interface M{
        default void method(){
            System.out.println("hello");
        }
    }
    public static void main(String[] args) {
        int[] weights = {3, 2, 4, 7, 3, 1, 7};
        int[] values = {5, 6, 3, 19, 12, 4, 2};
        int bag = 15;
        System.out.println(bag1(weights, values, bag));
        M m = new M() {

        };
        m.method();
    }
}
