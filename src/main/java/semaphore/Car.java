package semaphore;

import java.util.concurrent.Semaphore;

class Car implements Runnable {
    private final int carNumber;
    private final Semaphore parking;

    Car(int carNumber, Semaphore parking) {
        this.carNumber = carNumber;
        this.parking = parking;
    }

    @Override
    public void run() {
        try {
            System.out.println("Машина " + carNumber + " подъехала к парковке.");

            // Захватываем разрешение (место на парковке)
            parking.acquire();

            System.out.println("Машина " + carNumber + " припарковалась.");

            // Имитируем время стоянки
            Thread.sleep(2000);

            System.out.println("Машина " + carNumber + " уехала с парковки.");

            // Освобождаем разрешение (место на парковке)
            parking.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getCarNumber() {
        return carNumber;
    }
}
