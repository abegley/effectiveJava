package effective.java.chp10.item67;


import java.util.HashSet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ObservableSetExecutorService {

    public static void main(String [] args){
        ObservableSet<Integer> set = new ObservableSet<Integer>(new HashSet<Integer>());

        set.addObserver(new SetObserver<Integer>() {
            @Override
            public void added(final ObservableSet<Integer> set, Integer element)  {
                System.out.println(element);
                if(element == 23){
                    ExecutorService executor = Executors.newSingleThreadExecutor();
                    final SetObserver<Integer> observer = this;
                    try
                    {
                        try {
                            executor.submit(new Runnable() {
                                @Override
                                public void run() {
                                    set.removeObserver(observer);
                                }
                            }).get();
                        } catch (InterruptedException e) {
                            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                        } catch (ExecutionException e) {
                            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                        }
                    } finally {
                        executor.shutdown();
                    }

                }


            }
        });

        for(int i = 0 ; i < 100 ; i++)
            set.add(i);
    }
}
