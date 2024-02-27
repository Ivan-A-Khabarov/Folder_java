package DZ1.dz3;
class Calculator {
    public double calculate(char op, int a, int b) {
        double result = 0.0;
        switch(op) {
            case '+':
                result = (double) a + b;
                break;
            case '-':
                result = (double) a - b;
                break;
            case '*':
                result = (double) a * b;
                break;
            case '/':
                if(b != 0) {
                    result = (double) a / b;
                } else {
                    System.out.println("Ошибка: деление на ноль");
                    System.exit(1); // Выход из программы с кодом ошибки
                }
                break;
            default:
                System.out.println("Некорректный оператор: " + op);
                System.exit(1); // Выход из программы с кодом ошибки
        }
        return result;
    }
}

// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
public class Printer{
    public static void main(String[] args) {
        int a = 0;
        char op = ' ';
        int b = 0;

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            a = 3;
            op = '+';
            b = 7;
        } else {
            a = Integer.parseInt(args[0]);
            op = args[1].charAt(0);
            b = Integer.parseInt(args[2]);
        }

        Calculator calculator = new Calculator();
        double result = calculator.calculate(op, a, b);
        System.out.println(result);
    }
}
