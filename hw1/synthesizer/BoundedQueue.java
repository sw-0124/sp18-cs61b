package synthesizer;

public interface BoundedQueue <T>{
    public abstract int capacity();

    public abstract int fillCount();

    public abstract void enqueue(T x);

    public abstract T dequeue();

    public abstract T peek();

    public default boolean isEmpty(){
        return fillCount() == 0;
    }

    public default boolean isFull(){
        return fillCount() == capacity();
    }
}
