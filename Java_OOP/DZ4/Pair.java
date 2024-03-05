package DZ4;

//Задание:
//
//Создайте класс Pair, который будет представлять пару значений любого типа.
// Этот класс должен иметь два обобщенных параметра: T и U, которые будут представлять типы значений первого
// и второго элементов пары соответственно.
//
//Класс Pair должен иметь следующие методы:
//
//getFirst(): метод для получения первого элемента пары.
//getSecond(): метод для получения второго элемента пары.
//setFirst(T first): метод для установки значения первого элемента пары.
//setSecond(U second): метод для установки значения второго элемента пары.
//
//
//Пример использования:
//
//Pair<Integer, String> pair = new Pair<>(10, "Hello");
//System.out.println("First element: " + pair.getFirst());
//        System.out.println("Second element: " + pair.getSecond());
//
//        pair.setFirst(20);
//pair.setSecond("World");
//System.out.println("Updated first element: " + pair.getFirst());
//        System.out.println("Updated second element: " + pair.getSecond());
//
//
//Ожидаемый вывод:
//
//First element: 10
//Second element: Hello
//Updated first element: 20
//Updated second element: World
//В этом примере класс Pair используется для хранения пары значений: целого числа и строки.
// Методы getFirst() и getSecond() используются для получения значений первого и второго элементов пары соответственно,
// а методы setFirst() и setSecond() - для изменения значений этих элементов.

public class Pair<T, U> {
    private T first;
    private U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public void setSecond(U second) {
        this.second = second;
    }

    public static void main(String[] args) {
        Pair<Integer, String> pair = new Pair<>(10, "Hello");
        System.out.println("First element: " + pair.getFirst());
        System.out.println("Second element: " + pair.getSecond());

        pair.setFirst(20);
        pair.setSecond("World");
        System.out.println("Updated first element: " + pair.getFirst());
        System.out.println("Updated second element: " + pair.getSecond());
    }
}