package jni;

public class Main {
    static{
        System.loadLibrary("main");
    }
    native void test();

    public static void main(String[] args) {
        Main main = new Main();
        main.test();
    }
}
