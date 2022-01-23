package CH03_StacksAndQueues.ThreeInOneStack;

public class FullStackException extends RuntimeException{
    public FullStackException() {
        super();
    }

    public FullStackException(String message) {
        super(message);
    }
}
