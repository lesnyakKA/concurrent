package forkjoinpool;

import java.util.concurrent.ForkJoinPool;

public class ForkJoinExample {

    /**
     * ForkJoinPool — это мощный инструмент для параллельной обработки задач, особенно в случаях, когда задачи можно разделить на более мелкие подзадачи. Он идеально подходит для рекурсивных алгоритмов и задач с высокой степенью параллелизма.<br>
     * <br>
     * Как это работает:<br>
     * Создание задачи: Мы создаем задачу SumTask, которая вычисляет сумму элементов массива.<br>
     * Разделение задачи: Если задача слишком большая (больше THRESHOLD), она делится на две подзадачи.<br>
     * Рекурсивное выполнение: Подзадачи выполняются параллельно в пуле потоков.<br>
     * Объединение результатов: Результаты подзадач объединяются для получения конечного результата. <br>
     * <br>
     * Преимущества ForkJoinPool<br>
     * Эффективность: Оптимально использует ресурсы процессора благодаря work-stealing алгоритму.<br>
     * Удобство для рекурсивных задач: Упрощает написание параллельных рекурсивных алгоритмов.<br>
     * Автоматическое управление потоками: Не нужно вручную создавать и управлять потоками.<br>
     * <br>
     * Когда использовать ForkJoinPool?<br>
     * Рекурсивные задачи: Например, параллельная сортировка, поиск, обход деревьев.<br>
     * Параллельная обработка данных: Например, обработка больших массивов или коллекций.<br>
     * Задачи с высокой степенью параллелизма: Когда задача может быть легко разделена на независимые части.<br>
     * <br>
     * Ограничения<br>
     * Накладные расходы. Для маленьких задач накладные расходы на создание и управление подзадачами могут превысить выгоду от параллельного выполнения.<br>
     * Не подходит для I/O-задач. ForkJoinPool предназначен для CPU-интенсивных задач, а не для задач, связанных с вводом-выводом.<br>
     * @param args
     */
    public static void main(String[] args) {
        int[] array = new int[1000];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }

        ForkJoinPool pool = new ForkJoinPool();
        SumTask task = new SumTask(array, 0, array.length);
        long result = pool.invoke(task);

        System.out.println("Сумма элементов массива: " + result);
    }
}
