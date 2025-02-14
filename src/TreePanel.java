import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

public class TreePanel extends JPanel {

    private BST tree;

    public TreePanel() {
        setPreferredSize(new java.awt.Dimension(1600, 900));
        setBackground(Color.WHITE);
        setLayout(null);
        tree = new BST();
    }

    public BST tree() {
        return tree;
    }

    public void add(BinaryNode x) {
        tree.add(x);
        tree.updateNodeInfo(tree.getRoot(), null);
        revalidate();
        repaint();
        tree.drawText(tree.getRoot(), this);
    }

    public void remove(int c) {
        tree.remove(c);
        tree.updateNodeInfo(tree.getRoot(), null); // update nodes
        revalidate();
        repaint(); // draw line, circle
        removeAll(); // clear panel
        tree.drawText(tree.getRoot(), this);  // draw text
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        tree.drawLines(tree.getRoot(), null, g);
        tree.drawNodes(tree.getRoot(), null, g);
    }

    
}
