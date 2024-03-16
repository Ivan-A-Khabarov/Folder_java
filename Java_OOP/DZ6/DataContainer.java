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
    private DataArray<T> data;
    private int size;

    public DataContainer(DataArray<T> dataArray) {
        this.data = dataArray;
        this.size = 0;
    }

    public DataContainer() {
        this(new DynamicArray<>(INITIAL_CAPACITY));
    }

    public void add(T item) {
        if (size >= data.length()) {
            data.ensureCapacity();
        }
        data.set(size++, item);
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return data.get(index);
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        data.remove(index);
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