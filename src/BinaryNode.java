
public class BinaryNode {
    private BinaryNode left, right;
    private int level, xValue, yValue;
    private Comparable myValue;

    public BinaryNode(Comparable x) {
        myValue = x;
    }

    public void setX(int x) { xValue = x; }

    

    public void setY(int y) { yValue = y; }

    public int getX() { return xValue; }

    public int getY() { return yValue; }

    public void setLevel(int x) { level = x; }

    public int getLevel() { return level; }

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
