package com;

public class T {
    public static void main(String[] args) {
        float f1 = 0.0f;
        float f2 = f();
        System.out.println(f1 == f2);
    }
    static float f(){
        return -0.0f;
    }
}
