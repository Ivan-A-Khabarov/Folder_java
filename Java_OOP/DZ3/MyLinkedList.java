package DZ3;

import java.util.Iterator;

//Итератор и итерируемость (Iterable):
//
//Создайте класс MyLinkedList, который будет представлять собой простую односвязную цепочку.
//Реализуйте интерфейс Iterable для этого класса. Это позволит перебирать элементы списка с помощью цикла for-each.
//Напишите методы добавления, удаления и получения элементов из списка в классе MyLinkedList.
//Создайте тестовый класс для проверки функциональности MyLinkedList, включая использование цикла for-each для перебора элементов списка.
//Компаратор и компарируемость (Comparator и Comparable):

public class MyLinkedList<T> implements Iterable<T> {
    private Node<T> head;

    // Метод для добавления элемента в конец списка
    public void add(T data) {
        if (head == null) {
            head = new Node<>(data);
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node<>(data);
        }
    }

    // Метод для удаления элемента из списка
    public void remove(T data) {
        if (head == null) {
            return;
        }
        if (head.data.equals(data)) {
            head = head.next;
            return;
        }
        Node<T> current = head;
        while (current.next != null) {
            if (current.next.data.equals(data)) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    // Метод для получения элемента по индексу
    public T get(int index) {
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            if (current == null) {
                return null;
            }
            current = current.next;
        }
        if (current == null) {
            return null;
        }
        return current.data;
    }

    // Реализация интерфейса Iterable
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }

    // Вложенный класс Node, представляющий узел списка
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }
}

// Класс для тестирования MyLinkedList
class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        System.out.println("MyLinkedList:");
        for (Integer i : list) {
            System.out.println(i);
        }
    }
}
