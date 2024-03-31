package View;

import javax.swing.*;
import java.awt.*;

public class DeleteBookPanel extends JPanel {
    JTextField txt_del_book_id;
    JButton deleteBookBtn;

    public DeleteBookPanel() {
        // Set layout to BoxLayout for vertical alignment
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        // Set background color
        setBackground(new Color(240, 240, 240));

        txt_del_book_id = createStyledTextField("Book ID");
        deleteBookBtn = new JButton("Delete Book");
        deleteBookBtn.setAlignmentX(Component.CENTER_ALIGNMENT); // Center align button
        deleteBookBtn.setBackground(new Color(250, 100, 100)); // Red background
        deleteBookBtn.setForeground(Color.WHITE); // White text
        deleteBookBtn.setFont(new Font("Arial", Font.BOLD, 14)); // Set font
        deleteBookBtn.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Add padding

        // Add components to the panel with vertical spacing
        add(Box.createVerticalStrut(10));
        add(txt_del_book_id);
        add(Box.createVerticalStrut(20));
        add(deleteBookBtn);
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

    public void setDeleteBookBtn(JButton deleteBookBtn) {
        this.deleteBookBtn = deleteBookBtn;
    }

    public void setTxt_del_book_id(JTextField txt_del_book_id) {
        this.txt_del_book_id = txt_del_book_id;
    }

    public JButton getDeleteBookBtn() {
        return deleteBookBtn;
    }

    public JTextField getTxt_del_book_id() {
        return txt_del_book_id;
    }
}
