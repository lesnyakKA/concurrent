package callable_future;

import java.util.concurrent.Callable;

class MyCallable implements Callable<String> {
    @Override
    public String call() {
        return "Результат из потока " + Thread.currentThread().getName();
    }
}
