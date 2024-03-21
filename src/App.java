public class App {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 3; i++) { // 0->25
            sb.append((char)((int)(Math.random() * 26) + 'a'));
        }
        for (int i = 4; i < 13; i++) {
            sb.append((char)((int)(Math.random() * 10) + '0'));
        }
        System.out.println(sb.toString());
    }

}
