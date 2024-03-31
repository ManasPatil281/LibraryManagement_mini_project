package View;

import javax.swing.*;

public class ManagePubsFrame extends JFrame {
    InitialPubsFrame pip;

    public ManagePubsFrame()
    {
        super("Manage Publication DashBoard");
        pip = new InitialPubsFrame();
        add(pip);
        pack();
        setSize(500, 600);
    }

    public void setPipp(InitialPubsFrame pip) {
        this.pip = pip;
    }

    public InitialPubsFrame getPipp() {
        return pip;
    }
}