import com.sun.deploy.panel.JreFindDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

class Main extends JFrame implements ActionListener {
    Main(){

    }
    //这个函数用来判断n是不是回文数
    static boolean fun(int n){
        int copy = n;
        int count = 0;
        int r = 0;
        while(copy != 0) {
            count++;
            r = r * 10 + copy % 10;
            copy/=10;
        }
        return r == n;
    }
    public static void main(String[] args) {

        Outer.Inner inner = new Outer().new Inner();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
class Outer{
    class Inner{

    }
}
class School{
    private String Name;
    private int Birthday;
    private String SchoolMotto;

    public School(String Name, int Birthday, String SchoolMotto) {
        this.Name = Name;
        this.Birthday = Birthday;
        this.SchoolMotto = SchoolMotto;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setBirthday(int Birthday) {
        this.Birthday = Birthday;
    }

    public void setSchoolMotto(String SchoolMotto) {
        this.SchoolMotto = SchoolMotto;
    }
}