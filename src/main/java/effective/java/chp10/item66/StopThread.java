package effective.java.chp10.item66;

import java.util.concurrent.TimeUnit;

/**
 * Broken! - How long would you expect the following program to run?
 *
 *   The following program never terminates: the background thread loops forever.  Liveness failure
 */
public class StopThread {
    // Reading and writing a boolean field is atomic, some programmers dispense with synchronization when accessing the field
    private static boolean stopRequested;

    public static void main(String[] args) throws InterruptedException {
        Thread backgroundThread = new Thread(new Runnable(){

            @Override
            public void run() {
                int i = 0;
                while (!stopRequested)
                    i++;
            }
        });

        backgroundThread.start();
        TimeUnit.SECONDS.sleep(1);
        stopRequested = true;
    }
}


/**
 Notes:

 Effective java chapter 10, page 260

    ** Do not use Thread.stop - deprecated lomng ago - usage can result in data corruption
 *
 *

 **/