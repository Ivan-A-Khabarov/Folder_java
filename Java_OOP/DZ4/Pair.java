package DZ4;

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
        System.out.println("Первый элемент: " + pair.getFirst());
        System.out.println("Второй элемент: " + pair.getSecond());

        pair.setFirst(20);
        pair.setSecond("World");
        System.out.println("Обновление первого элемента: " + pair.getFirst());
        System.out.println("Обновление второго элемента: " + pair.getSecond());
    }
}