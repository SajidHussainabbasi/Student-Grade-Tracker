import java.util.*;

public class GradeTracker {
    private static Map<Student, List<Grade>> studentGrades = new HashMap<>();

    public static void main(String[] args) {
        // Create sample students
        Student s1 = new Student("Ali", "S001");
        Student s2 = new Student("Sara", "S002");

        // Create courses
        Course c1 = new Course("Mathematics");
        Course c2 = new Course("Physics");
        Course c3 = new Course("Computer Science");

        // Add grades
        addGrade(s1, new Grade(c1, 85));
        addGrade(s1, new Grade(c2, 70));
        addGrade(s1, new Grade(c3, 35)); // failing grade

        addGrade(s2, new Grade(c1, 90));
        addGrade(s2, new Grade(c3, 55));

        System.out.println("🎓 All Student Grades:");
        showAllGrades();

        System.out.println("\n🧹 Removing failing grades...");
        removeFailingGrades();

        System.out.println("\n📊 Updated Grades After Removing Failing:");
        showAllGrades();

        System.out.println("\n📈 Average Grades:");
        showAverages();
    }

    // Add a grade for a student
    public static void addGrade(Student student, Grade grade) {
        studentGrades.computeIfAbsent(student, k -> new ArrayList<>()).add(grade);
    }

    // Display all grades
    public static void showAllGrades() {
        for (Map.Entry<Student, List<Grade>> entry : studentGrades.entrySet()) {
            System.out.println(entry.getKey().getName() + " Grades:");
            for (Grade g : entry.getValue()) {
                System.out.println("  - " + g);
            }
        }
    }

    // Remove failing grades using Iterator
    public static void removeFailingGrades() {
        for (List<Grade> grades : studentGrades.values()) {
            Iterator<Grade> iterator = grades.iterator();
            while (iterator.hasNext()) {
                if (iterator.next().isFailing()) {
                    iterator.remove();
                }
            }
        }
    }

    // Calculate and display averages
    public static void showAverages() {
        for (Map.Entry<Student, List<Grade>> entry : studentGrades.entrySet()) {
            List<Grade> grades = entry.getValue();
            double total = 0;
            for (Grade g : grades) {
                total += g.getMarks();
            }
            double average = grades.isEmpty() ? 0 : total / grades.size();
            System.out.printf("%s: %.2f%%\n", entry.getKey().getName(), average);
        }
    }
}
