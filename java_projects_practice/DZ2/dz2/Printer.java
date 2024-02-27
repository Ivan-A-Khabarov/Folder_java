package DZ2.dz2;

import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.text.SimpleDateFormat;
import java.util.Date;

class BubbleSort {
    private static File log;
    private static FileWriter fileWriter;

    public static void sort(int[] mas) {
        try {
            // Создаем или очищаем файл для логирования
            log = new File("log.txt");
            log.createNewFile();
            fileWriter = new FileWriter(log, false);

            // Производим сортировку пузырьком
            int n = mas.length;
            boolean swapped;
            for (int i = 0; i <= n - 1; i++) {
                swapped = false;
                for (int j = 0; j < n - i - 1; j++) {
                    if (mas[j] > mas[j + 1]) {
                        // Меняем элементы местами
                        int temp = mas[j];
                        mas[j] = mas[j + 1];
                        mas[j + 1] = temp;

                        swapped = true;
                    }
                }

                // Логируем состояние массива после каждой итерации
                logArrayState(mas);

                // Если не было обменов, то массив уже отсортирован
                if (!swapped) {
                    break;
                }
            }

            // Закрываем FileWriter после завершения сортировки
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void logArrayState(int[] arr) {
        try {
            // Получаем текущую дату и время
            Date now = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

            // Логируем массив и текущую дату и время
            fileWriter.write(dateFormat.format(now) + " " + Arrays.toString(arr) + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
public class Printer{
    public static void main(String[] args) {
        int[] arr = {};

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            arr = new int[]{9, 4, 8, 3, 1};
        }
        else{
            arr = Arrays.stream(args[0].split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        BubbleSort ans = new BubbleSort();
        ans.sort(arr);

        try (BufferedReader br = new BufferedReader(new FileReader("log.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}