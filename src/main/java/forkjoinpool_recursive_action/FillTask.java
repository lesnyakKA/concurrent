package forkjoinpool_recursive_action;

import java.util.concurrent.RecursiveAction;

class FillTask extends RecursiveAction {
    private final int[] array;
    private final int start;
    private final int end;
    private static final int THRESHOLD = 100;

    FillTask(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {
        if (end - start <= THRESHOLD) {
            for (int i = start; i < end; i++) {
                array[i] = i + 1;
            }
        } else {
            int mid = (start + end) / 2;
            FillTask leftTask = new FillTask(array, start, mid);
            FillTask rightTask = new FillTask(array, mid, end);
            invokeAll(leftTask, rightTask);
        }
    }
}
