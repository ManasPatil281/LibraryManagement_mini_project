package Model.Books;


import Model.Authors.Authors;
import Model.Books.Books;

import java.io.IOException;
import java.util.ArrayList;

public abstract class FileHandlingBooks{
    protected abstract ArrayList<Books> readBooksJsonFile(String file_path);
    protected abstract void writeBooksJsonFile(String file_path, ArrayList<Books> booklist) throws IOException;
}