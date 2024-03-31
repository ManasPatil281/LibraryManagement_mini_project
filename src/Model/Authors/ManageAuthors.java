package Model.Authors;

import Model.Utils.Displayable;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


import javax.management.StringValueExp;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ManageAuthors extends FileHandlingAuthors implements Displayable {

    ArrayList<Authors> authorlist = new ArrayList<Authors>();

    ObjectMapper objectMapper = new ObjectMapper();

    private int linesBeingDisplayed;
    private int firstLineIndex;
    private int lastLineIndex;
    private int highlightedLine;
    public ManageAuthors(){
        readAuthorJsonFile("src/Model/Authors/MOCK_DATA(2).json");
    }



    public ArrayList<Authors> readAuthorJsonFile(String file_path)
    {
        try {
            authorlist.removeAll(authorlist);
            JsonNode rootNode = objectMapper.readTree(new File(file_path));

            // Iterate through JSON array
            if (rootNode.isArray()) {
                for (JsonNode node : rootNode) {
                    int author_id = node.get("authorID").asInt();
                    String name = node.get("authorName").asText();
                    String genre = node.get("authorGenre").asText();
                    int rating = node.get("authorRating").asInt();
                    String language = node.get("authorLanguage").asText();
                    // Populate other attributes as needed
                    Authors author = new Authors(author_id, name, genre,  language,rating);
                    authorlist.add(author);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return authorlist;
    }

    public void writeAuthorJsonFile(String file_path, ArrayList<Authors> authorlist) throws IOException {
        objectMapper.writeValue(Paths.get(file_path).toFile(), authorlist);
    }

    public void setAuthorsTable(ArrayList<Authors> authorlist) {
        this.authorlist = authorlist;
    }

    public ArrayList<String> getHeaders() {
        ArrayList<String> headers = new ArrayList<String>();
        headers.add("Author ID");
        headers.add("Name");
        headers.add("Genre");
        headers.add("Rating");
        headers.add("Language");
        // Add headers for other attributes as needed
        return headers;
    }

    @Override
    public ArrayList<String> getLine(int line) {
        ArrayList<String> authorDetails = new ArrayList<String>();

         authorDetails.add(String.valueOf(authorlist.get(line).getAuthorID()));
        authorDetails.add(authorlist.get(line).getAuthorName());
        authorDetails.add(authorlist.get(line).getAuthorGenre());
        authorDetails.add(String.valueOf(authorlist.get(line).getAuthorRating()));
        authorDetails.add(authorlist.get(line).getAuthorLanguage());
        // Add other attributes as needed
        return authorDetails;
    }

    @Override
    public ArrayList<ArrayList<String>> getLines(int firstLine, int lastLine) {
        ArrayList<ArrayList<String>> authorsSubset = new ArrayList<ArrayList<String>>();
        for (int i = firstLine; i <= lastLine; i++) {
            authorsSubset.add(getLine(i));
        }
        return authorsSubset;
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

    public ArrayList<Authors> getTable() {
        readAuthorJsonFile("src/Model/Authors/MOCK_DATA(2).json");
        return authorlist;
    }
    public void addNewAuthor(int authorID ,String authorName, String authorGenre,  String authorLanguage,int authorRating) throws IOException {
        readAuthorJsonFile("src/Model/Authors/MOCK_DATA(2).json");
        Authors temp_Aut = new Authors( authorID, authorName, authorGenre,   authorLanguage,authorRating);
        authorlist.add(temp_Aut);
        writeAuthorJsonFile("src/Model/Authors/MOCK_DATA(2).json",authorlist);

    }
    public void editAuthor(int edit_author_idx, int author_id, String author_name,  String author_genre, int  author_rating,String author_language ) throws IOException {
        readAuthorJsonFile("src/Model/Authors/MOCK_DATA(2).json");
        authorlist.get(edit_author_idx).setAuthorID(author_id);
        authorlist.get(edit_author_idx).setAuthorName(author_name);
        authorlist.get(edit_author_idx).setAuthorGenre(author_genre);
        authorlist.get(edit_author_idx).setAuthorRating(author_rating);
        authorlist.get(edit_author_idx).setAuthorLanguage(author_language);
        writeAuthorJsonFile("src/Model/Authors/MOCK_DATA(2).json",authorlist);
    }
    public int deleteAuthor(int delete_author_idx) throws IOException {
        readAuthorJsonFile("src/Model/Authors/MOCK_DATA(2).json");
        authorlist.remove(delete_author_idx);
        int a_id = authorlist.get(delete_author_idx).getAuthorID();
        writeAuthorJsonFile("src/Model/Authors/MOCK_DATA(2).json",authorlist);
        return a_id;
    }

}

