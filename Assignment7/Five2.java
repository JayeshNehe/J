import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Five extends JFrame implements ActionListener
{
    JComboBox<String> c1;
    JCheckBox cb1, cb2;
    JTextField tf1, tf2;
    JButton b1, b2;

    Five()
    {
        JFrame f = new JFrame();
        JLabel l1 = new JLabel("Font Family: ");
        JLabel l2 = new JLabel("Font Size: ");
        JLabel l3 = new JLabel("Font Style: ");
        JLabel l4 = new JLabel("Bold");
        JLabel l5 = new JLabel("Italic");

        c1 = new JComboBox<>(GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames());
        tf1 = new JTextField();
        tf2 = new JTextField();
        cb1 = new JCheckBox();
        cb2 = new JCheckBox();
        b1 = new JButton("Apply");
        b2 = new JButton("Exit");

        b1.addActionListener(this);
        b2.addActionListener(this);

        l1.setBounds(40, 10, 80, 30);
        l2.setBounds(40, 60, 80, 30);
        l3.setBounds(40, 110, 80, 30);

        c1.setBounds(150, 10, 150, 30);

        tf1.setBounds(150, 60, 50, 30);

        cb1.setBounds(150, 110, 30, 30);
        cb2.setBounds(250, 110, 30, 30);
        l4.setBounds(180, 110, 80, 30);
        l5.setBounds(280, 110, 80, 30);

        tf2.setBounds(120, 160, 400, 100);

        b1.setBounds(80, 310, 80, 30);
        b2.setBounds(180, 310, 80, 30);

        tf2.setText("Hello Everyone");
        tf2.setEditable(false);

        f.add(l1);
        f.add(l2);
        f.add(l3);
        f.add(l4);
        f.add(l5);
        f.add(c1);
        f.add(tf1);
        f.add(tf2);
        f.add(cb1);
        f.add(cb2);
        f.add(b1);
        f.add(b2);

        f.setSize(400, 400);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == b1)
        {
            int size = Integer.parseInt(tf1.getText());
            int style = Font.PLAIN;
            if(cb1.isSelected())
            {
                style += Font.BOLD;
            }
            if(cb2.isSelected())
            {
                style += Font.ITALIC;
            }
            Font font = new Font(c1.getSelectedItem().toString(), style, size);
            tf2.setFont(font);
        }
        else if(e.getSource() == b2)
        {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        Five f1 = new Five();
    }
}