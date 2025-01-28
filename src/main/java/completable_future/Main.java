package completable_future;

import java.util.concurrent.CompletableFuture;

public class Main {

    // CompletableFuture позволяет работать с асинхронными задачами и комбинировать их.
    public static void main(String[] args) {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            System.out.println("Асинхронная задача выполняется в потоке " + Thread.currentThread().getName());
        });

        future.join(); // Ожидаем завершения задачи
    }
}