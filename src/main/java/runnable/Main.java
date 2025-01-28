package runnable;

public class Main {

    // Более предпочтительный способ, так как Java не поддерживает множественное наследование, а реализация интерфейса Runnable позволяет избежать ограничений.
    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyRunnable());
        Thread thread2 = new Thread(()-> System.out.println("Поток " + Thread.currentThread().getName() + " запущен с помощью лямбда выражения."));
        thread1.start();
        thread2.start();
    }
}