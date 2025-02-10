import java.awt.Color;
import java.awt.Graphics;

public class BST {

    private BinaryNode root;

    public BST() {
        root = null;
    }

    public void add(BinaryNode x) {
        if (root == null) {
            root = x;
            return;
        }
        add(root, x);
    }

    private void add(BinaryNode parent, BinaryNode x) {
        if (parent == null)
            return;
        if (x.getValue().compareTo(parent.getValue()) < 0)
            if (parent.left() == null)
                parent.setLeft(x);
            else
                add(parent.left(), x);
        else if (parent.right() == null)
            parent.setRight(x);
        else
            add(parent.right(), x);
    }

    public BinaryNode search(BinaryNode parent, Comparable target) {
        if (parent == null)
            return null;
        if (parent.left() != null && parent.left().getValue().equals(target) ||
                parent.right() != null && parent.right().getValue().equals(target))
            return parent;
        else if (target.compareTo(parent.getValue()) < 0)
            return search(parent.left(), target);
        else
            return search(parent.right(), target);
    }

    private BinaryNode successor(BinaryNode k) {
        BinaryNode temp = k;
        temp = temp.right();
        while (temp.left() != null)
            temp = temp.left();
        return temp;
    }

    private void swap(BinaryNode x, BinaryNode y) {
        Comparable k = x.getValue();
        x.setValue(y.getValue());
        y.setValue(k);
    }

    public BinaryNode remove(Comparable target) {
        if (root == null)
            return null;
        BinaryNode temp = root;
        BinaryNode inorderSuccessor;
        // check to see if root is to be removed
        if (root.getValue().equals(target)) {
            // remove root degree 0
            if (root.left() == null && root.right() == null) {
                root = null;
                return temp;
            }
            // remove root degree 1 – right child
            else if (root.left() == null) {
                root = root.right();
                temp.setRight(null);
                ;
                return temp;
            }
            // remove root degree 1 – left child
            else if (root.right() == null) {
                root = root.left();
                temp.setLeft(null);
                return temp;
            }
            // remove root degree 2
            {
                inorderSuccessor = successor(root);
                swap(root, inorderSuccessor);
                if (root.right() == inorderSuccessor) {
                    root.setRight(inorderSuccessor.right());
                    inorderSuccessor.setRight(null);
                    return inorderSuccessor;
                }
                return remove(root.right(), target);
            }
        }
        // if root is not removed call remove helper method
        return remove(root, target);
    }

    private BinaryNode remove(BinaryNode startNode, Comparable target) {
        BinaryNode nodeToRemove, inorderSuccessor;
        BinaryNode parent = search(startNode, target);
        if (parent == null)
            return null;
        // decide if it is a left or right child
        boolean isLeft = parent.left() != null &&
                parent.left().getValue().equals(target);
        nodeToRemove = isLeft ? parent.left() : parent.right();

        // degree 0
        if (nodeToRemove.left() == null && nodeToRemove.right() == null) {
            if (isLeft)
                parent.setLeft(null);
            else
                parent.setRight(null);
            return nodeToRemove;
        }
        // degree 1
        else if (nodeToRemove.left() == null) {
            if (isLeft)
                parent.setLeft(nodeToRemove.right());
            else
                parent.setRight(nodeToRemove.right());
            nodeToRemove.setRight(null);
            return nodeToRemove;
        } else if (nodeToRemove.right() == null) {
            if (isLeft)
                parent.setLeft(nodeToRemove.left());
            else
                parent.setRight(nodeToRemove.left());
            nodeToRemove.setLeft(null);
            return nodeToRemove;
        }
        // degree 2
        else {
            inorderSuccessor = successor(nodeToRemove);
            swap(inorderSuccessor, nodeToRemove);
            if (nodeToRemove.right() == inorderSuccessor) {
                nodeToRemove.setRight(inorderSuccessor.right());
                inorderSuccessor.setRight(null);
                return inorderSuccessor;
            }
            return remove(nodeToRemove.right(), target);
        }
    }

    public void drawTree(Graphics g) {
        g.setColor(Color.BLACK);
    }
}
