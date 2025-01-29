package completable_future;

import java.util.concurrent.CompletableFuture;

public class ExceptionHandlingExample {

    /**
     * Если задачи могут выбрасывать исключения, используйте метод exceptionally для обработки ошибок.
     */
    public static void main(String[] args) {
        CompletableFuture<Void> task = CompletableFuture.runAsync(() -> {
            System.out.println("Задача выполняется в потоке " + Thread.currentThread().getName());
            throw new RuntimeException("Ошибка в задаче!");
        }).exceptionally(ex -> {
            System.err.println("Произошла ошибка: " + ex.getMessage());
            return null; // Возвращаем null, так как тип Void
        });

        task.join(); // Ожидаем завершения задачи
        System.out.println("Задача завершена.");
    }
}
