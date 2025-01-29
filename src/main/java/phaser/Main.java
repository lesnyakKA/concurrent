package phaser;

import java.util.concurrent.Phaser;

public class Main {

    /**
     * Phaser позволяет синхронизировать потоки, которые выполняются в несколько фаз.
     */

    public static void main(String[] args) {
        Phaser phaser = new Phaser(3); // 3 потока

        new Thread(new Task(phaser, "Поток 1")).start();
        new Thread(new Task(phaser, "Поток 2")).start();
        new Thread(new Task(phaser, "Поток 3")).start();
    }

    static class Task implements Runnable {
        private final Phaser phaser;
        private final String name;

        Task(Phaser phaser, String name) {
            this.phaser = phaser;
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println(name + " выполняет фазу 1");
            phaser.arriveAndAwaitAdvance(); // Ожидание других потоков

            System.out.println(name + " выполняет фазу 2");
            phaser.arriveAndAwaitAdvance();

            System.out.println(name + " завершил работу");
            phaser.arriveAndDeregister();
        }
    }
}