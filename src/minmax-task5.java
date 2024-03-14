import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите a: ");
        int a = scanner.nextInt();
        System.out.print("Введите b: ");
        int b = scanner.nextInt();

        int max = Math.max(a, b);
        int min = Math.min(a, b);

        double d = (max - Math.pow(2, Math.log(min) / Math.log(2))) / Math.sin(2) + (double) max / min;

        System.out.println("Наибольшее из a и b: " + max);
        System.out.println("Наименьшее из a и b: " + min);
        System.out.println("Значение d: " + d);

        scanner.close();
    }
}