import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.FlowLayout;

public class TreePanel extends JPanel {

    private BST tree;

    public TreePanel() {
        setPreferredSize(new java.awt.Dimension(800, 600));
        setBackground(Color.WHITE);
        setLayout(new FlowLayout());
        
        tree = new BST();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw the binary tree here
        tree.drawTree(g);
    }

    
}
