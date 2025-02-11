import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends JPanel implements ActionListener {

    private TreePanel treePanel;
    private InputPanel inputPanel;

    public MainPanel() {
        setLayout(new BorderLayout());

        treePanel = new TreePanel();
        inputPanel = new InputPanel();

        //inputPanel.getAddButton().addActionListener(this);
        //inputPanel.getDeleteButton().addActionListener(this);
        
        add(treePanel, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.PAGE_END);
    }
    /* 
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == treePanel) {
            treePanel.add(new BinaryNode(inputPanel.getInput().getText()));
            inputPanel.getInput().setText("");
        }
        else if (e.getSource() == inputPanel) {
            treePanel.remove(inputPanel.getInput().getText());
            inputPanel.getInput().setText("");
        }
    }*/
}
