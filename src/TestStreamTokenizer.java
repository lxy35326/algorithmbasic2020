import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TestStreamTokenizer {
    private static final int QUOTE_CHARACTER = '\'';
    private static final int DOUBLE_QUOTE_CHARACTER = '"';

    public static void main(String[] args) throws IOException {
        StreamTokenizer streamTokenizer = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
//        streamTokenizer.ordinaryChars('\n','\n');
        List<Object> tokens = new ArrayList<>();
        int currentToken = streamTokenizer.nextToken();
        while (currentToken != StreamTokenizer.TT_EOF) {
            if (streamTokenizer.ttype == StreamTokenizer.TT_NUMBER) {
                tokens.add(streamTokenizer.nval);
            } else if (streamTokenizer.ttype == StreamTokenizer.TT_WORD
                    || streamTokenizer.ttype == QUOTE_CHARACTER
                    || streamTokenizer.ttype == DOUBLE_QUOTE_CHARACTER) {
                tokens.add(streamTokenizer.sval);
            } else {
                tokens.add((char) currentToken);
            }
            currentToken = streamTokenizer.nextToken();
            System.out.println("*");
        }
        System.out.println("-----------------");

        for (Object token : tokens) {
            System.out.println(token);
        }
    }
}
