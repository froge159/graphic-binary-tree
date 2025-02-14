import javax.swing.JFrame;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class TreeFrame extends JFrame    {

    public static int WIDTH = 1600;
    public static int HEIGHT = 1000;

    public TreeFrame() {
        setTitle("Graphic Binary Tree");
        setSize(1600, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                WIDTH = getWidth();
                HEIGHT = getHeight();
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

