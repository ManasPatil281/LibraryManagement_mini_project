package View;

import javax.swing.*;

public class ManageAuthorFrame extends JFrame {
    InitialAuthorFrame ip;

    public ManageAuthorFrame()
    {
        super("Manage Author DashBoard");
        ip = new InitialAuthorFrame();
        add(ip);
        pack();
        setSize(500, 600);
    }

    public void setIp(InitialAuthorFrame ip) {
        this.ip = ip;
    }

    public InitialAuthorFrame getIp() {
        return ip;
    }
}