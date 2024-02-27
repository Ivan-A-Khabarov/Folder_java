package DZ5.dz3;

import java.util.Arrays;

class HeapSort {
    public static void buildTree(int[] tree, int sortLength) {
        // Начинаем строить кучу с середины массива, идя до корня (индекс 0)
        for (int i = sortLength / 2 - 1; i >= 0; i--) {
            heapify(tree, sortLength, i);
        }
    }

    // Превращает поддерево с корнем в i в максимальную кучу
    public static void heapify(int[] tree, int sortLength, int i) {
        int largest = i; // Инициализируем корень как наибольший элемент
        int left = 2 * i + 1; // Левый потомок
        int right = 2 * i + 2; // Правый потомок

        // Если левый потомок больше корня
        if (left < sortLength && tree[left] > tree[largest]) {
            largest = left;
        }

        // Если правый потомок больше корня
        if (right < sortLength && tree[right] > tree[largest]) {
            largest = right;
        }

        // Если самый большой элемент не корень
        if (largest != i) {
            int temp = tree[i];
            tree[i] = tree[largest];
            tree[largest] = temp;

            // Продолжаем heapify для измененного поддерева
            heapify(tree, sortLength, largest);
        }
    }

    public static void heapSort(int[] sortArray, int sortLength) {
        buildTree(sortArray, sortLength);

        // Постепенно уменьшаем размер кучи на один, чтобы получить отсортированный массив
        for (int i = sortLength - 1; i > 0; i--) {
            // Перемещаем текущий корень в конец
            int temp = sortArray[0];
            sortArray[0] = sortArray[i];
            sortArray[i] = temp;

            // Вызываем heapify для уменьшенной кучи
            heapify(sortArray, i, 0);
        }
    }
}

// Не удаляйте и не меняйте метод Main!
public class Printer {
    public static void main(String[] args) {
        int[] initArray;

        if (args.length == 0) {
            initArray = new int[]{17, 32, 1, 4, 25, 17, 0, 3, 10, 7, 64, 1};
        } else {
            initArray = Arrays.stream(args[0].split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        System.out.println("Initial array:");
        System.out.println(Arrays.toString(initArray));
        HeapSort.heapSort(initArray, initArray.length);
        System.out.println("Sorted array:");
        System.out.println(Arrays.toString(initArray));
    }
}