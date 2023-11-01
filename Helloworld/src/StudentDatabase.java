import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    private int studentID;
    private String name;
    private double score;

    public Student(int studentID, String name, double score) {
        this.studentID = studentID;
        this.name = name;
        this.score = score;
    }

    public int getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public double getScore() {
        return score;
    }
}

public class StudentDatabase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("No of Students: ");
        int numStudents = scanner.nextInt();
        List<Student> studentList = new ArrayList<>();

        for (int i = 1; i <= numStudents; i++) {
            System.out.println("Student " + i + " :");
            System.out.print("Enter Student Id: ");
            int studentID = scanner.nextInt();
            System.out.print("Enter Student Name: ");
            String name = scanner.next();
            System.out.print("Enter Student Score: ");
            double score = scanner.nextDouble();
            studentList.add(new Student(studentID, name, score));
        }

        if (studentList.isEmpty()) {
            System.out.println("No students in the database.");
        } else {
            double averageScore = getAverageScore(studentList);
            System.out.println("Average Score: " + averageScore);
            Student topScorer = getTopScorer(studentList);
            System.out.println("Top Scorer:");
            System.out.println("Student ID: " + topScorer.getStudentID());
            System.out.println("Name: " + topScorer.getName());
            System.out.println("Score: " + topScorer.getScore());
            double passScore = 70.0; // You can change this passing score as needed.
            System.out.println("Students with a score greater than or equal to " + passScore + ":");
            List<Student> passingStudents = getStudentsWithPassingScore(studentList, passScore);
            for (Student student : passingStudents) {
                System.out.println("Student ID: " + student.getStudentID());
                System.out.println("Name: " + student.getName());
                System.out.println("Score: " + student.getScore());
                System.out.println();
            }
        }
    }

    public static double getAverageScore(List<Student> students) {
        return students.stream()
                .mapToDouble(Student::getScore)
                .average()
                .orElse(0.0);
    }

    public static Student getTopScorer(List<Student> students) {
        return students.stream()
                .max((s1, s2) -> Double.compare(s1.getScore(), s2.getScore()))
                .orElse(null);
    }

    public static List<Student> getStudentsWithPassingScore(List<Student> students, double passScore) {
        return students.stream()
                .filter(student -> student.getScore() >= passScore)
                .toList();
    }
}
