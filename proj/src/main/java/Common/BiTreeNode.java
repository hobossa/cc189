package Common;

public class BiTreeNode<E> {
    E element;
    public BiTreeNode<E> left;
    public BiTreeNode<E> right;

    public BiTreeNode(E element) {
        this.element = element;
    }

    @Override
    public String toString() {
        return " " + element.toString();
    }
}
