package class19;

public class Convert {
    /**
     * 有多少种转换的结果
     * @param s 要转换的字符串
     * @return 有多少种转换的结果
     */
    static int convert(String s){
        char[] charArray = s.toCharArray();
        return process(charArray,0);
    }
    static int process(char[] s, int index) {
        if (index == s.length) {
            return 1;
        }
        if (s[index] == '0') {
            return 0;
        }
        int p1 = process(s, index + 1);
        int ans = p1;
        if (index + 1 < s.length && (s[index] - 'a') * 10 + s[index + 1] - 'a' < 27){
            int p2 = process(s,index + 2);
            ans += p2;
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(convert("12111"));
    }
}
