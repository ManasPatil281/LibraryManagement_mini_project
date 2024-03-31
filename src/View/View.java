
package View;

import Model.Books.ManageBooks;
import Model.Publications.ManagePublications;
import Model.Utils.Displayable;
import Model.Authors.ManageAuthors;
import View.InitialPubsFrame;
import View.ManagePubsFrame;

import java.awt.*;
import java.util.ArrayList;

public class View {
    FirstFrame ff;
    ManageAuthorFrame maf;
    ManageBookFrame mbf;
    ManagePubsFrame mpf;



    public View() {
        ff = new FirstFrame();
        maf = new ManageAuthorFrame();
        mbf = new ManageBookFrame();
        mpf = new ManagePubsFrame();
    }

    public void centerInitialSetupAuthor(int linesBeingDisplayed, int size) {
        maf.getIp().getCp().setLayout(new GridLayout(linesBeingDisplayed + 1, size));
        maf.getIp().getCp().createButtons((linesBeingDisplayed + 1) * size);
    }

    public void centerUpdateAuthor(ArrayList<ArrayList<String>> lines, ArrayList<String> headers) {
        for (int i = 0; i < headers.size(); i++) {
            maf.getIp().getCp().getAllButtons().get(i).setText(headers.get(i));
        }


        for (int Author_row_no = 0; Author_row_no < lines.size(); Author_row_no++) {
            for (int Author_col_no = 0; Author_col_no < headers.size(); Author_col_no++) {
                int button_no = Author_row_no * headers.size() + headers.size() + Author_col_no;
                String button_txt = lines.get(Author_row_no).get(Author_col_no);

                maf.getIp().getCp().getAllButtons().get(button_no).setText(button_txt);
            }
        }
    }
        public void centerInitialSetupBook ( int linesBeingDisplayed, int size){
            mbf.getBipp().getBp().setLayout(new GridLayout(linesBeingDisplayed + 1, size));
            mbf.getBipp().getBp().createButtons((linesBeingDisplayed + 1) * size);
        }
        public void centerUpdateBook (ArrayList < ArrayList < String >> lines, ArrayList < String > headers){
            for (int i = 0; i < headers.size(); i++) {
                mbf.getBipp().getBp().getAllButtons().get(i).setText(headers.get(i));
            }

            for (int book_row_no = 0; book_row_no < lines.size(); book_row_no++) {
                for (int book_col_no = 0; book_col_no < headers.size(); book_col_no++) {
                    int button_no = book_row_no * headers.size() + headers.size() + book_col_no;
                    String button_txt = lines.get(book_row_no).get(book_col_no);

                    mbf.getBipp().getBp().getAllButtons().get(button_no).setText(button_txt);
                }
            }
        }
    public void centerInitialSetupPubs ( int linesBeingDisplayed, int size){
        mpf.getPipp().getPp().setLayout(new GridLayout(linesBeingDisplayed + 1, size));
        mpf.getPipp().getPp().createButtons((linesBeingDisplayed + 1) * size);
    }
    public void centerUpdatePubs (ArrayList < ArrayList < String >> lines, ArrayList < String > headers){
        for (int i = 0; i < headers.size(); i++) {
            mpf.getPipp().getPp().getAllButtons().get(i).setText(headers.get(i));
        }

        for (int Pubs_row_no = 0; Pubs_row_no < lines.size(); Pubs_row_no++) {
            for (int Pubs_col_no = 0; Pubs_col_no < headers.size(); Pubs_col_no++) {
                int button_no =Pubs_row_no * headers.size() + headers.size() + Pubs_col_no;
                String button_txt = lines.get(Pubs_row_no).get(Pubs_col_no);

                mpf.getPipp().getPp().getAllButtons().get(button_no).setText(button_txt);
            }
        }
    }

    public  FirstFrame getFf() {
        return ff;
    }

    public void setFf(FirstFrame ff) {
        this.ff = ff;
    }

    public ManageAuthorFrame getMaf() {
        return maf;
    }

    public void setMaf(ManageAuthorFrame maf) {
        this.maf = maf;
    }

    public ManageBookFrame getMbf() {
        return mbf;
    }

    public void setMbf(ManageBookFrame mbf) {
        this.mbf = mbf;
    }

    public void setMpf(ManagePubsFrame mpf) {
        this.mpf = mpf;
    }

    public ManagePubsFrame getMpf() {
        return mpf;
    }
}


