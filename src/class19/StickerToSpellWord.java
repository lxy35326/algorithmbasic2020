package class19;

public class StickerToSpellWord {


    static int process1(String[] stickers, String target) {
        if (target.isEmpty()) return 0;
        int min = Integer.MAX_VALUE;
        for (String sticker : stickers) {
            String rest = minus(target, sticker);
            if (rest.length() != target.length()) {
                int t = process1(stickers, rest);
                min = Math.min(min, t);
            }
        }
        min += (min == Integer.MAX_VALUE ? 0 : 1);
        return min;
    }

    static String minus(String target, String s) {
        char[] src = target.toCharArray();
        char[] dst = s.toCharArray();
        int[] buffer = new int[26];
        for (char c : src) {
            buffer[c - 'a']++;
        }
        for (char c : dst) {
            buffer[c - 'a']--;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < buffer.length; i++) {
            if (buffer[i] > 0) {
                for (int j = 0; j < buffer[i]; j++) {
                    sb.append((char) (i + 'a'));
                }
            }
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        System.out.println((char) (2 + 'a'));
    }
}
