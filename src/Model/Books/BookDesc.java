package Model.Books;

public interface BookDesc {
    void addReviewS(String reviewS);
    void removeReviewS(int reviewSIndex);
    void displayReviewS();

    void addDescription(String description);
    void removeDescription(int descriptionIndex);
    void displayDescription();
}
