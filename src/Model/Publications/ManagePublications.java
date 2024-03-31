package Model.Publications;

import Model.Authors.Authors;
import Model.Authors.ManageAuthors;
import Model.Books.Books;
import Model.Books.ManageBooks;
import Model.Utils.Displayable;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ManagePublications extends FileHandlingPubS implements Displayable {
    ArrayList<Authors> authorList  = new ArrayList<Authors>();
    ArrayList<Books> bookList = new ArrayList<Books>();
    ArrayList<Publications> publicationData = new ArrayList<>();

    ObjectMapper objectMapper = new ObjectMapper();

    ArrayList<Map<String, Object>> handle_Pubs = new ArrayList<>();




    private int linesBeingDisplayed;
    private int firstLineIndex;
    int lastLineIndex;
    int highlightedLine;
    String path="src/Model/Publications/publication.json";

    public ManagePublications() {
        ManageAuthors ms1 = new ManageAuthors();
        authorList= ms1.getTable();
        ManageBooks ms2= new ManageBooks();
        bookList = ms2.getTable();
        readPublicationJsonFile(path);
    }

    public ArrayList<Publications> readPublicationJsonFile(String file_path) {
        publicationData.removeAll(publicationData);
        try {

            JsonNode rootNode = objectMapper.readTree(new File(file_path));

            // Iterate through JSON array
            if (rootNode.isArray()) {
                for (JsonNode node : rootNode) {
                    int a_temp = node.get("a_temp").asInt();
                    Authors a_temp_obj = new Authors();
                    for(Authors author:  authorList){
                        if(a_temp==author.getAuthorID()){
                            a_temp_obj=author;
                        }
                    }
                    int b_temp = node.get("b_temp").asInt();
                    Books b_temp_obj = new Books();
                    for(Books book:bookList){
                        if(b_temp==book.getBookID()){
                            b_temp_obj=book;
                        }
                    }
                    String publicationDate = node.get("publicationDate").asText();
                    String publisher = node.get("publisher").asText();
                    publicationData.add(new Publications(a_temp_obj,b_temp_obj,publicationDate,publisher));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return publicationData;
    }



    public void writePublicationJsonFile(String file_path, ArrayList<Publications> publicationData) throws IOException {

        ArrayList<Map<String, Object>> publication_to_be_written = new ArrayList<>();

        for(int i = 0; i < publicationData.size(); i++)
        {    HashMap<String, Object> data = new HashMap<>();
            data.put("a_temp",publicationData.get(i).getA_temp().getAuthorID());
            data.put("b_temp",publicationData.get(i).getB_temp().getBookID());
            data.put("publicationDate",publicationData.get(i).getPublicationDate());
            data.put("publisher",publicationData.get(i).getPublisher());


            publication_to_be_written.add(data);
        }

        objectMapper.writeValue(Paths.get(file_path).toFile(), publication_to_be_written);
    }

    // Implement other methods as needed for managing publications, similar to ManageEnrolls class

    public ArrayList<String> getHeaders() {
        ArrayList<String> headers = new ArrayList<String>();
        headers.add("Author ID");
        headers.add("Book ID");
        headers.add("Publication Date");
        headers.add("Publisher");

        return headers;
    }


    @Override
    public ArrayList<String> getLine(int line) {
        ArrayList<String> Pubs_details = new ArrayList<String>();

        Pubs_details.add(String.valueOf(publicationData.get(line).getA_temp().getAuthorID()));
        Pubs_details.add(String.valueOf(publicationData.get(line).getB_temp().getBookID()));
        Pubs_details.add(publicationData.get(line).getPublicationDate());
        Pubs_details.add(publicationData.get(line).getPublisher());

        return Pubs_details;
    }

    @Override
    public ArrayList<ArrayList<String>> getLines(int firstLine, int lastLine) {
        ArrayList<ArrayList<String>> pubs_subset = new ArrayList<ArrayList<String>>();

        for (int i = firstLine; i <= lastLine; i++) {
            pubs_subset.add(this.getLine(i));
        }
        return pubs_subset;
    }

    @Override
    public int getFirstLineToDisplay() {
        return this.firstLineIndex;
    }

    @Override
    public int getLineToHighlight() {
        return this.highlightedLine;
    }

    @Override
    public int getLastLineToDisplay() {
        setLastLineToDisplay(this.firstLineIndex + this.linesBeingDisplayed - 1);
        return this.lastLineIndex;
    }

    @Override
    public int getLinesBeingDisplayed() {
        return this.linesBeingDisplayed;
    }

    @Override
    public void setFirstLineToDisplay(int firstLine) {
        this.firstLineIndex = firstLine;
    }

    @Override
    public void setLineToHighlight(int highlightedLine) {

    }

    @Override
    public void setLastLineToDisplay(int lastLine) {
        this.lastLineIndex = lastLine;

    }

    @Override
    public void setLinesBeingDisplayed(int numberOfLines) {
        this.linesBeingDisplayed = numberOfLines;

    }

    // Implement other Displayable interface methods

    public ArrayList<Publications> getTable() {
        return this.publicationData;
    }
    public void addNewPubs( int authorID,int bookID,String publicationDate, String publisher) throws IOException {
        readPublicationJsonFile("src/Model/Publications/publication.json");
        Publications temp_Pubs = new Publications(authorList.get(authorID),bookList.get(bookID), publicationDate,  publisher);
        publicationData.add(temp_Pubs);
        writePublicationJsonFile("src/Model/Publications/publication.json",publicationData);

    }
    public void editPubs(int edit_pubs_idx, int author_id, int book_id, String publication_date,String publisher) throws IOException {
        readPublicationJsonFile("src/Model/Publications/publication.json");
        publicationData.get(edit_pubs_idx).setPublicationDate(publication_date);
        publicationData.get(edit_pubs_idx).setPublisher(publisher);
        publicationData.get(edit_pubs_idx).setA_temp(authorList.get(author_id));
        publicationData.get(edit_pubs_idx).setB_temp(bookList.get(book_id));
        writePublicationJsonFile("src/Model/Publications/publication.json",publicationData);
    }

    public void deletePubs(int delete_pubs_idx) throws IOException {
        readPublicationJsonFile("src/Model/Publications/publication.json");
        publicationData.remove(delete_pubs_idx);
        writePublicationJsonFile("src/Model/Publications/publication.json",publicationData);
    }

}
