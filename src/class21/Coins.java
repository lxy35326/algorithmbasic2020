package class21;

public class Coins {
    static int func(int[] arr, int aim){

        return process(arr, aim, 0);
    }
    static int process(int[] arr, int rest, int cur){
        if (rest < 0) {
            return 0;
        }
        if (rest == 0) {
            return 1;
        }
        if (cur == arr.length) {
            return 0;
        }
        //rest != 0, cur没走到最后
        return process(arr, rest, cur + 1) + process(arr, rest - arr[cur], cur + 1);
    }
    static int func1(int[] arr, int aim){
        //rest: 0 -> aim index: 0 -> arr.length
        int len = arr.length;
        int[][] dp = new int[aim + 1][len + 1];
        //最后一列：代表来到了最后一个位置，如果rest == 0，结果是1，否则是0
        dp[0][len] = 1;
        //dp[i][j] = dp[i][j + 1] + dp[i - arr[i]][j + 1]
        //如果i-arr[j] < 0，就没有这种解法

        for (int j = len - 1; j >= 0; j--) {
            dp[0][j] = dp[0][j + 1];
            for (int i = 1; i < aim + 1; i++) {
                dp[i][j] = dp[i][j + 1];
                int temp = i - arr[j];
                if (temp >= 0) {
                    dp[i][j] += dp[temp][j + 1];
                }
            }
        }
        return dp[aim][0];
    }

    static int func2(int[] arr, int aim){
        //rest: 0 -> aim index: 0 -> arr.length
        if (arr==null ){
                if(aim != 0)
            return 0;
                else  return 1;
        }
        int len = arr.length;
        if (len == 0){
            if (aim != 0)
            return 0;
            return 1;
        }
        int[] dp = new int[aim + 1];
        //最后一列：代表来到了最后一个位置，如果rest == 0，结果是1，否则是0
        dp[0] = 1;
        //dp[i][j] = dp[i][j + 1] + dp[i - arr[i]][j + 1]
        //如果i-arr[j] < 0，就没有这种解法

        for (int j = len - 1; j > 0; j--) { // 从len - 1 -> 0
            for (int i = aim; i >= 0; i--) {
                int temp = i - arr[j];
                if (temp >= 0)
                    dp[i] += dp[temp];
            }
        }
        int temp = aim - arr[0];
        if (temp >= 0)
            dp[aim] += dp[temp];
        return dp[aim];
    }
    public static void main(String[] args) {

    }
}
