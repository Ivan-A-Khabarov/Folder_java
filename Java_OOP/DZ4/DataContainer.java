package DZ4;
// Создайте обобщенный класс DataContainer, который будет представлять контейнер для хранения данных любого типа. Этот класс должен иметь обобщенный параметр T, представляющий тип данных, которые будут храниться в контейнере.

// Класс DataContainer должен иметь следующие методы:

// add(T item): метод для добавления элемента в контейнер.
// get(int index): метод для получения элемента по индексу из контейнера.
// remove(int index): метод для удаления элемента по индексу из контейнера.
// getSize(): метод для получения размера контейнера.
// Реализуйте класс DataContainer таким образом, чтобы он мог хранить элементы внутри себя в виде массива. Предусмотрите динамическое расширение массива при добавлении новых элементов.

// Пример использования:

// // Создание контейнера для строк
// DataContainer<String> stringContainer = new DataContainer<>();

// // Добавление элементов в контейнер
// stringContainer.add("Apple");
// stringContainer.add("Banana");
// stringContainer.add("Orange");

// // Получение и удаление элемента по индексу
// String fruit = stringContainer.get(1);
// System.out.println("Fruit at index 1: " + fruit);
// stringContainer.remove(1);

// // Вывод размера контейнера
// System.out.println("Size of container: " + stringContainer.getSize());
// Ожидаемый вывод:

// Fruit at index 1: Banana
// Size of container: 2
// Дополнительные указания:

// При реализации метода add, учитывайте необходимость расширения массива, если его текущий размер недостаточен для добавления нового элемента.
// При реализации метода remove, удалите элемент из массива и сдвиньте оставшиеся элементы влево для замещения удаленного элемента.
// Убедитесь, что ваш класс обрабатывает ситуации, когда элементы не найдены или индекс выходит за пределы размера контейнера.

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
