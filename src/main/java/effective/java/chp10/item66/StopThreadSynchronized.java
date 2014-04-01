package effective.java.chp10.item66;

import java.util.concurrent.TimeUnit;

/**
 *     Effective Java, page 261
 *
 *     The following program fixes the 'liveness' issue in StopThread.java
 */
public class StopThreadSynchronized {

    private static boolean stopRequested;

    private static synchronized void requestStop() {
        stopRequested = true;
    }

    private static synchronized boolean stopRequested(){
        return stopRequested;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread backgroundThread = new Thread(new Runnable() {

            @Override
            public void run() {

                final long start = System.nanoTime();

                int i =0;
                while (!stopRequested())
                        i++;

                final long end = System.nanoTime();

                System.out.println(this.getClass().getName() + "Time taken (Seconds) : " + (end-start)/1.0e9);
            }
        });
        backgroundThread.start();
        TimeUnit.SECONDS.sleep(1);
        requestStop();
    }
}

/**
 *
 * Note both the read and write method (requestStop) and the read method (stopRequested) are synchronized.
 * It is NOT sufficient to synchronize only the write method!
 *
 * ** Synchronization has no effect unless both read and write operations are synchronized
 *
 * The actions of the synchronized methods in stopThread would be atomic even without synchronization.  In other words,
 * the synchronization on these methods is used soley for its communication effects, not for mutual exclusion
 *
 */
