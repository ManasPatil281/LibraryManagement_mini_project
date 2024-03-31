package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class FirstFrame extends JFrame {
    String bg1="src/View/bg2.png";
    String bg2="src/View/bg_1.jpg";
    JButton manageAuthorBtn;
    JButton manageBooksBtn;
    JButton managePublicationsBtn;
    JPanel firstPanel;
    JPanel secondPanel;
    JLabel head;

    FirstFrame() {
        super("Main DashBoard");
        manageAuthorBtn = new JButton("Manage Authors");
        manageBooksBtn = new JButton("Manage Books");
        managePublicationsBtn = new JButton("Manage Publications");
        head = new JLabel("Welcome To Library Management",JLabel.CENTER);
        head.setForeground(Color.black);
        head.setFont(new Font("algerian", Font.BOLD, 30));
        head.setBackground(Color.BLUE);
        try {
            Image backgroundImage = ImageIO.read(new File(bg1));
            firstPanel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                }
            };
        } catch (IOException e) {
            e.printStackTrace();
        }
        firstPanel.setLayout(new BorderLayout());
        firstPanel.add(head,BorderLayout.NORTH);


        Font buttonFont = new Font("Arial", Font.BOLD, 16);
        manageAuthorBtn.setFont(buttonFont);
        manageBooksBtn.setFont(buttonFont);
        managePublicationsBtn.setFont(buttonFont);
        manageAuthorBtn.setFont(new Font("Arial", Font.BOLD, 16));
        manageAuthorBtn.setForeground(Color.WHITE);
        manageAuthorBtn.setBackground(new Color(16, 149, 56));
        manageAuthorBtn.setFocusPainted(false);
        manageAuthorBtn.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK, 2), BorderFactory.createEmptyBorder(10, 20, 10, 20)));
        manageAuthorBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        manageAuthorBtn.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                manageAuthorBtn.setBackground(Color.BLUE);
            }

            public void mouseExited(MouseEvent e) {
                manageAuthorBtn.setBackground(new Color(16, 149, 56));
            }
        });
        manageBooksBtn.setFont(new Font("Arial", Font.BOLD, 16));
        manageBooksBtn.setForeground(Color.WHITE);
        manageBooksBtn.setBackground(new Color(16, 149, 56));
        manageBooksBtn.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK, 2), BorderFactory.createEmptyBorder(10, 20, 10, 20)));
        manageBooksBtn.setFocusPainted(false);
        manageBooksBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        manageBooksBtn.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                manageBooksBtn.setBackground(Color.BLUE);
            }

            public void mouseExited(MouseEvent e) {
                manageBooksBtn.setBackground(new Color(16, 149, 56));
            }
        });
        managePublicationsBtn.setFont(new Font("Arial", Font.BOLD, 16));
        managePublicationsBtn.setForeground(Color.WHITE);
        managePublicationsBtn.setBackground(new Color(16, 149, 56));
        managePublicationsBtn.setFocusPainted(false);
        managePublicationsBtn.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK, 2), BorderFactory.createEmptyBorder(10, 20, 10, 20)));
        managePublicationsBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        managePublicationsBtn.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                managePublicationsBtn.setBackground(Color.BLUE);
            }

            public void mouseExited(MouseEvent e) {
                managePublicationsBtn.setBackground(new Color(16, 149, 56));
            }
        });
        try {
            Image backgroundImage = ImageIO.read(new File(bg2));
            secondPanel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                }
            };
        } catch (IOException e) {
            e.printStackTrace();
        }
        secondPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

        secondPanel.add(manageAuthorBtn);
        secondPanel.add(manageBooksBtn);
        secondPanel.add(managePublicationsBtn);
        firstPanel.add(secondPanel);

        add(firstPanel);

        pack();
        setSize(600, 300);
        setVisible(true);

    }
    public JButton getManageAuthorBtn() {
        return manageAuthorBtn;
    }
    public JButton getManageBooksBtn() {
        return manageBooksBtn;
    }
    public JButton getManagePublicationsBtn() {
        return managePublicationsBtn;
    }


}

