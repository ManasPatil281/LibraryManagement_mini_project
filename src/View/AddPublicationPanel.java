package View;

import javax.swing.*;
import java.awt.*;

public class AddPublicationPanel extends JPanel {
    JTextField txt_B;
    JTextField txt_A;
    JTextField txt_publicationDate;
    JTextField txt_publisher;
    JButton addPublisherBtn;

    public AddPublicationPanel() {
        // Set layout to BoxLayout for vertical alignment
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        // Set background color
        setBackground(new Color(240, 240, 240));

        txt_B = createStyledTextField("Book ID");
        txt_A = createStyledTextField("Author ID");
        txt_publicationDate = createStyledTextField("Publication Date");
        txt_publisher = createStyledTextField("Publisher");
        addPublisherBtn = new JButton("Add Publication");
        addPublisherBtn.setAlignmentX(Component.CENTER_ALIGNMENT); // Center align button
        addPublisherBtn.setBackground(new Color(50, 150, 250)); // Blue background
        addPublisherBtn.setForeground(Color.WHITE); // White text
        addPublisherBtn.setFont(new Font("Arial", Font.BOLD, 14)); // Set font
        addPublisherBtn.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Add padding

        // Add components to the panel with vertical spacing
        add(Box.createVerticalStrut(10));
        add(txt_B);
        add(Box.createVerticalStrut(10));
        add(txt_A);
        add(Box.createVerticalStrut(10));
        add(txt_publicationDate);
        add(Box.createVerticalStrut(10));
        add(txt_publisher);
        add(Box.createVerticalStrut(20));
        add(addPublisherBtn);
    }

    // Method to create a styled text field
    private JTextField createStyledTextField(String placeholder) {
        JTextField textField = new JTextField(20);
        textField.setMaximumSize(new Dimension(250, 30));
        textField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(150, 150, 150)),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        textField.setFont(new Font("Arial", Font.PLAIN, 14));
        textField.setForeground(new Color(50, 50, 50));
        textField.setText(placeholder);
        textField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textField.selectAll();
            }
        });
        return textField;
    }

    public JButton getAddPublisherBtn() {
        return addPublisherBtn;
    }

    public JTextField getTxt_A() {
        return txt_A;
    }

    public JTextField getTxt_B() {
        return txt_B;
    }

    public JTextField getTxt_publicationDate() {
        return txt_publicationDate;
    }

    public JTextField getTxt_publisher() {
        return txt_publisher;
    }

    public void setAddPublisherBtn(JButton addPublisherBtn) {
        this.addPublisherBtn = addPublisherBtn;
    }

    public void setTxt_A(JTextField txt_A) {
        this.txt_A = txt_A;
    }

    public void setTxt_B(JTextField txt_B) {
        this.txt_B = txt_B;
    }

    public void setTxt_publicationDate(JTextField txt_publicationDate) {
        this.txt_publicationDate = txt_publicationDate;
    }

    public void setTxt_publisher(JTextField txt_publisher) {
        this.txt_publisher = txt_publisher;
    }
}
