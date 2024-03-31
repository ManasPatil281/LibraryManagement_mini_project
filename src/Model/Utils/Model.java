package Model.Utils;

import Model.Publications.ManagePublications;
import Model.Authors.ManageAuthors;
import Model.Books.ManageBooks;

public class Model {
    ManageAuthors ms1;
    ManagePublications ms3;
    ManageBooks ms2;

    public Model() {
        ms1 = new ManageAuthors();
        ms2 = new ManageBooks();
        ms3 = new ManagePublications();
    }

    public ManagePublications getMs3() {
        return ms3;
    }

    public ManageAuthors getMs1() {
        return ms1;
    }

    public ManageBooks getMs2() {
        return ms2;
    }

    public void setMs3(ManagePublications ms) {
        this.ms3= ms3;
    }

    public void setMs1(ManageAuthors ms1) {
        this.ms1 = ms1;
    }

    public void setMs2(ManageBooks ms2) {
        this.ms2 = ms2;
    }
}
