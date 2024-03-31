package Model.Authors;

import java.util.ArrayList;
import java.util.Scanner;

public class Authors implements AuthDesc {

    private int authorID;
    private String authorName;
    private String authorGenre;
    private int authorRating;
    private String authorLanguage;
    private int authorAchievements_count = 0;
    private int authorReview_count = 0;
    private ArrayList<String> authorAchievements = new ArrayList<>();
    private ArrayList<String> authorReviews = new ArrayList<>();



    public Authors() {

    }

    public Authors(int authorID, String authorName, String authorGenre,  String authorLanguage,int authorRating) {
        this.setAuthorID(authorID);
        this.setAuthorName(authorName);
        this.setAuthorGenre(authorGenre);
        this.setAuthorLanguage(authorLanguage);
        this.setAuthorRating(authorRating);
    }

    public void setAuthorID(int authorID) {
        this.authorID = authorID;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setAuthorGenre(String authorGenre) {
        this.authorGenre = authorGenre;
    }

    public void setAuthorRating(int authorRating) {
        this.authorRating = authorRating;
    }

    public void setAuthorLanguage(String authorLanguage) {
        this.authorLanguage = authorLanguage;
    }

    public void setAuthorAchievements_count(int authorAchievements_count) {
        this.authorAchievements_count = authorAchievements_count;
    }

    public void setAuthorReviewCount(int authorReviewCount) {
        this.authorReview_count = authorReviewCount;
    }

    public int getAuthorID() {
        return authorID;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getAuthorGenre() {
        return authorGenre;
    }

    public int getAuthorRating() {
        return authorRating;
    }

    public String getAuthorLanguage() {
        return authorLanguage;
    }

    public int getAuthorAchievements_count() {
        return authorAchievements_count;
    }

    public int getAuthorReviewCount() {
        return authorReview_count;
    }

    public void display() {
        System.out.println("Author Id: " + getAuthorID());
        System.out.println("Author Name:" + getAuthorName());
        System.out.println("Author Genre: " + getAuthorGenre());
        System.out.println("Author Rating: " + getAuthorRating());
        System.out.println("Author Language: " + getAuthorLanguage());
    }

    public void addAchievement(String achievement) {
        System.out.println("Adding Author Achievement");
        if (getAuthorAchievements_count() < 5) {
            authorAchievements.add(achievement);
            setAuthorAchievements_count(getAuthorAchievements_count() + 1);
            System.out.println("Author Achievement Added Successfully");
        } else {
            System.out.println("5 Author Achievements Already Added. Cannot add more");
        }
    }

    public void removeAchievement(int achievementIndex) {
        if (getAuthorAchievements_count() > 1) {
            System.out.println("Removing Author Achievement");
            authorAchievements.remove(achievementIndex);
            setAuthorAchievements_count(getAuthorAchievements_count() - 1);
            System.out.println("Author Achievement Removed Successfully");
        } else {
            System.out.println("Author Achievements Empty");
        }
    }

    public void displayAchievements() {
        System.out.println("Author Achievements:");
        for (int i = 0; i < authorAchievements.size(); i++) {
            System.out.println(authorAchievements.get(i));
        }
    }

    public void addReview(String review) {
        System.out.println("Adding Author Review");
        if (getAuthorReviewCount() < 5) {
            authorReviews.add(review);
            setAuthorReviewCount(getAuthorReviewCount() + 1);
            System.out.println("Author Review Added Successfully");
        } else {
            System.out.println("5 Author Reviews Already Added. Cannot add more");
        }
    }

    public void removeReview(int reviewIndex) {
        if (getAuthorReviewCount() > 1) {
            System.out.println("Removing Author Review");
            authorReviews.remove(reviewIndex);
            setAuthorReviewCount(getAuthorReviewCount() - 1);
            System.out.println("Author Review Removed Successfully");
        } else {
            System.out.println("Author Reviews Empty");
        }
    }

    public void displayReviews() {
        System.out.println("Author Reviews:");
        for (int i = 0; i < authorReviews.size(); i++) {
            System.out.println(authorReviews.get(i));
        }
    }

    public int getAuthorRating(Scanner sc) {
        while (true) {
            try {
                System.out.println("Enter Author Rating: ");
                authorRating = sc.nextInt();
                if (authorRating < 0 || authorRating > 10) {
                    throw new RatingException("Rating must be between 0 and 10.");

                } else {

                    return authorRating;
                }
            } catch (RatingException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
