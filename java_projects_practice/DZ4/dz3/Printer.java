package DZ4.dz3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Answer {
    public static void analyzeNumbers(Integer[] arr) {
        // Создаем список ArrayList и заполняем его числами из исходного массива arr
        ArrayList<Integer> numberList = new ArrayList<>(Arrays.asList(arr));

        // Сортируем список по возрастанию
        Collections.sort(numberList);

        // Выводим отсортированный список
        System.out.println(numberList);

        // Находим минимальное и максимальное значения в списке
        int min = Collections.min(numberList);
        int max = Collections.max(numberList);

        // Выводим минимальное и максимальное значения
        System.out.println("Minimum is " + min);
        System.out.println("Maximum is " + max);

        // Находим среднее арифметическое значений списка
        int sum = 0;
        for (int num : numberList) {
            sum += num;
        }
        double average = (double) sum / numberList.size();

        // Выводим среднее арифметическое значение
        System.out.println("Average is = " + average);
    }
}

// Класс Printer остается без изменений
public class Printer{
    public static void main(String[] args) {
        Integer[] arr = {};

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            arr = new Integer[]{4, 2, 7, 5, 1, 3, 8, 6, 9};
        } else {
            arr = Arrays.stream(args[0].split(", "))
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new);
        }

        Answer ans = new Answer();
        ans.analyzeNumbers(arr);
    }
}