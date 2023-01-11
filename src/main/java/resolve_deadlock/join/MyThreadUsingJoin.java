package resolve_deadlock.join;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyThreadUsingJoin extends Thread {
    private Thread myThreadOne;
    private Lock reentrantLock = new ReentrantLock();

    public void lockThread() {
        reentrantLock.lock();
        try {
            sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            reentrantLock.unlock();
        }
    }
    public MyThreadUsingJoin() {
        System.out.println(Thread.currentThread().getName() + " MyThread create...");
    }
    public void setMyThreadOne(Thread myThreadOne) {
        this.myThreadOne = myThreadOne;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " MyThread start...");
        try {
                myThreadOne.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " MyThread finished...");
    }
}
