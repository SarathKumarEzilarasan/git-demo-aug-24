package demo;

import java.util.*;

public class Test1 {
    public static void main(String[] args) {
        // comparable , comparator
        Student student1 = new Student("john", "cs", 22, 10);
        Student student2 = new Student("peter", "cs", 20, 8);

//        AgeComparator ageComparator = new AgeComparator();
//        System.out.println(ageComparator.compare(student1, student2));
//
//        GradeComparator gradeComparator = new GradeComparator();
//        System.out.println(gradeComparator.compare(student1, student2));

//        TreeSet<Student> treeSet = new TreeSet<>(new AgeComparator());




    }
}

class AgeComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getAge() - o2.getAge();
    }
}

class GradeComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getGrade() - o2.getGrade();
    }
}