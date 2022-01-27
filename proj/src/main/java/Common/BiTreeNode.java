package Common;

public class BiTreeNode<E> {
    E element;
    BiTreeNode<E> left;
    BiTreeNode<E> right;

    public BiTreeNode(E element) {
        this.element = element;
    }
}