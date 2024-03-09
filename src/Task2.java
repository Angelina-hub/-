import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        final int N = 5; // Количество максимальных значений
        int[] array = new int[10]; // Размер исходного массива

        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100); // Заполнение массива случайными значениями от 0 до 99
        }

        System.out.println("Исходный массив: " + Arrays.toString(array));

        Arrays.sort(array); // Сортировка массива

        System.out.print("Массив с " + N + " максимальными значениями: ");
        for (int i = array.length - N; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}