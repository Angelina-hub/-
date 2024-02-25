import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentPerformance {
    private List<Student> students;

    public StudentPerformance() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void sortByLastName() {
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.getFam().compareTo(s2.getFam());
            }
        });
    }

    public void sortByMark() {
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return Integer.compare(s2.getMark(), s1.getMark());
            }
        });
    }

    public void printStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public static void main(String[] args) {
        StudentPerformance performance = new StudentPerformance();

        performance.addStudent(new Student(1, "Иванов", "Иван", "Группа1", "Отделение1", "Математика", 85, "Учитель1"));
        performance.addStudent(new Student(2, "Петров", "Петр", "Группа2", "Отделение2", "Физика", 75, "Учитель2"));
        performance.addStudent(new Student(3, "Сидоров", "Алексей", "Группа3", "Отделение3", "История", 90, "Учитель3"));

        System.out.println("Сортировка по фамилиям:");
        performance.sortByLastName();
        performance.printStudents();

        System.out.println("\nСортировка по баллам ЕГЭ:");
        performance.sortByMark();
        performance.printStudents();
    }
}