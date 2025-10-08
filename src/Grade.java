public class Grade {
    private Course course;
    private double marks;

    public Grade(Course course, double marks) {
        if (marks < 0 || marks > 100) {
            throw new IllegalArgumentException("Marks must be between 0 and 100");
        }
        this.course = course;
        this.marks = marks;
    }

    public Course getCourse() {
        return course;
    }

    public double getMarks() {
        return marks;
    }

    public boolean isFailing() {
        return marks < 40; // failing if below 40%
    }

    @Override
    public String toString() {
        return course.getCourseName() + ": " + marks;
    }
}
