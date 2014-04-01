Item 68: Prefer executors and tasks to threads

In release 1.5, java.util.concurrent was added to the Java platform.  The aforementioned
package contains an Executor Framework, which is a a flexible interface-based task execution
facility.

How to submit a runnable for execution
    executor.execute(runnable)
How to tell the executor ro terminate gracefully
    executor.shutdown();

##other things you can do with an Executor Service
- Wait for a particular task to complete, background thread "SetObserver", see items 67, page 267
- Wait for any or all of a collection of tasks to complete (using the invokeAny or invokeAll methods)
- awaitTerminaion method, wait for the executor service's graceful termination to complete
- retrieve results of tasks one by one as they complete (using an ExcutoerCompletionService), and so on.

If you want more than one thread to process requests from the queue, simply call a different static factory
that creates a different kind of executoer service called a thread pool.

- java.util.concurrent.Executors class contains static factories
- Need to create a funky thread pool ThreadPoolExecutor