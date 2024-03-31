package Model.Books;

import Model.Authors.RatingException;

import java.util.ArrayList;
import java.util.Scanner;


public class Books implements BookDesc {
    private static int bookCount = 0;
    private int bookID;
    private String bookName;
    private String genre;
    private String language;
    private int  price;
    private int copiesSold;
    private int book_review_count = 0;
    private int book_desc_count = 0;
    private ArrayList<String> Descriptions = new ArrayList<>();
    private ArrayList<String> BookReviews = new ArrayList<>();

    public static int getBookCount() {
        return bookCount;
    }

    public Books() {

    }

    public Books(String bookName, String genre, String language, int price, int copiesSold) {
        bookCount++;
        this.setBookID(bookCount);
        this.setBookName(bookName);
        this.setGenre(genre);
        this.setLanguage(language);
        this.setPrice(price);
        this.setCopiesSold(copiesSold);
    }

    public Books(int bookID, String bookName, String genre, String language, int price, int copiesSold) {
        this.setBookID(bookID);
        this.setBookName(bookName);
        this.setGenre(genre);
        this.setLanguage(language);
        this.setPrice(price);
        this.setCopiesSold(copiesSold);
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setCopiesSold(int copiesSold) {
        this.copiesSold=copiesSold;
    }

    public void setBook_review_count(int book_review_count) {
        this.book_review_count = book_review_count;
    }

    public void setBook_desc_count(int book_desc_count) {
        this.book_desc_count = book_desc_count;
    }

    public int getBookID() {
        return bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public String getGenre() {
        return genre;
    }

    public String getLanguage() {
        return language;
    }

    public int getPrice() {
        return price;
    }

    public int getCopiesSold() {
        return copiesSold;
    }

    public int getBook_review_count() {
        return book_review_count;
    }

    public int getBook_desc_count() {
        return book_desc_count;
    }

    public void display() {
        System.out.println("Book Id: " + getBookID());
        System.out.println("Book Name: " + getBookName());
        System.out.println("Book Language: " + getLanguage());
        System.out.println("Book Genre: " + getGenre());
        System.out.println("Book Price: " + getPrice());
        System.out.println("Book Copies Sold: " + getCopiesSold());
    }

    public void addReviewS(String reviewS) {
        System.out.println("Adding book review");
        if (getBook_review_count() < 5) {
            BookReviews.add(reviewS);
            setBook_review_count(getBook_review_count() + 1);
            System.out.println("Add book review Successfully");
        } else {
            System.out.println("5 Author Achievements Already Added. Cannot add more");
        }
    }

    public void removeReviewS(int reviewSIndex) {
        if (getBook_review_count() > 1) {
            System.out.println("Removing book review");
            BookReviews.remove(reviewSIndex);
            setBook_review_count(getBook_review_count() - 1);
            System.out.println("book review Removed Successfully");
        } else {
            System.out.println("book review Empty");
        }
    }

    public void displayReviewS() {
        System.out.println("book review :");
        for (int i = 0; i < BookReviews.size(); i++) {
            System.out.println(BookReviews.get(i));
        }
    }

    public void addDescription(String description) {
        System.out.println("Adding Book Description");
        if (getBook_desc_count() < 5) {
            Descriptions.add(description);
            setBook_desc_count(getBook_desc_count() + 1);
            System.out.println("Book Description Added Successfully");
        } else {
            System.out.println("5 Book Description Already Added. Cannot add more");
        }
    }

    public void removeDescription(int descriptionIndex) {
        if (getBook_desc_count() > 1) {
            System.out.println("Removing Book Description");
            Descriptions.remove(descriptionIndex);
            setBook_desc_count(getBook_desc_count() - 1);
            System.out.println("Book Description Removed Successfully");
        } else {
            System.out.println("Book Description Empty");
        }
    }

    public void displayDescription() {
        System.out.println("Book Description:");
        for (int i = 0; i < Descriptions.size(); i++) {
            System.out.println(Descriptions.get(i));
        }
    }


}
