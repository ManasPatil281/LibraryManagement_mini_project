package Model.Publications;

import Model.Authors.Authors;
import Model.Books.Books;

public class Publications{
     Books b_temp;
     Authors a_temp;
     String publicationDate;
     String publisher;

    public Publications(Authors a,Books b, String publicationDate, String publisher) {
        setA_temp(a);
        setB_temp(b);
        setPublicationDate(publicationDate);
        setPublisher(publisher);
    }



    public void setB_temp(Books b_temp) {
        this.b_temp = b_temp;
    }

    public void setA_temp(Authors a_temp) {
        this.a_temp = a_temp;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Books getB_temp() {
        return b_temp;
    }

    public Authors getA_temp() {
        return a_temp;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public String getPublisher() {
        return publisher;
    }
    public void display() {
        System.out.println("Author P_id: " + getA_temp());
        System.out.println("Book P_id:"+getB_temp());
        System.out.println("Publication Date: " + getPublicationDate());
        System.out.println("Publisher:" + getPublisher());
    }
}
