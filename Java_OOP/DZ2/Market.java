package DZ2;

import java.util.LinkedList;
import java.util.Queue;

// Интерфейс для работы с очередью
interface QueueBehaviour {
    void addToQueue(String person);
    String removeFromQueue();
}

// Интерфейс для работы с магазином
interface MarketBehaviour {
    void enterMarket(String person);
    void exitMarket(String person);
}

// Класс, представляющий магазин
public class Market implements QueueBehaviour, MarketBehaviour {
    private Queue<String> queue; // Очередь людей в магазине

    // Конструктор класса
    public Market() {
        queue = new LinkedList<>();
    }

    // Метод добавления человека в очередь
    @Override
    public void addToQueue(String person) {
        queue.add(person);
        System.out.println((person.equals("Мария") ? person + " добавлена в очередь." : person + " добавлен в очередь."));
    }

    // Метод удаления человека из очереди
    @Override
    public String removeFromQueue() {
        if (!queue.isEmpty()) {
            String person = queue.poll();
            System.out.println(person + " удален из очереди.");
            return person;
        } else {
            System.out.println("Очередь пуста.");
            return null;
        }
    }

    // Метод для входа человека в магазин
    @Override
    public void enterMarket(String person) {
        System.out.println((person.equals("Мария") ? person + " вошла в магазин." : person + " вошел в магазин."));
    }

    // Метод для выхода человека из магазина
    @Override
    public void exitMarket(String person) {
        System.out.println((person.equals("Мария") ? person + " вышла из магазина." : person + " вышел из магазина."));
    }

    // Метод для обновления состояния магазина
    public void update() {
        // Реализация обновления состояния магазина
        System.out.println("Обновление состояния магазина...");
    }

    // Тестирование класса Market
    public static void main(String[] args) {
        Market market = new Market();

        market.addToQueue("Иван");
        market.addToQueue("Мария");
        market.removeFromQueue();

        market.enterMarket("Петр");
        market.exitMarket("Мария");

        market.update();
    }
}