import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.FlowLayout;

public class InputPanel extends JPanel {

    private JButton addButton, deleteButton;
    private JTextField input;
    
    public InputPanel() {
        setPreferredSize(new java.awt.Dimension(800, 600));
        setBackground(Color.WHITE);
        setLayout(new FlowLayout());

        input = new JTextField();
        input.setPreferredSize(new java.awt.Dimension(200, 25));
        add(input);

        addButton = new JButton("Add");
        addButton.setPreferredSize(new java.awt.Dimension(100, 25));
        add(addButton);
        
        deleteButton = new JButton("Delete"); 
        deleteButton.setPreferredSize(new java.awt.Dimension(100, 25));
        add(deleteButton);

        
    }
}