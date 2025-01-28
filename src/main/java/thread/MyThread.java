package thread;

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Поток " + Thread.currentThread().getName() + " запущен.");
    }
}
