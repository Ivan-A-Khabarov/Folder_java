package DZ1.dz1;

class Answer {
    public int countNTriangle(int n){
        // Введите свое решение ниже
        if (n < 1) {
            return -1;
        }

        // Инициализируем переменную для хранения суммы
        int sum = 0;

        // Вычисляем сумму чисел от 1 до n
        for (int i = 1; i <= n; i++) {
            sum += i;
        }

        // Возвращаем сумму
        return sum;
    }
}

// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
public class Printer{
    public static void main(String[] args) {
        int n = 0;

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            n = 4;
        }
        else{
            n = Integer.parseInt(args[0]);
        }

        // Вывод результата на экран
        Answer ans = new Answer();
        int itresume_res = ans.countNTriangle(n);
        System.out.println(itresume_res);
    }
}
