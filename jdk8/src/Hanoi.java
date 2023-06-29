public class Hanoi {
    public static void hanoi(char from, char to, char via, int num) {
        if (num == 1) {
            System.out.printf("%c -> %c\n", from, to);
        } else {
            hanoi(from, via, to, num - 1);
            hanoi(from, to, via, 1);
            hanoi(via, to, from, num - 1);
        }

    }

    public static void main(String[] args) {
        hanoi('A','C','B',3);
    }
}
