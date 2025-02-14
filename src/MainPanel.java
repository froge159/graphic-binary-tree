import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends JPanel  {

    private TreePanel treePanel;
    private InputPanel inputPanel;

    public MainPanel() {
        setLayout(new BorderLayout());

        treePanel = new TreePanel();
        inputPanel = new InputPanel();

        inputPanel.getAddButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                treePanel.add(new BinaryNode(Integer.parseInt(inputPanel.getInput().getText())));
                inputPanel.getInput().setText("");
            }
        });
        inputPanel.getDeleteButton().addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                treePanel.remove(Integer.parseInt(inputPanel.getInput().getText()));
                inputPanel.getInput().setText("");
            }
        });
        
        add(treePanel, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.PAGE_END);
    }
    
}
