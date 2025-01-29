package completable_future;

import java.util.concurrent.CompletableFuture;

public class SequentialTasksExample {

    /**
     * Если задачи должны выполняться последовательно, можно использовать метод thenRun для создания цепочки задач.
     */
    public static void main(String[] args) {
        CompletableFuture<Void> taskChain = CompletableFuture.runAsync(
            () -> System.out.println("Задача 1 выполняется в потоке " + Thread.currentThread().getName()))
            .thenRun(() -> System.out.println("Задача 2 выполняется в потоке " + Thread.currentThread().getName()))
            .thenRun(() -> System.out.println("Задача 3 выполняется в потоке " + Thread.currentThread().getName()));

        taskChain.join(); // Ожидаем завершения цепочки задач
        System.out.println("Все задачи завершены.");
    }
}