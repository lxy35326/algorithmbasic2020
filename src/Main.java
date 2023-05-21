public class Main {
    public static void main(String[] args) {
        Printer printer = new Printer();

        Thread thread1 = new Thread(new HelloRunnable(printer));
        Thread thread2 = new Thread(new WorldRunnable(printer));

        thread1.start();
        thread2.start();
    }

    static class Printer {
        private boolean isHelloPrinted = false;

        public synchronized void printHello() {
            while (isHelloPrinted) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("hello");
            isHelloPrinted = true;
            notify();
        }

        public synchronized void printWorld() {
            while (!isHelloPrinted) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("world");
            isHelloPrinted = false;
            notify();
        }
    }

    static class HelloRunnable implements Runnable {
        private final Printer printer;

        public HelloRunnable(Printer printer) {
            this.printer = printer;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                printer.printHello();
            }
        }
    }

    static class WorldRunnable implements Runnable {
        private final Printer printer;

        public WorldRunnable(Printer printer) {
            this.printer = printer;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                printer.printWorld();
            }
        }
    }
}
