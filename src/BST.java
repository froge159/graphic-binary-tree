import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;



public class BST {

    private BinaryNode root;

    public static final class Dists {
        public static int NODE_SIZE = (int) (0.0258 * TreeFrame.WIDTH);
        public static int ROOT = (int) (0.465 * TreeFrame.WIDTH);
        public static int LEVEL_1 = (int) (0.235 * TreeFrame.WIDTH);
        public static int LEVEL_2 = (int) (0.111 * TreeFrame.WIDTH);
        public static int LEVEL_3 = (int) (0.049 * TreeFrame.WIDTH);
        public static int LEVEL_4 = (int) (0.0243 * TreeFrame.WIDTH);
        public static int LEVEL_5 = (int) (0.013 * TreeFrame.WIDTH);
    }

    public BST() {
        root = null;
    }

    public BinaryNode getRoot() { return root; }

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
        if (Integer.compare(x.getValue(), parent.getValue()) < 0) {
            if (parent.left() == null) { 
                parent.setLeft(x);
            }
            else
                add(parent.left(), x);
        }
        else if (parent.right() == null) { 
            parent.setRight(x);
        }
        else
            add(parent.right(), x);
    }

    public BinaryNode search(BinaryNode parent, int target) {
        if (parent == null)
            return null;
        if (parent.left() != null && parent.left().getValue() == target ||
                parent.right() != null && parent.right().getValue() == target)
            return parent;
        else if (Integer.compare(target, parent.getValue()) < 0)
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
        int k = x.getValue();
        x.setValue(y.getValue());
        y.setValue(k);
    }

    public BinaryNode remove(int target) {
        if (root == null)
            return null;
        BinaryNode temp = root;
        BinaryNode inorderSuccessor;
        // check to see if root is to be removed
        if (root.getValue() == target) {
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

    private BinaryNode remove(BinaryNode startNode, int target) {
        BinaryNode nodeToRemove, inorderSuccessor;
        BinaryNode parent = search(startNode, target);
        if (parent == null)
            return null;
        // decide if it is a left or right child
        boolean isLeft = parent.left() != null &&
                parent.left().getValue() == target;
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

    public String updateNodeInfo(BinaryNode x, BinaryNode parent) {
        String temp = "";
        if (x == root) {
            x.setLevel(0); x.setX(Dists.ROOT); x.setY(20);
        }
        if (x != null) {
            temp += x.getValue() + " ";
            if (parent != null) {
                if (Integer.compare(x.getValue(), parent.getValue()) < 0) {
                    switch(parent.getLevel()) {
                        case 0:
                            x.setX(parent.getX() - Dists.LEVEL_1);
                            break;
                        case 1:
                            x.setX(parent.getX() - Dists.LEVEL_2);
                            break;
                        case 2:
                            x.setX(parent.getX() - Dists.LEVEL_3);
                            break;
                        case 3:
                            x.setX(parent.getX() - Dists.LEVEL_4);
                            break;
                        case 4:
                            x.setX(parent.getX() - Dists.LEVEL_5);
                    }
                    x.setLevel(parent.getLevel() + 1);
                    x.setY(parent.getY() + 100);
                }
                else {
                    switch(parent.getLevel()) {
                        case 0:
                            x.setX(parent.getX() + Dists.LEVEL_1);
                            break;
                        case 1:
                            x.setX(parent.getX() + Dists.LEVEL_2);
                            break;
                        case 2:
                            x.setX(parent.getX() + Dists.LEVEL_3);
                            break;
                        case 3:
                            x.setX(parent.getX() + Dists.LEVEL_4);
                            break;
                        case 4:
                            x.setX(parent.getX() + Dists.LEVEL_5);
                            break;
                    }
                    x.setLevel(parent.getLevel() + 1);
                    x.setY(parent.getY() + 100);
                }
            }
            temp += updateNodeInfo(x.left(), x);
            temp += updateNodeInfo(x.right(), x);
        }
        return temp;
    }

    public void drawCenteredCircle(Graphics g, int x, int y, int r) {
        x = x-(r/2);
        y = y-(r/2);
        g.fillOval(x,y,r,r);
    }

    public String drawNodes(BinaryNode k, BinaryNode parent, Graphics g) {
        if (root == null) return "";

        String temp = "";
        g.setColor(Color.BLACK);

        if (k != null) {
            temp += k.getValue();
            drawCenteredCircle(g, k.getX(), k.getY(), Dists.NODE_SIZE);
            temp += drawNodes(k.left(), k, g);
            temp += drawNodes(k.right(), k, g);
        }
        return temp;
    }

    public String drawLines(BinaryNode k, BinaryNode parent, Graphics g) {
        if (root == null) return "";

        String temp = "";
        g.setColor(Color.BLACK);

        if (k != null) {
            temp += k.getValue();

            if (parent != null) g.drawLine(parent.getX(), parent.getY(), k.getX(), k.getY());

            temp += drawLines(k.left(), k, g);
            temp += drawLines(k.right(), k, g);
        }
        return temp;
    }

    public String drawText(BinaryNode k, JPanel panel) {
        if (root == null) return "";

        String temp = "";

        if (k != null) {
            temp += k.getValue();
            
            JLabel text = new JLabel(Integer.toString(k.getValue()), SwingConstants.CENTER);
            text.setBounds(k.getX() - Dists.NODE_SIZE / 2, k.getY() - Dists.NODE_SIZE / 2, Dists.NODE_SIZE, Dists.NODE_SIZE);
            text.setForeground(Color.WHITE);
            panel.add(text);

            temp += drawText(k.left(), panel);
            temp += drawText(k.right(), panel);
        }
        return temp;
    }

    
}
