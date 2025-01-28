package executor_service;

import java.util.concurrent.*;

public class Main {

    // ExecutorService позволяет управлять пулом потоков, что более эффективно, чем создание потоков вручную.
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 5; i++) {
            executor.submit(() -> {
                System.out.println("Поток " + Thread.currentThread().getName() + " выполняет задачу.");
            });
        }

        executor.shutdown(); // Завершаем работу ExecutorService
    }
}