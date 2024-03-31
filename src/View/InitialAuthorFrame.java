
package View;

import javax.swing.*;

public class InitialAuthorFrame extends JPanel {

    private CentrePanelAuthor cp;
    private AddAuthorPanel aps;
    private EditAuthorPanel eps;
    private DeleteAuthorPanel dps;

    public InitialAuthorFrame() {
        super();
        cp = new CentrePanelAuthor();
        add(cp);
        aps = new AddAuthorPanel();
        add(aps);
        eps = new EditAuthorPanel();
        add(eps);
        dps = new DeleteAuthorPanel();
        add(dps);
    }

    public CentrePanelAuthor getCp() {
        return cp;
    }
    public AddAuthorPanel getAps() {
        return aps;
    }

    public DeleteAuthorPanel getDps() {
        return dps;
    }

    public EditAuthorPanel getEps() {
        return eps;
    }

    public void setDps(DeleteAuthorPanel dps) {
        this.dps = dps;
    }

    public void setEps(EditAuthorPanel eps) {
        this.eps = eps;
    }

    public void setCp(CentrePanelAuthor cp) {
        this.cp = cp;
    }

    public void setAps(AddAuthorPanel aps) {
        this.aps = aps;
    }

}
