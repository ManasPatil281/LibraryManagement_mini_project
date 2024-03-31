package View;

import javax.swing.*;

public class InitialPubsFrame extends JPanel {

    private CentrePanelPubs pp;
    private AddPublicationPanel pps;
    private EditPubsPanel epp;
    private DeletePubsPanel dpp;

    public InitialPubsFrame() {
        super();
        pp = new CentrePanelPubs();
        add(pp);
        pps = new AddPublicationPanel();
        add(pps);
        epp=new EditPubsPanel();
        add(epp);
        dpp=new DeletePubsPanel();
        add(dpp);
    }

    public CentrePanelPubs getPp() {
        return pp;
    }
    public AddPublicationPanel getPps() {
        return pps;
    }

    public void setPp(CentrePanelPubs pp) {
        this.pp = pp;
    }

    public void setPps(AddPublicationPanel pps) {
        this.pps = pps;
    }

    public void setDpp(DeletePubsPanel dpp) {
    }

    public void setEpp(EditPubsPanel epp) {
        this.epp = epp;
    }

    public DeletePubsPanel getDpp() {
        return dpp;
    }

    public EditPubsPanel getEpp() {
        return epp;
    }
}

