package View;

import javax.swing.*;

public class ManageBookFrame extends JFrame {
    InitialBookFrame bip;

    public ManageBookFrame()
    {
        super("Manage Book DashBoard");
        bip = new InitialBookFrame();
        add(bip);
        pack();
        setSize(500, 600);
    }

    public void setBip(InitialBookFrame  bip) {
        this.bip = bip;
    }

    public InitialBookFrame getBipp() {
        return bip;
    }
}