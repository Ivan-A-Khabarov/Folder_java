package DZ6;

// Взять реализованный код в рамках семинара 4 и продемонстрировать применение принципов, усвоенных на семинаре.
//Нужно в проекте прокомментировать участки кода, которые рефакторим, какой принцип применяем и почему.

interface Pair<T, U> {
    T getFirst();
    U getSecond();
    void setFirst(T first);
    void setSecond(U second);
}

// Создаем класс, который реализует интерфейс Pair, обеспечивая конкретную реализацию.
class GenericPair<T, U> implements Pair<T, U> {
    private T first;
    private U second;

    // Конструктор класса
    public GenericPair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    // Методы, реализующие методы интерфейса Pair
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
}

public class Main {
    public static void main(String[] args) {
        // Создаем объект класса GenericPair, который реализует интерфейс Pair
        Pair<Integer, String> pair = new GenericPair<>(10, "Hello");
        // Выводим первый и второй элементы пары
        System.out.println("First element: " + pair.getFirst());
        System.out.println("Second element: " + pair.getSecond());

        // Изменяем значения первого и второго элементов пары
        pair.setFirst(20);
        pair.setSecond("World");
        // Выводим обновленные значения первого и второго элементов пары
        System.out.println("Updated first element: " + pair.getFirst());
        System.out.println("Updated second element: " + pair.getSecond());
    }
}