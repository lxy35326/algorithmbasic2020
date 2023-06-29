public class Regex {
    public static void main(String[] args) {

        System.out.println("\u0001".matches("\\01"));
        System.out.println("\u0001".matches("\\x01"));
        System.out.println("a".matches("[^b]"));
        System.out.println("aaa".matches("a+"));
        System.out.println("aaa".matches("a*"));
        System.out.println("a".matches("a?"));

        System.out.println("---------------------");
        System.out.println("aaaa".matches("a{3,}?"));
        System.out.println("aaaa".matches("a{3,}"));

        System.out.println("---------------------");
        System.out.println("abc".matches("^abc"));


        System.out.println("___________________________");
        String[] split = "a  b  c".split("\\s");
        System.out.println("长度为："+split.length);
        for (String s : split) {
            System.out.println(s);
        }

        System.out.println("___________________________");
        System.out.println("abc".replaceAll("[a-z]",""));
        System.out.println("19811111111".replaceAll("(\\d{3})\\d{4}","$1****"));
    }
}
