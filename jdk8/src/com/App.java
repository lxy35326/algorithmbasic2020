package com;

public class App {
    public App() throws Exception{
        throw new MyException("这是我定义的异常!!");
    }

    public static void main(String[] args) {
        try {
            App app = new App();
        } catch (MyException e) {
            java.io.File file = new java.io.File("");
            e.priS();
        }catch (Exception e){

        }

    }
}
