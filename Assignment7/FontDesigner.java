import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FontDesigner extends JFrame implements ActionListener {
    private JComboBox<String> fontFamilyComboBox;
    private JTextField helloTextField, fontSizeTextField;
    private JCheckBox boldCheckBox;
    private JCheckBox italicCheckBox;
    private JButton applyButton;
    private JButton exitButton;

    public FontDesigner() {
        setTitle("Font Designer");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(7, 2, 10, 10));

        JLabel fontFamilyLabel = new JLabel("Font Family:");
        add(fontFamilyLabel);

        fontFamilyComboBox = new JComboBox<>(GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames());
        add(fontFamilyComboBox);

        JLabel fontSizeLabel = new JLabel("Font Size:");
        add(fontSizeLabel);

        fontSizeTextField = new JTextField();
        add(fontSizeTextField);

        JLabel fontStyleLabel = new JLabel("Font Style:");
        add(fontStyleLabel);

        JPanel fontStylePanel = new JPanel();
        fontStylePanel.setLayout(new FlowLayout());

        boldCheckBox = new JCheckBox("Bold");
        fontStylePanel.add(boldCheckBox);

        italicCheckBox = new JCheckBox("Italic");
        fontStylePanel.add(italicCheckBox);

        add(fontStylePanel);

        JLabel helloLabel = new JLabel("Hello Everyone");
        add(helloLabel);

        helloTextField = new JTextField("Hello Everyone");
        helloTextField.setEditable(false);
        add(helloTextField);

        applyButton = new JButton("Apply");
        applyButton.addActionListener(this);
        add(applyButton);

        exitButton = new JButton("Exit");
        exitButton.addActionListener(this);
        add(exitButton);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == applyButton) {
            // Apply font effect
            int size = Integer.parseInt(fontSizeTextField.getText());
            int style = Font.PLAIN;
            if (boldCheckBox.isSelected()) {
                style += Font.BOLD;
            }
            if (italicCheckBox.isSelected()) {
                style += Font.ITALIC;
            }
            Font font = new Font(fontFamilyComboBox.getSelectedItem().toString(), style, size);
            helloTextField.setFont(font);
        } else if (e.getSource() == exitButton) {
            // Exit the application
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new FontDesigner();
    }
}
