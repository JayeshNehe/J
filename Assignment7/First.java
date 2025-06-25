import javax.swing.*;
//import java.awt.GridLayout;
//import javax.swing.event.*;
//import java.awt.*;
import java.awt.event.*;

public class First extends JFrame implements ActionListener
{
    JTextField tf;
    JPasswordField pf;
    JButton b1, b2;

    First()
    {
        JFrame f = new JFrame();
        JLabel l1 = new JLabel("User Name");
        JLabel l2 = new JLabel("Password");
        //JPanel p = new JPanel();

        tf = new JTextField();
        pf = new JPasswordField();
        b1 = new JButton("Submit");
        b2 = new JButton("Cancel");

        b1.addActionListener(this);
        b2.addActionListener(this);

        l1.setBounds(40,105, 80,30);
        l2.setBounds(40,155, 80,30);
        tf.setBounds(150, 100, 200, 40);
        pf.setBounds(150, 150, 200, 40);
        //tf.setPreferredSize(new Dimension(150, 30));
        //pf.setPreferredSize(new Dimension(150, 30));
        b1.setBounds(80, 250, 80, 30);
        b2.setBounds(200, 250, 80, 30);

        f.add(l1);
        f.add(l2);
        f.add(tf);
        f.add(pf);
        f.add(b1);
        f.add(b2);
        //f.add(p);

        //f.setLayout(new FlowLayout());
        //l1.setLocation(100, 100);
        
        f.setSize(400, 400);
        //f.setLayout(new GridLayout(3, 2, 5, 5));
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == b1)
        {
            String username = tf.getText();
            char[] s1 = pf.getPassword();
            String password = new String(s1);

            // if("chetan".equals(username) && "chetan@123".equals(password))
            // {
            //     JOptionPane.showMessageDialog(this, "Correct login details");
            // }
            // else
            // {
            //     JOptionPane.showMessageDialog(this, "Wrong details");
            // }

            if(username.equals(password))
            {
                JOptionPane.showMessageDialog(this, "Correct login details");
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Wrong details");
            }

            tf.setText("");
            pf.setText("");
        }
        else if(e.getSource() == b2)
        {
            // Clear fields when cancel button is clicked
            tf.setText("");
            pf.setText("");
        }
    }

    public static void main(String[] args) {
        //First f1 = new First();

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new First();
            }
        });
    }
}