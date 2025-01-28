package forkjoinpool;

import java.util.concurrent.RecursiveTask;

class SumTask extends RecursiveTask<Long> {
    private final int[] array;
    private final int start;
    private final int end;
    private static final int THRESHOLD = 100; // Порог для разделения задачи

    SumTask(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        if (end - start <= THRESHOLD) {
            // Если задача достаточно мала, выполняем её напрямую
            long sum = 0;
            for (int i = start; i < end; i++) {
                sum += array[i];
            }
            return sum;
        } else {
            // Разделяем задачу на две подзадачи
            int mid = (start + end) / 2;
            SumTask leftTask = new SumTask(array, start, mid);
            SumTask rightTask = new SumTask(array, mid, end);

            // Асинхронно запускаем подзадачи
            leftTask.fork();
            rightTask.fork();

            // Ожидаем завершения подзадач и объединяем результаты
            return leftTask.join() + rightTask.join();
        }
    }
}