package CH03_StacksAndQueues.StackMin;

public interface IStackMin<T> {
    T min();
    T push(T item);
    T peek();
    T pop();
}
