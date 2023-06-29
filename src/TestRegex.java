import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegex {
    public static void main(String[] args) {
        System.out.println("ab".matches("[abc]b"));
        System.out.println("我\\".matches("\\D{1,2}"));
        String s1 = "^magnet:\\?xt=urn:btih:[0-9a-fA-F]{40,}.*$";
        System.out.println("magnet:?xt=urn:btih:1343090D5B58307622C58C581FF26BAD1A4C90BB".matches(s1));

        String target = "Java自从95年问世以来，目前企业中用的最多的是Java8和Java11，因为这两个是长期支持版本，下一个长期支持版本是Java17，" +
                "相信在未来不久Java17也会逐渐登上历史舞台。";
        String regex1 = "Java(?=8|11|17)";
        Pattern compile = Pattern.compile(regex1);
        Matcher matcher = compile.matcher(target);
        while (matcher.find()){
            String group = matcher.group();
            System.out.println(group);
        }
    }
}
