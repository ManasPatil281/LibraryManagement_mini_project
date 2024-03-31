package Model.Books;

public class Publication {
    private static int publicationCount = 0;
    int publicationID;
    String title;
    String publishedDate;
    String language;

    public Publication() {
        publicationCount++;
        this.setPublicationID(publicationCount);
    }

    public Publication(String title, String publishedDate, String language) {
        publicationCount++;
        this.setPublicationID(publicationCount);
        this.setTitle(title);
        this.setPublishedDate(publishedDate);
        this.setLanguage(language);
    }

    public void setPublicationID(int publicationID) {
        this.publicationID = publicationID;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getPublicationID() {
        return publicationID;
    }

    public String getTitle() {
        return title;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public String getLanguage() {
        return language;
    }

    public void display() {
        System.out.println("Publication ID: " + getPublicationID());
        System.out.println("Title: " + getTitle());
        System.out.println("Published Date: " + getPublishedDate());
        System.out.println("Language: " + getLanguage());
    }
}
