package resolve_deadlock.join;

public class MyOtherThreadUsingJoin extends Thread {
    private Thread myThreadTwo;
    private MyThreadUsingJoin mtuj;


    public MyOtherThreadUsingJoin() {
        System.out.println(Thread.currentThread().getName() + " MyOtherThread create...");
    }

    public void setMyThreadTwo(Thread myThreadTwo) {
        this.myThreadTwo = myThreadTwo;
        this.mtuj = (MyThreadUsingJoin) myThreadTwo;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " MyOtherThread start...");
        try {
            sleep(10);
        } catch (Exception e) {
            e.printStackTrace();
        }

        mtuj.lockThread();
        System.out.println(Thread.currentThread().getName() + " MyOtherThread finished...");

    }
}
