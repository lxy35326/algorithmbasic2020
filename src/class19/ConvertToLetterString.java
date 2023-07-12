package class19;


//从左向右尝试的模型
public class ConvertToLetterString {
    static int ways1(String s) {
        char[] charArray = s.toCharArray();
        return process(charArray, 0);
    }

    static int ways2(String s) {
        char[] charArray = s.toCharArray();
        return dp(charArray);
    }


    static int dp(char[] str) {
        int n = str.length;
        int[] dp = new int[n + 1];
        dp[n] = 1;
        for (int j = n - 1; j >= 0; j--) {
            if (str[j] == '0') continue;
            int result = dp[j + 1];
            if (j + 1 < n && (str[j] - '0') * 10 + str[j + 1] - '0' < 27) {
                result += dp[j + 2];
            }
            dp[j] = result;
        }
        System.out.println("---");
        for (int i : dp) {
            System.out.println(i);
        }
        System.out.println("---");



        return dp[0];
    }

    static int process(char[] arr, int i) {
        if (i == arr.length) return 1;
        //说明前面的决定有问题，出错了
        if (arr[i] == '0') {
            return 0;
        }
        int p1 = process(arr, i + 1);
        if (i + 1 < arr.length && (arr[i] - '0') * 10 + arr[i + 1] - '0' < 27) {
            p1 += process(arr, i + 2);
        }
        return p1;
    }

    public static void main(String[] args) {
        System.out.println(ways1("101"));
        System.out.println(ways2("101"));
        String s = "\\".replaceAll("\\\\","a");

        System.out.println(s);
    }
}
