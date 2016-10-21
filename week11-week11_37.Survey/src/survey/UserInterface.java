package survey;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.*;

public class UserInterface implements Runnable {

    private JFrame frame;
    private JPanel panel;

    @Override
    public void run() {
        // Create your app here
        frame = new JFrame("Survey");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 300);
        
        panel = new JPanel();
        BoxLayout layout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(layout);
        panel.add(new JLabel("Are you?"));
        panel.add(new JCheckBox("Yes!"));
        panel.add(new JCheckBox("No!"));
        panel.add(new JLabel("Why?"));
        JRadioButton one = new JRadioButton("No reason.");
        JRadioButton two = new JRadioButton("Because it is fun!");
        ButtonGroup group = new ButtonGroup();
        group.add(one);
        group.add(two);
        panel.add(one);
        panel.add(two);
        panel.add(new JButton("Done!"));
        
        frame.setContentPane(panel);
        frame.setVisible(true);
        
    }


    public JFrame getFrame() {
        return frame;
    }
}
