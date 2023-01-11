package resolve_deadlock;

import resolve_deadlock.join.MyOtherThreadUsingJoin;
import resolve_deadlock.join.MyThreadUsingJoin;
import resolve_deadlock.synchro.MyOtherThreadUsingSynchro;
import resolve_deadlock.synchro.MyThreadUsingSynchro;

/**
 * Створити 2 класи. Реалізувати взаємне блокування цих класів.
 * Використати усі можливі способи (які Ви знаєте), щоб вирішити проблему взаємного блокування.
 */

public class Main {
    public static void main(String[] args) {
        System.out.println("\nDeadlock with join(). Problem solving - using Java Lock API\n");
        MyThreadUsingJoin myThreadOne = new MyThreadUsingJoin();
        MyOtherThreadUsingJoin myThreadTwo = new MyOtherThreadUsingJoin();

        myThreadOne.setMyThreadOne(myThreadTwo);
        myThreadTwo.setMyThreadTwo(myThreadOne);

        myThreadOne.start();
        myThreadTwo.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("\nDeadlock with synchronized classes. Problem solving - using other order of synchronized blocks\n");
        MyThreadUsingSynchro myThreadThree = new MyThreadUsingSynchro();
        MyOtherThreadUsingSynchro myThreadFour = new MyOtherThreadUsingSynchro();

        myThreadThree.start();
        myThreadFour.start();

    }
}
