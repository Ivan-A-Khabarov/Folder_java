package DZ1.dz2;

class Answer {
    public void printPrimeNums() {
        for (int i = 2; i <= 1000; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }
    }

    private boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}

// Класс для вывода результатов на экран и проверки
public class Printer {
    public static void main(String[] args) {
        Answer ans = new Answer();
        ans.printPrimeNums();
    }
}
