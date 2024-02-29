package DZ2;

/*
Реализовать класс Market и все методы, которые он обязан реализовывать.
Методы из интерфейса QueueBehaviour, имитируют работу очереди,
MarketBehaviour – помещает и удаляет человека из очереди, метод update –
обновляет состояние магазина (принимает и отдаёт заказы)
*/
import java.util.LinkedList;
import java.util.Queue;


interface QueueBehaviour {
    void addToQueue(String person);
    String removeFromQueue();
}


interface MarketBehaviour {
    void enterMarket(String person);
    void exitMarket(String person);
}


public class Market implements QueueBehaviour, MarketBehaviour {
    private Queue<String> queue; // Очередь людей в магазине


    public Market() {
        queue = new LinkedList<>();
    }


    @Override
    public void addToQueue(String person) {
        queue.add(person);
        System.out.println((person.equals("Мария") ? person + " добавлена в очередь." : person + " добавлен в очередь."));
    }


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


    @Override
    public void enterMarket(String person) {
        System.out.println((person.equals("Мария") ? person + " вошла в магазин." : person + " вошел в магазин."));
    }


    @Override
    public void exitMarket(String person) {
        System.out.println((person.equals("Мария") ? person + " вышла из магазина." : person + " вышел из магазина."));
    }


    public void update() {

        System.out.println("Обновление состояния магазина...");
    }


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