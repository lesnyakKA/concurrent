package thread;

public class Main {

    // Самый базовый способ создания потока — наследование от класса Thread.
    public static void main(String[] args) {
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();
        thread1.start(); // Запуск потока
        thread2.start();
    }
}
