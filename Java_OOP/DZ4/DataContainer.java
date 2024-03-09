package DZ4;

import java.util.Arrays;



public class DataContainer<T> {
    private static final int INITIAL_CAPACITY = 10;
    private T[] data;
    private int size;

    public DataContainer() {
        this.data = (T[]) new Object[INITIAL_CAPACITY];
        this.size = 0;
    }

    public void add(T item) {
        if (size >= data.length) {
            ensureCapacity();
        }
        data[size++] = item;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return data[index];
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        size--;
    }

    public int getSize() {
        return size;
    }

    private void ensureCapacity() {
        int newCapacity = data.length * 2;
        data = Arrays.copyOf(data, newCapacity);
    }

    public static void main(String[] args) {
// Создание контейнера для строк
        DataContainer<String> stringContainer = new DataContainer<>();

// Добавление элементов в контейнер
        stringContainer.add("Apple");
        stringContainer.add("Banana");
        stringContainer.add("Orange");

// Получение и удаление элемента по индексу
        String fruit = stringContainer.get(1);
        System.out.println("Fruit at index 1: " + fruit);
        stringContainer.remove(1);

// Вывод размера контейнера
        System.out.println("Size of container: " + stringContainer.getSize());
    }
}