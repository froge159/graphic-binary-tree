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

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw the binary tree here
        tree.drawTree(g);
    }

    
}
