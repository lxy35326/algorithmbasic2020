public class Student implements Comparable<Student>{
    String name;
    String number;
    int age;
    String sex;
    double yuwen,shuxue,yingyu,zong,pingjun;

    public Student(String name, String number, int age, String sex, double yuwen, double shuxue, double yingyu) {
        this.name = name;
//        if (name instanceof )
        this.number = number;
        this.age = age;
        this.sex = sex;
        this.yuwen = yuwen;
        this.shuxue = shuxue;
        this.yingyu = yingyu;
        zong = yuwen + shuxue + yingyu;
        pingjun = zong / 3;
    }

    @Override
    public int compareTo(Student o) {
        double r = zong - o.zong;
        if (r == 0) return 0;
        else if(r > 0) return 1;
        else return -1;
    }
}
