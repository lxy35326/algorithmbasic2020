import java.util.Scanner;

class Student{
    private int stuNo;
    private String name;
    private int english;
    private int computer;
    private int math;

    public Student() {
    }

    public Student(int stuNo, String name) {
        this.stuNo = stuNo;
        this.name = name;
    }

    public Student(int stuNo, String name, int english, int computer, int math) {
        this.stuNo = stuNo;
        this.name = name;
        this.english = english;
        this.computer = computer;
        this.math = math;
    }
    public int average(){
        return totalScore() / 3;
    }
    public int totalScore(){
        return english+computer+math;
    }

    @Override
    public String toString() {
        return "学号"+stuNo+"\n姓名"+name+"\n英语成绩"+english+"\n计算机成绩"
                +computer+"\n数学成绩"+ math+"\n平均成绩"+average()+"\n总成绩"
                +totalScore();
    }

    public int getStuNo() {

        return stuNo;
    }

    public void setStuNo(int stuNo) {

        this.stuNo = stuNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        if (english < 0)
        {
            this.english = 0;
            throw new IllegalArgumentException("illegal grade");
        }
        this.english = english;
    }

    public int getComputer() {
        return computer;
    }

    public void setComputer(int computer) {
        if (computer < 0)
        {
            this.computer = 0;
            throw new IllegalArgumentException("illegal grade");
        }
        this.computer = computer;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        if (math < 0)
        {
            this.math = 0;
            throw new IllegalArgumentException("illegal grade");
        }
        this.math = math;
    }

}
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int no = in.nextInt();
        String name = in.next();
        int english = in.nextInt();
        int computer = in.nextInt();
        int math = in.nextInt();
        Student student = new Student();
        student.setStuNo(no);
        student.setName(name);
        try {
            student.setEnglish(english);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            student.setComputer(computer);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            student.setMath(math);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(student);
    }
}
