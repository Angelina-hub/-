import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class StudentPerformance {
    private List<Student> students;

    public StudentPerformance() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void sortByLastName() {
        Collections.sort(students, Comparator.comparing(Student::getFam));
    }

    public void sortByMark() {
        Collections.sort(students, Comparator.comparingInt(Student::getMark).reversed());
    }

    public void printStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public static void main(String[] args) {
        StudentPerformance performance = new StudentPerformance();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1. Добавить студента");
            System.out.println("2. Вывести студентов по фамилиям");
            System.out.println("3. Вывести студентов по баллам ЕГЭ");
            System.out.println("4. Выход");

            int choice = scanner.nextInt();
            scanner.nextLine(); // очистка буфера

            switch (choice) {
                case 1:
                    System.out.println("Введите фамилию студента:");
                    String fam = scanner.nextLine();
                    System.out.println("Введите имя студента:");
                    String name = scanner.nextLine();
                    System.out.println("Введите группу студента:");
                    String group = scanner.nextLine();
                    System.out.println("Введите отделение студента:");
                    String department = scanner.nextLine();
                    System.out.println("Введите предмет студента:");
                    String subject = scanner.nextLine();
                    System.out.println("Введите баллы ЕГЭ студента:");
                    int mark = scanner.nextInt();
                    scanner.nextLine(); // очистка буфера
                    System.out.println("Введите имя учителя:");
                    String teacher = scanner.nextLine();

                    performance.addStudent(new Student(performance.students.size() + 1, fam, name, group, department, subject, mark, teacher));
                    break;
                case 2:
                    performance.sortByLastName();
                    performance.printStudents();
                    break;
                case 3:
                    performance.sortByMark();
                    performance.printStudents();
                    break;
                case 4:
                    System.out.println("Выход из программы.");
                    return;
                default:
                    System.out.println("Некорректный ввод. Попробуйте снова.");
            }
        }
    }
}