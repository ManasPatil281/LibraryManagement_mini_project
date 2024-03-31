package Model.Books;

import Model.Authors.Authors;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


import Model.Utils.Displayable;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
public class ManageBooks extends FileHandlingBooks implements Displayable { // Corrected class name

    ArrayList<Books> bookList = new ArrayList<Books>();

    ObjectMapper objectMapper = new ObjectMapper();

    private int linesBeingDisplayed;
    private int firstLineIndex;
    private int lastLineIndex;
    private int highlightedLine;

    public ManageBooks() {
        readBooksJsonFile("src/Model/Books/MOCK_DATA(3).json");
    }


    public ArrayList<Books> readBooksJsonFile(String file_path) {
        try {
            bookList.removeAll(bookList);
            JsonNode rootNode = objectMapper.readTree(new File(file_path));

            // Iterate through JSON array
            if (rootNode.isArray()) {
                for (JsonNode node : rootNode) {
                    int book_id = node.get("bookID").asInt();
                    String name = node.get("bookName").asText();
                    String genre = node.get("genre").asText();
                    String language = node.get("language").asText();
                    int price = node.get("price").asInt();
                    int copies_sold = node.get("copiesSold").asInt();

                    // Populate other attributes as needed
                    Books book = new Books(book_id, name, genre, language, price, copies_sold);
                    bookList.add(book);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bookList;
    }

    public void writeBooksJsonFile(String file_path, ArrayList<Books> books) throws IOException {
        objectMapper.writeValue(Paths.get(file_path).toFile(), books);
    }

    public void setBooksTable(ArrayList<Books> bookList) {
        this.bookList = bookList;
    }

    public ArrayList<String> getHeaders() {
        ArrayList<String> headers = new ArrayList<String>();
        headers.add("Book ID");
        headers.add("Name");
        headers.add("Genre");
        headers.add("Language");
        headers.add("price");
        headers.add("copies sold");

        // Add headers for other attributes as needed
        return headers;
    }

    @Override
    public ArrayList<String> getLine(int line) {
        ArrayList<String> BookDetails = new ArrayList<String>();

        BookDetails.add(String.valueOf(bookList.get(line).getBookID()));
        BookDetails.add(bookList.get(line).getBookName());
        BookDetails.add(bookList.get(line).getGenre());
        BookDetails.add(bookList.get(line).getLanguage());
        BookDetails.add(String.valueOf(bookList.get(line).getPrice()));
        BookDetails.add(String.valueOf(bookList.get(line).getCopiesSold()));
        // Add other attributes as needed
        return BookDetails;
    }

    @Override
    public ArrayList<ArrayList<String>> getLines(int firstLine, int lastLine) {
        ArrayList<ArrayList<String>> booksSubset = new ArrayList<ArrayList<String>>();
        for (int i = firstLine; i <= lastLine; i++) {
            booksSubset.add(getLine(i));
        }
        return booksSubset;
    }

    @Override
    public int getFirstLineToDisplay() {
        return firstLineIndex;
    }

    @Override
    public int getLineToHighlight() {
        return highlightedLine;
    }

    @Override
    public int getLastLineToDisplay() {
        setLastLineToDisplay(getFirstLineToDisplay() + getLinesBeingDisplayed() - 1);
        return lastLineIndex;
    }

    @Override
    public int getLinesBeingDisplayed() {
        return linesBeingDisplayed;
    }

    @Override
    public void setFirstLineToDisplay(int firstLine) {
        this.firstLineIndex = firstLine;
    }

    @Override
    public void setLineToHighlight(int highlightedLine) {
        this.highlightedLine = highlightedLine;
    }

    @Override
    public void setLastLineToDisplay(int lastLine) {
        this.lastLineIndex = lastLine;
    }

    @Override
    public void setLinesBeingDisplayed(int numberOfLines) {
        this.linesBeingDisplayed = numberOfLines;
    }

    public ArrayList<Books> getTable() {
        readBooksJsonFile("src/Model/Books/MOCK_DATA(3).json");
        return bookList;
    }

    public void addNewBook(int bookID, String bookName, String genre, String language, int price, int copiesSold) throws IOException {
        readBooksJsonFile("src/Model/Books/MOCK_DATA(3).json");
        Books temp_book = new Books(bookID, bookName, genre, language, price, copiesSold);
        bookList.add(temp_book);
        writeBooksJsonFile("src/Model/Books/MOCK_DATA(3).json", bookList);

    }

    public void editBook(int edit_book_idx, int book_id, String book_name, String book_genre, String book_language, int price, int copiesSold) throws IOException {
        readBooksJsonFile("src/Model/Books/MOCK_DATA(3).json");
        bookList.get(edit_book_idx).setBookID(book_id);
        bookList.get(edit_book_idx).setBookName(book_name);
        bookList.get(edit_book_idx).setGenre(book_genre);
        bookList.get(edit_book_idx).setLanguage(book_language);
        bookList.get(edit_book_idx).setPrice(price);
        bookList.get(edit_book_idx).setCopiesSold(copiesSold);
        writeBooksJsonFile("src/Model/Books/MOCK_DATA(3).json", bookList);
    }

    public int deleteBook(int delete_book_idx) throws IOException {
        readBooksJsonFile("src/Model/Books/MOCK_DATA(3).json");
        bookList.remove(delete_book_idx);
        int b_id = bookList.get(delete_book_idx).getBookID();
        writeBooksJsonFile("src/Model/Books/MOCK_DATA(3).json", bookList);
        return b_id;
    }


}

