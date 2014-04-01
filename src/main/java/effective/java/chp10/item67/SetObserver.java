package effective.java.chp10.item67;


import java.util.concurrent.ExecutionException;

public interface SetObserver<E> {
    //Invoked when an element is added to the observable set
    void added(ObservableSet<E> set, E element);
}
