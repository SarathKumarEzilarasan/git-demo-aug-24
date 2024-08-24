package demo;

public class Student {
    private String name;
    private String department;
    private int age;
    private int grade;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Student(String name, String department, int age, int grade) {
        this.name = name;
        this.department = department;
        this.age = age;
        this.grade = grade;
    }

    @Override
    public boolean equals(Object obj) {
        Student s2 = (Student) obj;
        boolean nameFlag = this.getName().equals(s2.getName());
        boolean departmentFlag = this.getDepartment().equals(s2.getDepartment());
        boolean ageFlag = false;
        if (this.getAge() - s2.getAge() == 0) {
            ageFlag = true;
        }
        boolean gradeFlag = false;
        if (this.getGrade() - s2.getGrade() == 0) {
            gradeFlag = true;
        }

        return nameFlag && departmentFlag && ageFlag && gradeFlag;
    }

    @Override
    public int hashCode() {
        return this.name.length() + this.age + this.department.length() + this.grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", age=" + age +
                ", grade=" + grade +
                '}';
    }
}
