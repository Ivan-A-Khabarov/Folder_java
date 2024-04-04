package Java_exception.les1.dz3;

import java.util.Arrays;

class Answer {
    public int[] divArrays(int[] a, int[] b) {
        // Проверяем, равны ли длины массивов
        if (a.length != b.length) {
            // Возвращаем массив с нулевым элементом
            return new int[]{0};
        }

        // Создаем новый массив для хранения результатов деления
        int[] c = new int[a.length];

        // Заполняем массив c результатами деления элементов массивов a и b
        for (int i = 0; i < a.length; i++) {
            if (b[i] == 0) {
                // Если делитель равен 0, выбрасываем исключение RuntimeException
                throw new RuntimeException("Деление на ноль недопустимо");
            }
            c[i] = a[i] / b[i];
        }

        return c;
    }
}

// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
public class Printer{
    public static void main(String[] args) {
        int[] a = {};
        int[] b = {};

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            a = new int[]{12, 8, 16};
            b = new int[]{4, 2, 4};
        }
        else{
            a = Arrays.stream(args[0].split(", ")).mapToInt(Integer::parseInt).toArray();
            b = Arrays.stream(args[1].split(", ")).mapToInt(Integer::parseInt).toArray();
        }

        Answer ans = new Answer();
        String itresume_res = Arrays.toString(ans.divArrays(a, b));
        System.out.println(itresume_res);
    }
}