package Java_OOP.DZ1;

class HotBeverage {
    private int temperature;

    public HotBeverage(int temperature) {
        this.temperature = temperature;
    }

    public int getTemperature() {
        return temperature;
    }
}

interface VendingMachine {
    Product getProduct(int name, int volume, int temperature);
}

class HotBeverageMachine implements VendingMachine {
    @Override
    public Product getProduct(int name, int volume, int temperature) {
        return new HotBeverageProduct(name, volume, temperature);
    }
}

class HotBeverageProduct extends Product {
    private int temperature;

    public HotBeverageProduct(int name, int volume, int temperature) {
        super(name, volume);
        this.temperature = temperature;
    }

    public int getTemperature() {
        return temperature;
    }
}

class Product {
    private int name;
    private int volume;

    public Product(int name, int volume) {
        this.name = name;
        this.volume = volume;
    }

    public int getName() {
        return name;
    }

    public int getVolume() {
        return volume;
    }
}

public class Main {
    public static void main(String[] args) {
        HotBeverageMachine machine = new HotBeverageMachine();

        Product product1 = machine.getProduct(1, 200, 80);
        Product product2 = machine.getProduct(2, 300, 85);

        if (product1 instanceof HotBeverageProduct) {
            HotBeverageProduct hotProduct1 = (HotBeverageProduct) product1;
            System.out.println("Продукт 1: Название=" + hotProduct1.getName() + ", Объем=" + hotProduct1.getVolume() + ", Температура=" + hotProduct1.getTemperature());
        }

        // Проверка, является ли продукт экземпляром класса горячего напитка
        if (product2 instanceof HotBeverageProduct) {
            HotBeverageProduct hotProduct2 = (HotBeverageProduct) product2;
            System.out.println("Продукт 2: Название=" + hotProduct2.getName() + ", Объем=" + hotProduct2.getVolume() + ", Температура=" + hotProduct2.getTemperature());
        }
    }
}