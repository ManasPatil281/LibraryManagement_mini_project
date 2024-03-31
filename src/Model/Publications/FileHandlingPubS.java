package Model.Publications;
import Model.Authors.Authors;

import java.io.IOException;
import java.util.ArrayList;

public abstract  class FileHandlingPubS {

        protected abstract ArrayList<Publications> readPublicationJsonFile(String file_path);
        protected abstract void writePublicationJsonFile(String file_path, ArrayList<Publications> publications) throws IOException;
    }

