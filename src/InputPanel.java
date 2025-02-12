import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Color;

public class InputPanel extends JPanel {

    private JButton addButton, deleteButton;
    private JTextField input;
    
    public InputPanel() {
        setPreferredSize(new java.awt.Dimension(1600, 100));
        setBackground(Color.WHITE);

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

    public JButton getAddButton() { return addButton; }
    public JButton getDeleteButton() { return deleteButton; }
    public JTextField getInput() { return input; }
}