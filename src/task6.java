import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student {
    private String lastName;
    private int egeScore;

    public Student(String lastName, int egeScore) {
        this.lastName = lastName;
        this.egeScore = egeScore;
    }

    public String getLastName() {
        return lastName;
    }

    public int getEgeScore() {
        return egeScore;
    }

    @Override
    public String toString() {
        return "Студент: " + lastName + ", балл ЭГЕ: " + egeScore;
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Иванов", 80));
        students.add(new Student("Петров", 75));
        students.add(new Student("Сидоров", 90));
        students.add(new Student("Козлов", 85));

        // Сортировка сначала по фамилиям студентов, затем по баллам ЭГЕ
        Collections.sort(students, Comparator.comparing(Student::getLastName).thenComparing(Student::getEgeScore));

        // Вывод отсортированного списка
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
