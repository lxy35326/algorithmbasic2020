import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegex1 {
    public static void main(String[] args) {
        //判断一个字符串的开始字符和结束字符是否一致，只考虑一个字符
        String regex1 = "(.).+\\1";
        Pattern compile = Pattern.compile(regex1);
        System.out.println("a1231a2".matches(regex1));

        String regex2 = "(.+).*\\1";
        System.out.println("a123a".matches(regex2));
        System.out.println("aa".matches(regex2));
        String regex3 = "(.)(\\1+)";
        String s = "我要学学编编编编程程".replaceAll(regex3,"$1");
        System.out.println(s);
    }
}
