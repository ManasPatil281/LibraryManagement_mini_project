import Controller.Controller;
import Model.Authors.*;
import Model.Books.*;
import Model.Utils.*;
import Model.Publications.*;
import View.View;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) throws IOException {
        View view = new View();
         Model model = new Model();
        Controller controller = new Controller(model, view);
    }
}