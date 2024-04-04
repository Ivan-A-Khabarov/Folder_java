package Java_exception.les3;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class InvalidDataFormatException extends Exception {
    public InvalidDataFormatException(String message) {
        super(message);
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите данные в формате: Фамилия Имя Отчество дата_рождения(dd.mm.yyyy) номер_телефона(целое беззнаковое число без форматирования) пол(m или f)");
        String inputData = scanner.nextLine();

        try {
            String[] splitData = inputData.split("\\s+");

            if (splitData.length != 6) {
                throw new InvalidDataFormatException("Неверное количество данных");
            }

            String surname = splitData[0];
            String name = splitData[1];
            String patronymic = splitData[2];
            String dateOfBirth = splitData[3];
            long phoneNumber = Long.parseLong(splitData[4]);
            char gender = splitData[5].charAt(0);

            // Проверяем формат даты рождения
            if (!dateOfBirth.matches("\\d{2}\\.\\d{2}\\.\\d{4}")) {
                throw new InvalidDataFormatException("Неверный формат даты рождения");
            }

            // Проверяем пол
            if (gender != 'f' && gender != 'm') {
                throw new InvalidDataFormatException("Неверный формат пола");
            }

            // Записываем данные в файл
            FileWriter writer = new FileWriter(surname + ".txt", true);
            writer.write(surname + " " + name + " " + patronymic + " " + dateOfBirth + " " + phoneNumber + " " + gender + "\n");
            writer.close();

            System.out.println("Данные успешно записаны в файл.");
        } catch (InvalidDataFormatException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: Неверный формат номера телефона");
        } catch (IOException e) {
            System.out.println("Ошибка при работе с файлом:");
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}