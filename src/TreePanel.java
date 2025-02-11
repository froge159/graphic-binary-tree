import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.FlowLayout;

public class TreePanel extends JPanel {

    private BST tree;

    public TreePanel() {
        setPreferredSize(new java.awt.Dimension(1600, 900));
        setBackground(Color.WHITE);
        tree = new BST();
    }

    public BST tree() {
        return tree;
    }

    public void add(BinaryNode x) {
        tree.add(x);
        revalidate();
        repaint();
    }

    public void remove(Comparable c) {
        tree.remove(c);
        revalidate();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        tree.drawTree(g);
    }

    
}
