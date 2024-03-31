package Model.Authors;


import Model.Authors.Authors;
import Model.Books.Books;

import java.io.IOException;
import java.util.ArrayList;

public abstract class FileHandlingAuthors {
    protected abstract ArrayList<Authors> readAuthorJsonFile(String file_path);
    protected abstract void writeAuthorJsonFile(String file_path, ArrayList<Authors> students) throws IOException;
}