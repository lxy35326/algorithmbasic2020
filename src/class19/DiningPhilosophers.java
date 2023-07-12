package class19;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Philosopher implements Runnable {
    private int id;
    private Lock leftFork;
    private Lock rightFork;

    public Philosopher(int id, Lock leftFork, Lock rightFork) {
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    private void think() throws InterruptedException {
        System.out.println("Philosopher " + id + " 在思考...");
        Thread.sleep((long) (Math.random() * 1000));
    }

    private void eat() throws InterruptedException {
        System.out.println("Philosopher " + id + " 在吃东西...");
        Thread.sleep((long) (Math.random() * 1000));
    }

    @Override
    public void run() {
        try {
            while (true) {
                think();
                // 获取左面的叉子，尝试获取锁
                leftFork.lock();
                System.out.println("Philosopher " + id + " 拿起左面的叉子.");
                // T尝试获取右面的叉子，锁
                if (rightFork.tryLock()) {
                    System.out.println("Philosopher " + id + " 拿起右面的叉子.");
                    eat();
                    rightFork.unlock();
                } else {
                    System.out.println("Philosopher " + id + " 不能获取右面的叉子，放下左边的叉子.");
                }
                leftFork.unlock();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
    }
}

public class DiningPhilosophers {
    public static void main(String[] args) {
        final int numPhilosophers = 5;
        Philosopher[] philosophers = new Philosopher[numPhilosophers];
        Lock[] forks = new ReentrantLock[numPhilosophers];

        for (int i = 0; i < numPhilosophers; i++) {
            forks[i] = new ReentrantLock();
        }

        for (int i = 0; i < numPhilosophers; i++) {
            Lock leftFork = forks[i];
            Lock rightFork = forks[(i + 1) % numPhilosophers];
            philosophers[i] = new Philosopher(i, leftFork, rightFork);
            Thread t = new Thread(philosophers[i]);
            t.start();
        }
    }
}

