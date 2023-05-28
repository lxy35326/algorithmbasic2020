import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        int[] arr = new int[5];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        char[] c = new char[]{'a','b'};
        for (int a : arr) {
            a = 1;
        }
        for (char cc : c)
            cc = 'c';
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        for (char c1 : c) {
            System.out.println(c1);
        }
    }
}
