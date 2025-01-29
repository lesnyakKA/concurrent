package completable_future;

import java.util.concurrent.CompletableFuture;

public class MultipleTasksExample {

    /**
     * Если задачи независимы и могут выполняться параллельно, используйте CompletableFuture.runAsync для каждой задачи, а затем дождитесь завершения всех задач с помощью CompletableFuture.allOf
     */
    public static void main(String[] args) {
        // Создаем несколько асинхронных задач
        CompletableFuture<Void> task1 = CompletableFuture.runAsync(() -> System.out.println("Задача 1 выполняется в потоке " + Thread.currentThread().getName()));

        CompletableFuture<Void> task2 = CompletableFuture.runAsync(() -> System.out.println("Задача 2 выполняется в потоке " + Thread.currentThread().getName()));

        CompletableFuture<Void> task3 = CompletableFuture.runAsync(() -> System.out.println("Задача 3 выполняется в потоке " + Thread.currentThread().getName()));

        // Ожидаем завершения всех задач
        CompletableFuture<Void> allTasks = CompletableFuture.allOf(task1, task2, task3);
        allTasks.join(); // Блокируем основной поток, пока все задачи не завершатся

        System.out.println("Все задачи завершены.");
    }
}
