package CH04_TreesAndGraphs.CheckSubtree;

import Common.BiTreeNode;

public class CheckSubTree_v2 {
    // Because we need a null placeholder for pre-order traversal (Hint  #18, #31),
    // to simplify the case, we hardcode the element datatype as Integer, and we will use 'n' as the null placeholder.
    private static String nullHolder = "(n)";

    public static boolean isSubTree(BiTreeNode<Integer> tree, BiTreeNode<Integer> sub) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        CheckSubTree_v2.preOrderString(tree, sb1);
        CheckSubTree_v2.preOrderString(sub, sb2);
        // System.out.println(sb1.toString());
        // System.out.println(sb2.toString());
        return sb1.toString().contains(sb2.toString());
    }

    public static void preOrderString(BiTreeNode<Integer> tree, StringBuilder stringBuilder) {
        if (null == tree) {
            stringBuilder.append(nullHolder);
            return;
        }
        stringBuilder.append("(").append(tree.element).append(")");
        preOrderString(tree.left, stringBuilder);
        preOrderString(tree.right, stringBuilder);
    }
}
