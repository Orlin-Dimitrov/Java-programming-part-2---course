package noticeboard;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;

public class NoticeBoard implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        frame = new JFrame("Frame");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createComponents(frame.getContentPane());
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        container.setLayout(new GridLayout(3, 1));
        JTextField field = new JTextField();
        container.add(field);
        JButton button = new JButton("Copy!");
        container.add(button);
        JLabel label = new JLabel();
        container.add(label);
        ActionEventListener listener = new ActionEventListener(field, label);
        button.addActionListener(listener);
        
    }
}
