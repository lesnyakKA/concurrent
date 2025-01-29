package thread_local;

class ThreadLocalExample {

    /**
     * ThreadLocal позволяет создавать переменные, уникальные для каждого потока
     */

    private static final ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            threadLocal.set("Значение для потока 1");
            System.out.println(threadLocal.get());
        });

        Thread thread2 = new Thread(() -> {
            threadLocal.set("Значение для потока 2");
            System.out.println(threadLocal.get());
        });

        thread1.start();
        thread2.start();
    }
}