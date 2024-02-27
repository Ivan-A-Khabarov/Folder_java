package DZ6.dz_itog;

import java.util.*;
public class PhoneBook {
    public static void main(String[] args) {
        Map<String, Set<String>> phoneBook = new HashMap<>();

        // Пример данных в телефонной книге
        addContact(phoneBook, "Иванов", "123-456-789");
        addContact(phoneBook, "Петров", "111-222-333");
        addContact(phoneBook, "Сидоров", "999-888-777");
        addContact(phoneBook, "Иванов", "555-555-555"); // Добавление дополнительного номера для Иванова

        // Вывод телефонной книги
        printPhoneBook(phoneBook);
    }

    // Метод для добавления контакта в телефонную книгу
    public static void addContact(Map<String, Set<String>> phoneBook, String name, String phoneNumber) {
        // Если имя уже существует в книге, добавляем номер к существующему набору номеров
        if (phoneBook.containsKey(name)) {
            phoneBook.get(name).add(phoneNumber);
        } else {
            // Иначе создаем новую запись
            Set<String> phoneNumbers = new HashSet<>();
            phoneNumbers.add(phoneNumber);
            phoneBook.put(name, phoneNumbers);
        }
    }

    // Метод для печати телефонной книги
    public static void printPhoneBook(Map<String, Set<String>> phoneBook) {
        // Создаем список записей (имя - набор номеров)
        List<Map.Entry<String, Set<String>>> entries = new ArrayList<>(phoneBook.entrySet());

        // Сортируем список по убыванию количества номеров
        entries.sort((entry1, entry2) -> entry2.getValue().size() - entry1.getValue().size());

        // Печатаем отсортированные записи
        for (Map.Entry<String, Set<String>> entry : entries) {
            System.out.println("Имя: " + entry.getKey());
            System.out.println("Номера:");
            for (String phoneNumber : entry.getValue()) {
                System.out.println(phoneNumber);
            }
            System.out.println();
        }
    }
}