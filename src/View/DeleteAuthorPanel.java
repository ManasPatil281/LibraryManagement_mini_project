package View;

import javax.swing.*;
import java.awt.*;

// Panel for deleting an author
public class DeleteAuthorPanel extends JPanel {

    // Text field for entering author ID to delete
    private JTextField txt_del_author_id;
    // Button for deleting author
    private JButton deleteAuthorBtn;

    // Constructor
    public DeleteAuthorPanel() {
        // Set layout to BoxLayout for vertical alignment
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        // Set background color
        setBackground(new Color(240, 240, 240));

        // Initialize components with custom styling
        txt_del_author_id = createStyledTextField("Enter Author ID");
        deleteAuthorBtn = new JButton("Delete Author");
        deleteAuthorBtn.setAlignmentX(Component.CENTER_ALIGNMENT); // Center align button
        deleteAuthorBtn.setBackground(new Color(255, 100, 100)); // Red background
        deleteAuthorBtn.setForeground(Color.WHITE); // White text
        deleteAuthorBtn.setFont(new Font("Arial", Font.BOLD, 14)); // Set font
        deleteAuthorBtn.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Add padding

        // Add components to the panel with vertical spacing
        add(Box.createVerticalStrut(20));
        add(txt_del_author_id);
        add(Box.createVerticalStrut(10));
        add(deleteAuthorBtn);
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

    // Getter methods for components
    public JTextField getTxt_del_author_id() {
        return txt_del_author_id;
    }

    public JButton getDeleteAuthorBtn() {
        return deleteAuthorBtn;
    }
}
