import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

public class Port {
//    private static int product = 0;
    List <String [] > ships = new ArrayList<>();
    List<String> port = new ArrayList<>();
    String[] product = new String[]{"Фрукты","Кофе","Зерно","Микросхемы","Смартфоны","Ноутбуки","Кроссовки","Чай","Одежда"};


    public synchronized void shipment() {
        while (port.size() < 1) {
            try {
                System.out.println("Все контейнеры отгружены.\n");
                wait();
            } catch (InterruptedException e) {
                System.out.println("В порту авария!!!");
            }
        }
        if (ships.size() > 0) {
            String[] ship =ships.get(0);
            int place = ship.length;
            System.out.println("Кран приступил к загрузке корабля объемом " + place);
            System.out.println("Контейнеров в порту " + port.size());
            while (place != 0 && port.size() != 0) {
                place--;
                System.out.println("1 контейнер с товаром " + port.get(0)+ " был отгружен");
                port.remove(0);
                System.out.println("Место в корабле " + place);

                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
                System.out.println("Корабль загружен и покидает гавань.\n");
                ships.remove(0);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
                System.out.println("Кораблей в гавани " + ships.size());
                System.out.println("Контейнеров в порту " + port.size() + "\n");
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } else {
            try {
                System.out.println("Ждем прибытия корабля.");
                wait();
            } catch (InterruptedException e) {
                System.out.println("В порту авария!!!");
            }

        }
        notify();
    }

    public synchronized void accept() {
        while (port.size() >= 20) {
            try {
                System.out.println("Порт заполнен.\n");
                wait();
            } catch (InterruptedException e) {
                System.out.println("В порту авария!!!");
            }
        }
        String prod = product[0 + (int) (Math.random() * 8)];
        port.add(prod);
        System.out.println("1 контейнер c товаром " + prod + " был принят в порт");
        System.out.println("Контейнеров в порту " + port.size());
        try {
            sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        notify();
    }

    public synchronized void newShip() {
        while (ships.size() == 3) {
            try {
                System.out.println("Гавань порта заполнена.\n");
                wait();
            } catch (InterruptedException e) {
                System.out.println("В гавани авария!!!");
            }
        }
        String[] ship = new String[2 + (int) (Math.random() * 8)];
        ships.add(ship);
        System.out.println("В гавань порта прибыл корабль, объемом " + ship.length );
        System.out.println("В гавани " + ships.size() + " корабля.");
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        notify();
    }
}
