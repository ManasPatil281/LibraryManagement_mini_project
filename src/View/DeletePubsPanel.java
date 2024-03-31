package View;

import javax.swing.*;
import java.awt.*;

public class DeletePubsPanel extends JPanel {
    JTextField txt_del_Pubs_idx;
    JButton deletePubsBtn;

    public DeletePubsPanel() {
        // Set layout to BoxLayout for vertical alignment
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        // Set background color
        setBackground(new Color(240, 240, 240));

        txt_del_Pubs_idx = createStyledTextField("Publication ID");
        deletePubsBtn = new JButton("Delete Publication");
        deletePubsBtn.setAlignmentX(Component.CENTER_ALIGNMENT); // Center align button
        deletePubsBtn.setBackground(new Color(250, 100, 100)); // Red background
        deletePubsBtn.setForeground(Color.WHITE); // White text
        deletePubsBtn.setFont(new Font("Arial", Font.BOLD, 14)); // Set font
        deletePubsBtn.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Add padding

        // Add components to the panel with vertical spacing
        add(Box.createVerticalStrut(10));
        add(txt_del_Pubs_idx);
        add(Box.createVerticalStrut(20));
        add(deletePubsBtn);
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

    public JButton getDeletePubsBtn() {
        return deletePubsBtn;
    }

    public JTextField getTxt_del_Pubs_idx() {
        return txt_del_Pubs_idx;
    }

    public void setDeletePubsBtn(JButton deletePubsBtn) {
        this.deletePubsBtn = deletePubsBtn;
    }

    public void setTxt_del_Pubs_idx(JTextField txt_del_Pubs_idx) {
        this.txt_del_Pubs_idx = txt_del_Pubs_idx;
    }
}
