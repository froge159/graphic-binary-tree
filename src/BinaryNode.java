
public class BinaryNode {
    private BinaryNode left, right;
    private Comparable myValue;

    public BinaryNode(Comparable x) {
        myValue = x;
    }

    public void setLeft(BinaryNode l) {
        left = l;
    }

    public void setRight(BinaryNode r) {
        right = r;
    }

    public void setValue(Comparable v) {
        myValue = v;
    }

    public BinaryNode left() { return left; }
    
    public BinaryNode right() { return right; }

    public Comparable getValue() { return myValue; }

    public String toString() {
        String temp = "Value:" + myValue +
                ", Left:" + (left == null ? null : left.myValue) +
                ", Right:" + (right == null ? null : right.myValue);
        return temp;
    }
}
