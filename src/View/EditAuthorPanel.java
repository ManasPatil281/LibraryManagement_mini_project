package View;

import javax.swing.*;
import java.awt.*;


public class EditAuthorPanel extends JPanel {


    private JTextField txt_get_Author_idx;
    private JTextField txt_author_id;
    private JTextField txt_author_name;
    private JTextField txt_author_genre;
    private JTextField txt_author_rating;
    private JTextField txt_author_language;

    private JButton getAuthorBtn;
    private JButton editAuthorBtn;


    public EditAuthorPanel() {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        setBackground(new Color(240, 240, 240));


        txt_get_Author_idx = createStyledTextField("Enter Author ID");
        txt_author_id = createStyledTextField("Author ID");
        txt_author_name = createStyledTextField("Author Name");
        txt_author_genre = createStyledTextField("Author Genre");
        txt_author_rating = createStyledTextField("Author Rating");
        txt_author_language = createStyledTextField("Author Language");
        getAuthorBtn = new JButton("Get Author to Edit");
        editAuthorBtn = new JButton("Edit Author");
        editAuthorBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        editAuthorBtn.setBackground(new Color(50, 150, 250));
        editAuthorBtn.setForeground(Color.WHITE);
        editAuthorBtn.setFont(new Font("Arial", Font.BOLD, 14));
        editAuthorBtn.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));


        add(Box.createVerticalStrut(10));
        add(txt_get_Author_idx);
        add(Box.createVerticalStrut(10));
        add(getAuthorBtn);
        add(Box.createVerticalStrut(20));
        add(txt_author_id);
        add(Box.createVerticalStrut(10));
        add(txt_author_name);
        add(Box.createVerticalStrut(10));
        add(txt_author_genre);
        add(Box.createVerticalStrut(10));
        add(txt_author_rating);
        add(Box.createVerticalStrut(10));
        add(txt_author_language);
        add(Box.createVerticalStrut(20));
        add(editAuthorBtn);
    }

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

    public JTextField getTxt_get_Author_idx() {
        return txt_get_Author_idx;
    }

    public JTextField getTxt_author_id() {
        return txt_author_id;
    }

    public JTextField getTxt_author_name() {
        return txt_author_name;
    }

    public JTextField getTxt_author_genre() {
        return txt_author_genre;
    }

    public JTextField getTxt_author_rating() {
        return txt_author_rating;
    }

    public JTextField getTxt_author_language() {
        return txt_author_language;
    }

    public JButton getGetAuthorBtn() {
        return getAuthorBtn;
    }

    public JButton getEditAuthorBtn() {
        return editAuthorBtn;
    }
}
