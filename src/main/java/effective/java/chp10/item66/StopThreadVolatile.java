package effective.java.chp10.item66;

import java.util.concurrent.TimeUnit;

/**
 *  Effective Java,
 *
 *  Cooperative thread termination with a volatile field
 *
 *  While the cost of synchronizing on each iteration of the loop is small, there is a correct alternative that is less
 *  verbose and whose performance is likely to be better.
 *
 */
public class StopThreadVolatile {

    private static volatile boolean stopRequested;

    public static void main (String[] args) throws InterruptedException {
        Thread backgroundThread = new Thread(new Runnable(){

            @Override
            public void run() {
                final long start = System.nanoTime();

                int i=0;
                while(!stopRequested)
                        i++;

                final long end = System.nanoTime();
                System.out.println(this.getClass().getName() + "Time taken (seconds) : " + (end -start)/1.0e9);
            }
        });

        backgroundThread.start();
        TimeUnit.SECONDS.sleep(1);
        stopRequested = true;
    }
}

/**
 *
 * Notes:  While the volatile modifier performs no mutual exclusion, it guarantees that any thread that reads the field
 * will see the most recently written value.
 *
 * You do have to be careful when using volatile. Consider the following method, which is supposed to generate serial numbers:
 *
 *      //Broken - requires synchronization!
 *      private static volatile int nextSerialNumber = 0;
 *
 *      public static int generateSerialNumber(){
 *            return nextSerialNumber++;
 *      }
 *
 * The problem is that the increment operator (++) is not atomic.  It performs two operations on the nextSerialNumber field:
 *      - first it reads the value
 *      - then it writes back a new value, equal to the old value plus one
 *
 * If a a second thread reads the field between the time a thread reads the old value and writes back a new one, the second
 * thread will see the same value as the first and return the same serial number.
 *
 * This is a safety failure: the program computes the wrong results
 *
 * One way to fix the generateSerialNumber method is to add the synchronized modifier to its declaration.  This ensures
 * that multiple invocations won't be interleaved, and that each invocation will see the effect of all previous invocations.
 * The volatile modifier should be removed from nextSerialNumber
 *
 */
