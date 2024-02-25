import java.util.Random;

public class Main {
    public static void main(String[] args) {
        final int rows = 5; // Количество строк
        final int cols = 3; // Количество столбцов
        int[][] matrix = new int[rows][cols]; // Создание двумерного массива

        Random random = new Random();
        // Заполнение матрицы случайными значениями
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = random.nextInt(100); // Заполнение случайным числом от 0 до 99
            }
        }

        // Вывод матрицы на экран
        System.out.println("Матрица:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        // Поиск индекса строки с минимальным значением в i-м столбце
        int columnIndex = 1; // Номер столбца, где ищем минимальное значение
        int minRowIndex = 0;
        int minValue = matrix[0][columnIndex];
        for (int i = 1; i < rows; i++) {
            if (matrix[i][columnIndex] < minValue) {
                minValue = matrix[i][columnIndex];
                minRowIndex = i;
            }
        }

        System.out.println("Индекс строки с минимальным значением в " + columnIndex + "-м столбце: " + minRowIndex);
    }
}