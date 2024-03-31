package View;

import javax.swing.*;

public class InitialBookFrame extends JPanel {

    private CentrePanelBook bp;
    private AddBookPanel bps;
    private EditBookPanel ebp;
    private  DeleteBookPanel dbp;

    public InitialBookFrame() {
        super();
        bp = new CentrePanelBook();
        add(bp);
        bps = new AddBookPanel();
        add(bps);
        ebp = new EditBookPanel();
        add(ebp);
        dbp= new DeleteBookPanel();
        add(dbp);

    }

    public CentrePanelBook getBp() {
        return bp;
    }
    public AddBookPanel getBps() {
        return bps;
    }

    public void setBp(CentrePanelBook cp) {
        this.bp = bp;
    }

    public void setBps(AddBookPanel aps) {
        this.bps = bps;
    }

    public DeleteBookPanel getDbp() {
        return dbp;
    }

    public EditBookPanel getEbp() {
        return ebp;
    }

    public void setEbp(EditBookPanel ebp) {
        this.ebp = ebp;
    }

    public void setDbp(DeleteBookPanel dbp) {
        this.dbp = dbp;
    }
}
