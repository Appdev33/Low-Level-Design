package main;

/*
 * ThreadPoolExecutor is an ExecutorService to execute each submitted task using one of possibly 
several pooled threads,
 *  normally configured using Executors factory methods. It also provides various utility methods to check current 
 *  threads statistics and control them.
 */


import java.util.concurrent.*;

public class CoffeeCustomThreadExecutor {
    private ExecutorService executor;

    public CoffeeCustomThreadExecutor(int noOfSlots) {
        this.executor = Executors.newFixedThreadPool(noOfSlots);
    }

    public boolean submitTask(int requestId, Semaphore semaphore) {
        Future obj = executor.submit(new CoffeeMakerThread(requestId));
        try {
            obj.get();
            System.out.println("\nLock released successfully by thread : "
                    + Thread.currentThread().getName());
            semaphore.release();
            return true;
        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
        return false;
    }
}
