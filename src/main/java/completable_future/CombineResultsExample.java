package completable_future;

import java.util.concurrent.CompletableFuture;

public class CombineResultsExample {
    public static void main(String[] args) {
        CompletableFuture<Integer> task1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Задача 1 выполняется в потоке " + Thread.currentThread().getName());
            return 10;
        });

        CompletableFuture<Integer> task2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Задача 2 выполняется в потоке " + Thread.currentThread().getName());
            return 20;
        });

        // Комбинируем результаты двух задач
        CompletableFuture<Integer> combinedTask = task1.thenCombine(task2, (result1, result2) -> {
            System.out.println("Комбинирование результатов: " + result1 + " + " + result2);
            return result1 + result2;
        });

        // Ожидаем завершения и выводим результат
        System.out.println("Результат комбинирования: " + combinedTask.join());
    }
}