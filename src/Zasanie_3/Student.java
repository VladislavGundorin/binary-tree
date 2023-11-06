package Zasanie_3;

public class Student implements Comparable<Student> {
    private String name;
    private int grade;

    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

    @Override
    public int compareTo(Student other) {
        int gradeComparison = Integer.compare(other.getGrade(), this.getGrade());
        if (gradeComparison != 0) {
            return gradeComparison;
        }
        return this.getName().compareTo(other.getName());
    }

}
