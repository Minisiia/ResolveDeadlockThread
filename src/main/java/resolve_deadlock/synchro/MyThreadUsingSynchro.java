package resolve_deadlock.synchro;

public class MyThreadUsingSynchro extends Thread {

    public MyThreadUsingSynchro() {
        System.out.println(Thread.currentThread().getName() + " MyThreadUsingSynchro create...");
    }

    @Override
    public void run() {
        synchronized (MyThreadUsingSynchro.class) {
            System.out.println(Thread.currentThread().getName() + " Hold MyThreadUsingSynchro");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " Waiting MyOtherThreadUsingSynchro");
            synchronized (MyOtherThreadUsingSynchro.class) {
                System.out.println(Thread.currentThread().getName() + " Hold MyThreadUsingSynchro and MyOtherThreadUsingSynchro");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(Thread.currentThread().getName() + " MyThreadUsingSynchro finished...");
    }
}
