import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class TreeFrame extends JFrame {

    public TreeFrame() {
        setTitle("Graphic Binary Tree");
        setSize(1600, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                revalidate(); 
                repaint(); 
            }
        });
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        add(new MainPanel());
        
    }

    public static void main(String[] args) {
        TreeFrame frame = new TreeFrame();
        frame.setVisible(true);
    }
}

