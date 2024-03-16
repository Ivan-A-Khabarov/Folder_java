package DZ6;

import java.util.Arrays;

// Создаем интерфейс для массива данных
interface DataArray<T> {
    int length();
    T get(int index);
    void set(int index, T element);
    void remove(int index);
    void ensureCapacity();
}

// Реализуем интерфейс с помощью класса массива
class DynamicArray<T> implements DataArray<T> {
    private static final int GROWTH_FACTOR = 2;
    private Object[] array;
    private int size;

    public DynamicArray(int initialCapacity) {
        this.array = new Object[initialCapacity];
        this.size = 0;
    }

    public int length() {
        return array.length;
    }

    public T get(int index) {
        return (T) array[index];
    }

    public void set(int index, T element) {
        array[index] = element;
    }

    public void remove(int index) {
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        size--;
    }

    public void ensureCapacity() {
        int newCapacity = array.length * GROWTH_FACTOR;
        array = Arrays.copyOf(array, newCapacity);
    }
}

// Используем интерфейс в классе DataContainer
public class DataContainer<T> {
    private static final int INITIAL_CAPACITY = 10;
    private final DynamicArray<T> dynamicArray;
    private int size;

    public DataContainer() {
        this.dynamicArray = new DynamicArray<>(INITIAL_CAPACITY);
        this.size = 0;
    }

    public void add(T item) {
        if (size >= dynamicArray.length()) {
            dynamicArray.ensureCapacity();
        }
        dynamicArray.set(size++, item);
    }

    public T get(int index) {
        return dynamicArray.get(index);
    }

    public void remove(int index) {
        dynamicArray.remove(index);
        size--;
    }

    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        DataContainer<String> stringContainer = new DataContainer<>();

        stringContainer.add("Apple");
        stringContainer.add("Banana");
        stringContainer.add("Orange");

        String fruit = stringContainer.get(1);
        System.out.println("Fruit at index 1: " + fruit);
        stringContainer.remove(1);

        System.out.println("Size of container: " + stringContainer.getSize());
    }
}