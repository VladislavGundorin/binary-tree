package three;

class Student implements Comparable<Student> {
    private String name;
    private int grade;

    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    @Override
    public int compareTo(Student other) {
        return this.name.compareTo(other.name);
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

}