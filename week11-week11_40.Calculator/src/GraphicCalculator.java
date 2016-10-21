
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GraphicCalculator implements Runnable {
    private JFrame frame;
    private Logic logic;

    public GraphicCalculator(Logic logic) {
        this.logic = logic;
    }
    
    @Override
    public void run() {
        frame = new JFrame("Calculator");
        frame.setPreferredSize(new Dimension(300, 150));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createComponents(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        GridLayout layout = new GridLayout(3, 1);
        container.setLayout(layout);
        JPanel panel = new JPanel(new GridLayout(1, 3));
        JButton plus = new JButton("+");
        JButton minus = new JButton("-");
        final JButton zed = new JButton("Z");
        final JTextField out = new JTextField("0");
        final JTextField in = new JTextField();
        out.setEnabled(false);
        zed.setEnabled(false);
        
        
        plus.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int numberOut = Integer.parseInt(out.getText());
                    int numberIn = Integer.parseInt(in.getText());
                    out.setText(Integer.toString(logic.plus(numberOut, numberIn)));
                    
                    if(out.getText().equals("0")) {
                        zed.setEnabled(false);
                    }
                    else
                        zed.setEnabled(true);
                } catch(NumberFormatException ex2) {}
                in.setText("");
            }
        });
        
        minus.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int numberOut = Integer.parseInt(out.getText());
                    int numberIn = Integer.parseInt(in.getText());
                    out.setText(Integer.toString(logic.minus(numberOut, numberIn)));
                    
                    if(out.getText().equals("0")) {
                        zed.setEnabled(false);
                    }
                    else
                        zed.setEnabled(true);
                } catch(NumberFormatException ex) {}
                in.setText("");
            } 
        });
        
        zed.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                out.setText("0");
                in.setText("");
                zed.setEnabled(false);
            }
        });
        
        panel.add(plus);
        panel.add(minus);
        panel.add(zed);
        container.add(out);
        container.add(in);
        container.add(panel);
    }

    public JFrame getFrame() {
        return frame;
    }
}