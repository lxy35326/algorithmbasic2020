package com;

import org.jetbrains.annotations.NotNull;

import java.util.*;

class Student implements Comparable<Student> {
    String name;
    int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (this == obj) return true;
        if (this.name == null && ((Student) obj).name == null
                || this.name.equals(((Student) obj).name))
            return true;
        return false;
    }

    @Override
    public int compareTo(Student o) {
        return score - o.score;
    }
}

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("tom", 90);
        Student s2 = new Student("alice", 95);
        Student s3 = new Student("tom", 85);
        Student s4 = new Student("jack", 85);
        TreeSet<Student> treeSet = new TreeSet<>();
        treeSet.add(s1);
        treeSet.add(s2);
        treeSet.add(s3);
        treeSet.add(s4);
        for (Student student : treeSet) {
            System.out.println(student.name + ":" + student.score);
        }
    }

}
