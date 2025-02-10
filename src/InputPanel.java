import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Point;

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

        addButton.addActionListener(new ActionListener( ){
            public void actionPerformed(ActionEvent e) {
                
            }
        });

        deleteButton.addActionListener(new ActionListener( ){
            public void actionPerformed(ActionEvent e) {
                
            }
        });
    }

    public void initActionListeners() {

    }
}