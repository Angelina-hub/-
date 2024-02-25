public class Student {
    private int studentId;
    private String lastName;
    private String firstName;
    private String group;
    private String department;
    private String subject;
    private int mark;
    private String teacherLastName;

    public Student(int studentId, String lastName, String firstName, String group, String department, String subject, int mark, String teacherLastName) {
        this.studentId = studentId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.group = group;
        this.department = department;
        this.subject = subject;
        this.mark = mark;
        this.teacherLastName = teacherLastName;
    }

    @Override
    public String toString() {
        return "Student ID: " + studentId +
                ", Last Name: " + lastName +
                ", First Name: " + firstName +
                ", Group: " + group +
                ", Department: " + department +
                ", Subject: " + subject +
                ", Mark: " + mark +
                ", Teacher Last Name: " + teacherLastName;
    }
}

public class FullTimeStudent extends Student {
    private int egeScore;
    private double averageAttestationScore;

    public FullTimeStudent(int studentId, String lastName, String firstName, String group, String department, String subject, int mark, String teacherLastName, int egeScore, double averageAttestationScore) {
        super(studentId, lastName, firstName, group, department, subject, mark, teacherLastName);
        this.egeScore = egeScore;
        this.averageAttestationScore = averageAttestationScore;
    }
}

public class PartTimeStudent extends Student {
    private String workplace;
    private String position;
    private double tuitionFee;

    public PartTimeStudent(int studentId, String lastName, String firstName, String group, String department, String subject, int mark, String teacherLastName, String workplace, String position, double tuitionFee) {
        super(studentId, lastName, firstName, group, department, subject, mark, teacherLastName);
        this.workplace = workplace;
        this.position = position;
        this.tuitionFee = tuitionFee;
    }
}

public class TargetedStudent extends Student {
    private String companyName;
    private double tuitionFee;

    public TargetedStudent(int studentId, String lastName, String firstName, String group, String department, String subject, int mark, String teacherLastName, String companyName, double tuitionFee) {
        super(studentId, lastName, firstName, group, department, subject, mark, teacherLastName);
        this.companyName = companyName;
        this.tuitionFee = tuitionFee;
    }
}

import java.util.ArrayList;
import java.util.List;

public class StudentPerformance {
    private List<Student> students;

    public StudentPerformance() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void printStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public static void main(String[] args) {
        StudentPerformance performance = new StudentPerformance();

        performance.addStudent(new FullTimeStudent(1, "Ivanov", "Ivan", "A1", "Computer Science", "Programming", 85, "Johnson", 90, 4.5));
        performance.addStudent(new PartTimeStudent(2, "Smirnov", "Alex", "B2", "Engineering", "Mathematics", 75, "Williams", "Company ABC", "Engineer", 2500.0));
        performance.addStudent(new TargetedStudent(3, "Belov", "Danil", "C3", "Business Administration", "Marketing", 80, "Brown", "Company XYZ", 3000.0));

        performance.printStudents();
    }
}