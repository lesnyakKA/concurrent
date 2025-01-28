package runnable;

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Поток " + Thread.currentThread().getName() + " запущен.");
    }
}
