package com;

public class MyException extends Exception{
    String S;

    public MyException(String s) {
        S = s;
    }
    public void priS(){
        System.out.println(S);
    }
}


