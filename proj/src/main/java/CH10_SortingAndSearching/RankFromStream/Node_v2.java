package CH10_SortingAndSearching.RankFromStream;

public class Node_v2 {
    int value;
    int numberInLeft;
    Node_v2 left;
    Node_v2 right;

    public Node_v2(int value) {
        this.value = value;
    }

    public void insert(int x) {
        if (x <= this.value) {
            this.numberInLeft++;
            if (this.left != null) {
                this.left.insert(x);
            } else {
                this.left = new Node_v2(x);
            }
        } else {
            if (this.right != null) {
                this.right.insert(x);
            } else {
                this.right = new Node_v2(x);
            }
        }
    }

    public int getRank(int x) {
        if (x == this.value) {
            return this.numberInLeft;
        } else if ( x < this.value) {
            if (null == this.left) {
                return 0;
            }
            return this.left.getRank(x);
        } else {    // x > this.value
            if (null == this.right) {
                return 1 + this.numberInLeft;
            }
            return 1 + this.numberInLeft + this.right.getRank(x);
        }
    }
}
