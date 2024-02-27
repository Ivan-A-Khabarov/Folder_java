package DZ4.dz2;

import java.util.Arrays;
import java.util.ArrayList;

class Answer {
    public static void removeEvenNumbers(Integer[] arr) {
        // Создаем список для хранения нечетных чисел
        ArrayList<Integer> oddNumbers = new ArrayList<>();

        // Проходимся по массиву и добавляем в список только нечетные числа
        for (Integer num : arr) {
            if (num % 2 != 0) {
                oddNumbers.add(num);
            }
        }

        // Преобразуем список обратно в массив
        Integer[] result = new Integer[oddNumbers.size()];
        result = oddNumbers.toArray(result);

        // Выводим результат
        System.out.println(Arrays.toString(result));
    }
}

// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
public class Printer{
    public static void main(String[] args) {
        Integer[] arr = {};

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            arr = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        }
        else{
            arr = Arrays.stream(args[0].split(", "))
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new);
        }

        Answer ans = new Answer();
        ans.removeEvenNumbers(arr);
    }
}