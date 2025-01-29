package completable_future;

import java.util.concurrent.CompletableFuture;

public class ParallelTasksWithResults {

    /**
     * Если нужно выполнить несколько задач параллельно и обработать их результаты, используйте CompletableFuture.allOf и join.
     */
    public static void main(String[] args) {
        CompletableFuture<String> task1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Задача 1 выполняется в потоке " + Thread.currentThread().getName());
            return "Результат задачи 1";
        });

        CompletableFuture<String> task2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Задача 2 выполняется в потоке " + Thread.currentThread().getName());
            return "Результат задачи 2";
        });

        CompletableFuture<String> task3 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Задача 3 выполняется в потоке " + Thread.currentThread().getName());
            return "Результат задачи 3";
        });

        // Ожидаем завершения всех задач
        CompletableFuture<Void> allTasks = CompletableFuture.allOf(task1, task2, task3);
        allTasks.join(); // Блокируем основной поток, пока все задачи не завершатся

        // Получаем результаты
        System.out.println("Результат задачи 1: " + task1.join());
        System.out.println("Результат задачи 2: " + task2.join());
        System.out.println("Результат задачи 3: " + task3.join());
    }
}
