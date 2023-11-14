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
        int gradeComparison = Integer.compare(this.grade, other.grade);
        if (gradeComparison != 0) {
            return gradeComparison;
        }
        return this.name.compareTo(other.name);
    }


    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

}