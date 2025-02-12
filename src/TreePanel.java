import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

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
        tree.drawText(this);
        repaint();
    }

    public void remove(Comparable c) {
        tree.remove(c);
        revalidate();
        tree.drawText(this);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        tree.drawNodes(tree.getRoot(), 0, 69420, g);
    }

    
}
