import Methods.Sort;
import Methods.Storage;
import Models.Students;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String menu = "Выберите действие: " +
                "\n 1 - Заполнить данные в ручную" +
                "\n 2 - Заполнить данные из файла" +
                "\n 3 - Записать данные в файл" +
                "\n 4 - Вывести данные" +
                "\n 5 - Осортировать данные по фамалии " +
                "\n 6 - Осортировать данные по оценке " +
                "\n 7 - Завершить программу\n";
        Scanner in = new Scanner(System.in);
        ArrayList<Students> students = new ArrayList<>();
        Storage storageStudents = new Storage(students);
        boolean flag = true;
        while (flag) {
            System.out.print(menu);
            int num = in.nextInt();
            switch (num) {
                case 1: {
                    RecordData(storageStudents);
                    break;
                }
                case 2: {
                    ReadDataFile(storageStudents);
                    storageStudents.printStudents();
                    break;
                }
                case 3: {
                    WriteDataFile(storageStudents);
                    break;
                }
                case 4: {
                    storageStudents.printStudents();
                    break;
                }
                case 5: {
                    Sort.sortByName(storageStudents.getStudentsArrayList());
                    storageStudents.printStudents();
                    break;
                }
                case 6: {
                    Sort.sortByMark(storageStudents.getStudentsArrayList());
                    storageStudents.printStudents();
                    break;
                }
                case 7: {
                    flag = false;
                    break;
                }
            }
        }

    }
    public static void RecordData(Storage storageStudents) {
        Scanner in = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.print("Введите идентификатор студента:");
            int id_student = in.nextInt();
            System.out.print("Введите номер зачетки:");
            int numberTheRecordBook = in.nextInt();
            System.out.print("Введите фамилию студента:");
            String surname = in.next();
            System.out.print("Введите имя студента:");
            String name = in.next();
            System.out.print("Введите группу:");
            String group = in.next();
            System.out.print("Введите кафедру:");
            String department = in.next();
            System.out.print("Введите дисциплину:");
            String discipline = in.next();
            System.out.print("Введите оценку:");
            int mark = in.nextInt();
            System.out.print("Введите имя преподавателя:");
            String nameTeacher = in.next();
            storageStudents.addElement(new Students(id_student,numberTheRecordBook,surname,name,group,department,discipline,mark,nameTeacher));
            System.out.print("Ввести еще студентов (1 - да / 0 - нет):");
            if (in.nextInt() != 1) flag = false;
        }
    }

    public static void ReadDataFile(Storage storageStudents) {

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(new File("Data.txt")))) {
            String str;
            while ((str = reader.readLine()) != null)
                storageStudents.addElement(ParseString(str));
            System.out.print("Данные успешно запсианы в файл\n");
        } catch (IOException e) {
            System.out.print("Ошибка!");
            e.printStackTrace();
        }
    }

    public static void WriteDataFile(Storage storageStudents) {
        try (FileWriter writer = new FileWriter("Students.txt", false)) {
            for (Students students : storageStudents.getStudentsArrayList()) {
                writer.write(students.toString());
                writer.append('\n');
            }
            writer.flush();
        } catch (IOException ex) {
            System.out.print("Что-то пошло не так");
            System.out.println(ex.getMessage());
        }

    }

    public static Students ParseString(String str) {
        String[] arrayData = str.split(" ");
        return new Students(Integer.parseInt(arrayData[0]), Integer.parseInt(arrayData[1])
                , arrayData[2], arrayData[3], arrayData[4], arrayData[5],arrayData[6],Integer.parseInt(arrayData[6]),arrayData[7]);

    }
}

