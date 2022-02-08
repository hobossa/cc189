package CH04_TreesAndGraphs.FirstCommonAncestor;

import java.util.Collection;
import java.util.Hashtable;

public class TreeNode<E> {
    private final E element;
    TreeNode<E> parent;
    private final Hashtable<E, TreeNode<E>> children;

    public TreeNode(E element) {
        this.element = element;
        this.parent = null;
        this.children = new Hashtable<>();
    }

    public TreeNode<E> addChild(E element) {
        if (!children.containsKey(element))
            return addChild(new TreeNode<>(element));
        return null;
    }

    public TreeNode<E> addChild(TreeNode<E> node) {
        if (!children.containsKey(node.element)) {
            node.parent = this;
            children.put(element, node);
            return node;
        }
        return null;
    }

    // public Collection<TreeNode<E>> getChildren() {
    //     return children.values();
    // }

    public E getElement() {
        return element;
    }
}
