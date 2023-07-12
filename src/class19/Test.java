package class19;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.TreeMap;

class One{
    synchronized void dis(int num){
        System.out.println("two "+num);
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            System.out.println("中断");
        }
        System.out.println("完成");
    }
}
class Two implements Runnable{
    int number;
    One one;
    Thread t;

    public Two(One one,int number) {
        this.number = number;
        this.one = one;
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        one.dis(number);
    }
}
public class Test {
    public static void main(String[] args) throws Exception {
        One one = new One();
        int digit = 100;
        Two s1 = new Two(one,digit);
        Two s2 = new Two(one,digit);
        Two s3 = new Two(one,digit);
        Two s4 = new Two(one,digit);
        s1.t.join();
        s2.t.join();
        s3.t.join();
        s4.t.join();
        System.out.println("Synch 结束！");

    }

}
