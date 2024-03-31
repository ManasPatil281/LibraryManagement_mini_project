package Model.Authors;

public interface AuthDesc {

    public interface AuthorDesc {
        void addAchievement(String achievement);
        void removeAchievement(int achievementIndex);
        void displayAchievements();
        void addReview(String reviewerName, int rating, String comment);
        void removeReview(int reviewIndex);
        void displayReviews();
    }

}
