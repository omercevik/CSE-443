package hw3.part1;

/**
 * CSE 443
 * Object Oriented Analysis and Design
 * Homework 03
 * Part 1
 * 161044004
 * @author Omer CEVIK
 */
public class Main
{
    /**
     * main method to test.
     * @param args No args.
     */
    public static void main(String[] args)
    {
        BestDSEver synchBestDSEver = new SynchProxy();

        Thread t1 = new Thread(() -> synchBestDSEver.insert(1));
        t1.start();
        System.out.println(synchBestDSEver);

        Thread t2 = new Thread(() -> synchBestDSEver.insert(2));
        t2.start();
        System.out.println(synchBestDSEver);

        Thread t3 = new Thread(() -> synchBestDSEver.insert(3));
        t3.start();
        System.out.println(synchBestDSEver);

        Thread t4 = new Thread(() -> synchBestDSEver.insert(4));
        t4.start();
        System.out.println(synchBestDSEver);

        Thread t5 = new Thread(() -> synchBestDSEver.insert(5));
        t5.start();
        System.out.println(synchBestDSEver);

        Thread t6 = new Thread(() -> synchBestDSEver.insert(6));
        t6.start();
        System.out.println(synchBestDSEver);

        Thread t7 = new Thread(() -> { System.out.println("Removed Element at 0 is " + synchBestDSEver.get(0)); synchBestDSEver.remove(0); System.out.println(synchBestDSEver); });
        t7.start();

        Thread t8 = new Thread(() -> { System.out.println("Get Element at 0 is " + synchBestDSEver.get(0)); System.out.println(synchBestDSEver); });
        t8.start();

        try{
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
            t6.join();
            t7.join();
            t8.join();
        }catch (InterruptedException e)
        {
            System.out.println(e.toString());
        }
    }
}
