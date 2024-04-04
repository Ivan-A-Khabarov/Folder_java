package Java_exception.les1.dz1;

class Answer {
    public static void arrayOutOfBoundsException() {
        int[] arr = {1, 2, 3};
        // Попытка обратиться к элементу за пределами массива
        int element = arr[5];
    }

    public static void divisionByZero() {
        int numerator = 10;
        int denominator = 0;
        // Попытка деления на ноль
        int result = numerator / denominator;
    }

    public static void numberFormatException() {
        String str = "abc";
        // Попытка преобразовать строку в число
        int num = Integer.parseInt(str);
    }
}

public class Printer {
    public static void main(String[] args) {
        Answer ans = new Answer();
        try {
            ans.arrayOutOfBoundsException();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Выход за пределы массива");
        }

        try {
            ans.divisionByZero();
        } catch (ArithmeticException e) {
            System.out.println("Деление на ноль");
        }

        try {
            ans.numberFormatException();
        } catch (NumberFormatException e) {
            System.out.println("Ошибка преобразования строки в число");
        }
    }
}
