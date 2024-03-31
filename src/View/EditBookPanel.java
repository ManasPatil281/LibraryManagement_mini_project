package View;

import javax.swing.*;
import java.awt.*;

public class EditBookPanel extends JPanel {
    JTextField txt_get_Book_idx;
    JButton getBookBtn;
    JTextField txt_Book_id;
    JTextField txt_Book_name;
    JTextField txt_Book_genre;
    JTextField txt_Book_copiesSold;
    JTextField txt_Book_language;
    JTextField txt_Book_price;
    JButton editBookBtn;

    public EditBookPanel() {
        // Set layout to BoxLayout for vertical alignment
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        // Set background color
        setBackground(new Color(240, 240, 240));

        txt_Book_id = createStyledTextField("Book ID");
        txt_Book_name = createStyledTextField("Book Name");
        txt_Book_genre = createStyledTextField("Book Genre");
        txt_Book_copiesSold = createStyledTextField("Copies Sold");
        txt_Book_language = createStyledTextField("Language");
        txt_Book_price = createStyledTextField("Price");
        editBookBtn = new JButton("Edit Book");
        txt_get_Book_idx = createStyledTextField("Enter Book ID");
        getBookBtn = new JButton("Get Book to Edit");

        // Add components to the panel with vertical spacing
        add(Box.createVerticalStrut(10));
        add(txt_get_Book_idx);
        add(Box.createVerticalStrut(10));
        add(getBookBtn);
        add(Box.createVerticalStrut(10));
        add(txt_Book_id);
        add(Box.createVerticalStrut(10));
        add(txt_Book_name);
        add(Box.createVerticalStrut(10));
        add(txt_Book_genre);
        add(Box.createVerticalStrut(10));
        add(txt_Book_copiesSold);
        add(Box.createVerticalStrut(10));
        add(txt_Book_language);
        add(Box.createVerticalStrut(10));
        add(txt_Book_price);
        add(Box.createVerticalStrut(20));
        add(editBookBtn);
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

    public JButton getEditBookBtn() {
        return editBookBtn;
    }

    public JButton getGetBookBtn() {
        return getBookBtn;
    }

    public JTextField getTxt_Book_copiesSold() {
        return txt_Book_copiesSold;
    }

    public JTextField getTxt_Book_genre() {
        return txt_Book_genre;
    }

    public JTextField getTxt_Book_id() {
        return txt_Book_id;
    }

    public JTextField getTxt_Book_language() {
        return txt_Book_language;
    }

    public JTextField getTxt_Book_name() {
        return txt_Book_name;
    }

    public JTextField getTxt_Book_price() {
        return txt_Book_price;
    }

    public JTextField getTxt_get_Book_idx() {
        return txt_get_Book_idx;
    }

    public void setEditBookBtn(JButton editBookBtn) {
        this.editBookBtn = editBookBtn;
    }

    public void setGetBookBtn(JButton getBookBtn) {
        this.getBookBtn = getBookBtn;
    }

    public void setTxt_Book_copiesSold(JTextField txt_Book_copiesSold) {
        this.txt_Book_copiesSold = txt_Book_copiesSold;
    }

    public void setTxt_Book_genre(JTextField txt_Book_genre) {
        this.txt_Book_genre = txt_Book_genre;

    }
}