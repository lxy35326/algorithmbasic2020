import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Test {
    public static void main(String[] args) throws IOException {
        StringReader sr = new StringReader("this \ris a test");
        StreamTokenizer st = new StreamTokenizer(sr);
        st.eolIsSignificant(true);
        while (st.nextToken() != -1) {
            System.out.println(st);
        }

        for (int i = 160; i < 256; i++) {
            System.out.print(i + " , " + (char) i + " \t");
        }
        System.out.println();
        System.out.println(32 == ' ');
        System.out.println((int) '\r');
        System.out.println((int) '\n');
        System.err.println("this is an error message!\n\n111");

        Properties properties = System.getProperties();
        properties.forEach(
                (k,v) ->{
                    System.out.println(k+" : " + v);
                }
        );
        System.out.println("_____________________________");
        Map<String, String> getenv = System.getenv();
        getenv.forEach(
                (k,v) ->{
                    System.out.println(k+" : " + v);
                }
        );
        System.out.println("CPU数量是："+Runtime.getRuntime().availableProcessors());
        Runtime.getRuntime().exit(0);

    }
}
