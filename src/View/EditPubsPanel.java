package View;

import javax.swing.*;
import java.awt.*;

public class EditPubsPanel extends JPanel {
    JTextField txt_get_Pubs_idx;
    JButton getPubsBtn;
    JTextField txt_author_id;
    JTextField txt_book_id;
    JTextField txt_publication_date;
    JTextField txt_publisher;
    JButton editPubsBtn;

    public EditPubsPanel() {
        // Set layout to BoxLayout for vertical alignment
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        // Set background color
        setBackground(new Color(240, 240, 240));

        txt_author_id = createStyledTextField("Author ID");
        txt_book_id = createStyledTextField("Book ID");
        txt_publication_date = createStyledTextField("Publication Date");
        txt_publisher = createStyledTextField("Publisher");
        editPubsBtn = new JButton("Edit Publication");
        txt_get_Pubs_idx = createStyledTextField("Enter Publication ID");
        getPubsBtn = new JButton("Get Publication to Edit");

        // Disable editing for author ID and book ID text fields
        txt_author_id.setEditable(false);
        txt_book_id.setEditable(false);

        // Add components to the panel with vertical spacing
        add(Box.createVerticalStrut(10));
        add(txt_get_Pubs_idx);
        add(Box.createVerticalStrut(10));
        add(getPubsBtn);
        add(Box.createVerticalStrut(10));
        add(txt_author_id);
        add(Box.createVerticalStrut(10));
        add(txt_publication_date);
        add(Box.createVerticalStrut(10));
        add(txt_book_id);
        add(Box.createVerticalStrut(10));
        add(txt_publisher);
        add(Box.createVerticalStrut(20));
        add(editPubsBtn);
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

    public JTextField getTxt_get_Pubs_idx() {
        return txt_get_Pubs_idx;
    }

    public JTextField getTxt_author_id() {
        return txt_author_id;
    }

    public JTextField getTxt_publisher() {
        return txt_publisher;
    }

    public JButton getEditPubsBtn() {
        return editPubsBtn;
    }

    public JButton getGetPubsBtn() {
        return getPubsBtn;
    }

    public JTextField getTxt_book_id() {
        return txt_book_id;
    }

    public JTextField getTxt_publication_date() {
        return txt_publication_date;
    }

    public void setTxt_author_id(JTextField txt_author_id) {
        this.txt_author_id = txt_author_id;
    }

    public void setGetPubsBtn(JButton getPubsBtn) {
        this.getPubsBtn = getPubsBtn;
    }

    public void setTxt_publisher(JTextField txt_publisher) {
        this.txt_publisher = txt_publisher;
    }

    public void setTxt_get_Pubs_idx(JTextField txt_get_Pubs_idx) {
        this.txt_get_Pubs_idx = txt_get_Pubs_idx;
    }

    public void setEditPubsBtn(JButton editPubsBtn) {
        this.editPubsBtn = editPubsBtn;
    }

    public void setTxt_book_id(JTextField txt_book_id) {
        this.txt_book_id = txt_book_id;
    }

    public void setTxt_publication_date(JTextField txt_publication_date) {
        this.txt_publication_date = txt_publication_date;
    }
}
