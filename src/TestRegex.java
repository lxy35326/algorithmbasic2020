import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.math.BigDecimal.ROUND_HALF_UP;

public class TestRegex {
    public static void main(String[] args) {
        double[] x = {2.6, 9.7, 19.2, 37, 46.8};
        BigDecimal[] xx = new BigDecimal[x.length];
        for (int i = 0; i < xx.length; i++) {
            xx[i] = BigDecimal.valueOf(x[i]);
        }
        for (BigDecimal v : xx) {
            BigDecimal add = BigDecimal.valueOf(0.0462).multiply(v).add(BigDecimal.valueOf(0.4276));
            System.out.println(add.multiply(BigDecimal.valueOf(5)).divide(BigDecimal.valueOf(10.019),6, RoundingMode.HALF_UP).toPlainString()
            );
        }
    }
}
