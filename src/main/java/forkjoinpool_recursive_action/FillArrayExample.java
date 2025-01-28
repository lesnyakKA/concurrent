package forkjoinpool_recursive_action;

import java.util.concurrent.ForkJoinPool;

public class FillArrayExample {
    public static void main(String[] args) {
        int[] array = new int[1000];
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(new FillTask(array, 0, array.length));

        // Проверяем результат
        for (int i = 0; i < 10; i++) {
            System.out.print(array[i] + " ");
        }
    }
}