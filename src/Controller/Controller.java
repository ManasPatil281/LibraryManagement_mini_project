package Controller;

import Model.Utils.Model;
import View.View;
import Model.Authors.ManageAuthors;
import View.AddBookPanel;
import View.EditAuthorPanel;
import View.DeleteAuthorPanel;
import View.EditBookPanel;
import View.DeleteBookPanel;
import Model.Books.ManageBooks;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.io.IOException;


public class Controller {
    Model model;
    View view;

    public Controller(Model m, View v)
    {
        model = m;
        view = v;

        view.getMaf().addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                view.getFf().setVisible(true);
            }
        });
        view.getMbf().addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                view.getFf().setVisible(true);
            }
        });
        view.getMpf().addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                view.getFf().setVisible(true);
            }
        });

        view.getFf().getManageAuthorBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.getFf().setVisible(false);
                view.getMaf().setVisible(true);
            }
        });
        view.getFf().getManageBooksBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.getFf().setVisible(false);
                view.getMbf().setVisible(true);
            }
        });
        view.getFf().getManagePublicationsBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.getFf().setVisible(false);
                view.getMpf().setVisible(true);
            }
        });

        model.getMs1().setLinesBeingDisplayed(20);
        view.centerInitialSetupAuthor(model.getMs1().getLinesBeingDisplayed(),model.getMs1().getHeaders().size());
        model.getMs1().setFirstLineToDisplay(0);
        view.centerUpdateAuthor(model.getMs1().getLines(model.getMs1().getFirstLineToDisplay(),model.getMs1().getLastLineToDisplay()),model.getMs1().getHeaders());

        view.getMaf().getIp().getCp().addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                int units = e.getUnitsToScroll();
                System.out.println(units);
                int current_first_line = model.getMs1().getFirstLineToDisplay();
                int current_last_line = model.getMs1().getLastLineToDisplay();
                int no_of_authors = model.getMs1().getTable().size();
                int no_of_display_lines = model.getMs1().getLinesBeingDisplayed();
                if(units <= 0 && current_first_line == 0)
                {
                    model.getMs1().setFirstLineToDisplay(0);
                }
                else if(units <= 0 && current_first_line > 0)
                {
                    int new_first_line = current_first_line + units;
                    if(new_first_line <= 0)
                    {
                        model.getMs1().setFirstLineToDisplay(0);
                    }
                    else
                    {
                        model.getMs1().setFirstLineToDisplay(new_first_line);
                    }
                }
                else if(units > 0 && current_last_line == no_of_authors-1)
                {
                    model.getMs1().setFirstLineToDisplay(current_first_line);
                }
                else if (units > 0 && current_last_line < no_of_authors-1)
                {
                    int new_first_line = current_first_line + units;
                    if(new_first_line > no_of_authors - no_of_display_lines)
                    {
                        new_first_line = no_of_authors-no_of_display_lines;
                        model.getMs1().setFirstLineToDisplay(new_first_line);
                    }
                    else
                    {
                        model.getMs1().setFirstLineToDisplay(new_first_line);
                    }
                }

                view.centerUpdateAuthor(model.getMs1().getLines(model.getMs1().getFirstLineToDisplay(), model.getMs1().getLastLineToDisplay()), model.getMs1().getHeaders());
            }
        });

        view.getMaf().getIp().getAps().getAddAuthorBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String txt_id = view.getMaf().getIp().getAps().getTxt_id().getText();
                String txt_name = view.getMaf().getIp().getAps().getTxt_name().getText();
                String txt_genre = view.getMaf().getIp().getAps().getTxt_genre().getText();
                String txt_rating = view.getMaf().getIp().getAps().getTxt_rating().getText();
                String txt_language = view.getMaf().getIp().getAps().getTxt_language().getText();
                try {
                    model.getMs1().addNewAuthor(Integer.valueOf(txt_id),txt_name,txt_genre,txt_language,Integer.valueOf(txt_rating));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        view.getMaf().getIp().getEps().getGetAuthorBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Get Authors Details Clicked");
                String txt_author_idx= view.getMaf().getIp().getEps().getTxt_get_Author_idx().getText();
                model.getMs1().readAuthorJsonFile("D://Manas_PATIL_JAVA//PCC_miniProject//src//Model//Authors//Authors1.json");
                int author_id = model.getMs1().getTable().get(Integer.valueOf(txt_author_idx)).getAuthorID();
                String author_name = model.getMs1().getTable().get(Integer.valueOf(txt_author_idx)).getAuthorName();
                String author_genre = model.getMs1().getTable().get(Integer.valueOf(txt_author_idx)).getAuthorGenre();
                int author_rating = model.getMs1().getTable().get(Integer.valueOf(txt_author_idx)).getAuthorRating();
                String author_language= model.getMs1().getTable().get(Integer.valueOf(txt_author_idx)).getAuthorLanguage();
                view.getMaf().getIp().getEps().getTxt_author_id().setText(String.valueOf(author_id));
                view.getMaf().getIp().getEps().getTxt_author_name().setText(author_name);
                view.getMaf().getIp().getEps().getTxt_author_genre().setText(author_genre);
                view.getMaf().getIp().getEps().getTxt_author_language().setText(author_language);
                view.getMaf().getIp().getEps().getTxt_author_rating().setText(String.valueOf(author_rating));
            }
        });
        view.getMaf().getIp().getEps().getEditAuthorBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Edit Authors Button Clicked");
                String txt_author_idx= view.getMaf().getIp().getEps().getTxt_get_Author_idx().getText();
                String txt_author_id = view.getMaf().getIp().getEps().getTxt_author_id().getText();
                String txt_author_name =view.getMaf().getIp().getEps().getTxt_author_name().getText();
                String txt_author_genre = view.getMaf().getIp().getEps().getTxt_author_genre().getText();
                String txt_author_rating = view.getMaf().getIp().getEps().getTxt_author_rating().getText();
                String txt_author_language=view.getMaf().getIp().getEps().getTxt_author_language().getText();
                try {
                    model.getMs1().editAuthor(Integer.valueOf(txt_author_idx),Integer.valueOf(txt_author_id),txt_author_name,txt_author_genre,Integer.valueOf(txt_author_rating),txt_author_language);
                    view.centerUpdateAuthor(model.getMs1().getLines(model.getMs1().getFirstLineToDisplay(),model.getMs1().getLastLineToDisplay()),model.getMs1().getHeaders());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }


            }
        });
        view.getMaf().getIp().getDps().getDeleteAuthorBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Delete Author Button Clicked");
                String txt_author_idx = view.getMaf().getIp().getDps().getTxt_del_author_id().getText();
                try {
                    int a_id = model.getMs1().deleteAuthor(Integer.valueOf(txt_author_idx));
                    for(int i =0; i < model.getMs1().getTable().size(); i++)
                    {
                        if (a_id == model.getMs1().getTable().get(i).getAuthorID())
                        {
                            model.getMs1().deleteAuthor(i);
                        }
                    }view.centerUpdateAuthor(model.getMs1().getLines(model.getMs1().getFirstLineToDisplay(),model.getMs1().getLastLineToDisplay()),model.getMs1().getHeaders());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        model.getMs2().setLinesBeingDisplayed(20);
        view.centerInitialSetupBook(model.getMs2().getLinesBeingDisplayed(),model.getMs2().getHeaders().size());
        model.getMs2().setFirstLineToDisplay(0);
        view.centerUpdateBook(model.getMs2().getLines(model.getMs2().getFirstLineToDisplay(),model.getMs2().getLastLineToDisplay()),model.getMs2().getHeaders());

        view.getMbf().getBipp().getBp().addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                int units = e.getUnitsToScroll();
                System.out.println(units);
                int current_first_line = model.getMs2().getFirstLineToDisplay();
                int current_last_line = model.getMs2().getLastLineToDisplay();
                int no_of_books = model.getMs2().getTable().size();
                int no_of_display_lines = model.getMs2().getLinesBeingDisplayed();
                if(units <= 0 && current_first_line == 0)
                {
                    model.getMs2().setFirstLineToDisplay(0);
                }
                else if(units <= 0 && current_first_line > 0)
                {
                    int new_first_line = current_first_line + units;
                    if(new_first_line <= 0)
                    {
                        model.getMs2().setFirstLineToDisplay(0);
                    }
                    else
                    {
                        model.getMs2().setFirstLineToDisplay(new_first_line);
                    }
                }
                else if(units > 0 && current_last_line == no_of_books-1)
                {
                    model.getMs2().setFirstLineToDisplay(current_first_line);
                }
                else if (units > 0 && current_last_line < no_of_books-1)
                {
                    int new_first_line = current_first_line + units;
                    if(new_first_line > no_of_books - no_of_display_lines)
                    {
                        new_first_line = no_of_books-no_of_display_lines;
                        model.getMs2().setFirstLineToDisplay(new_first_line);
                    }
                    else
                    {
                        model.getMs2().setFirstLineToDisplay(new_first_line);
                    }
                }

                view.centerUpdateBook(model.getMs2().getLines(model.getMs2().getFirstLineToDisplay(), model.getMs2().getLastLineToDisplay()), model.getMs2().getHeaders());
            }
        });

        view.getMbf().addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                view.getFf().setVisible(true);
            }
        });
        view.getMbf().getBipp().getBps().getAddBookBtnBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String txt_bid = view.getMbf().getBipp().getBps().getTxt_bid().getText();
                String txt_name = view.getMbf().getBipp().getBps().getTxt_name().getText();
                String txt_genre = view.getMbf().getBipp().getBps().getTxt_genre().getText();
                String txt_price = view.getMbf().getBipp().getBps().getTxt_price().getText();
                String txt_language =view.getMbf().getBipp().getBps().getTxt_language().getText();
                String txt_sales= view.getMbf().getBipp().getBps().getTxt_sales().getText();

                try {
                    model.getMs2().addNewBook(Integer.valueOf(txt_bid),txt_name,txt_genre,txt_language,Integer.valueOf(txt_price),Integer.parseInt(txt_sales));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        view.getMbf().getBipp().getEbp().getGetBookBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Get Book Details Clicked");
                String txt_book_idx= view.getMbf().getBipp().getEbp().getTxt_get_Book_idx().getText();
                model.getMs2().readBooksJsonFile("D://Manas_PATIL_JAVA//PCC_miniProject//src//Model//Books//Books.json");
                int book_id = model.getMs2().getTable().get(Integer.valueOf(txt_book_idx)).getBookID();
                String book_name = model.getMs2().getTable().get(Integer.valueOf(txt_book_idx)).getBookName();
                String book_genre = model.getMs2().getTable().get(Integer.valueOf(txt_book_idx)).getGenre();
                int book_price = model.getMs2().getTable().get(Integer.valueOf(txt_book_idx)).getPrice();
                int book_sales = model.getMs2().getTable().get(Integer.valueOf(txt_book_idx)).getCopiesSold();
                String book_language= model.getMs2().getTable().get(Integer.valueOf(txt_book_idx)).getLanguage();
                view.getMbf().getBipp().getEbp().getTxt_Book_id().setText(String.valueOf(book_id));
                view.getMbf().getBipp().getEbp().getTxt_Book_name().setText(book_name);
                view.getMbf().getBipp().getEbp().getTxt_Book_genre().setText(book_genre);
                view.getMbf().getBipp().getEbp().getTxt_Book_language().setText(book_language);
                view.getMbf().getBipp().getEbp().getTxt_Book_price().setText(String.valueOf(book_price));
                view.getMbf().getBipp().getEbp().getTxt_Book_copiesSold().setText(String.valueOf(book_sales));
            }
        });
        view.getMbf().getBipp().getEbp().getEditBookBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Edit Books Button Clicked");
                String txt_Book_idx= view.getMbf().getBipp().getEbp().getTxt_get_Book_idx().getText();
                String txt_Book_id = view.getMbf().getBipp().getEbp().getTxt_Book_id().getText();
                String txt_Book_name =view.getMbf().getBipp().getEbp().getTxt_Book_name().getText();
                String txt_Book_genre = view.getMbf().getBipp().getEbp().getTxt_Book_genre().getText();
                String txt_Book_sales = view.getMbf().getBipp().getEbp().getTxt_Book_copiesSold().getText();
                String txt_Book_language=view.getMbf().getBipp().getEbp().getTxt_Book_language().getText();
                String txt_Book_price = view.getMbf().getBipp().getEbp().getTxt_Book_price().getText();
                try {
                    model.getMs2().editBook(Integer.valueOf(txt_Book_idx),Integer.valueOf(txt_Book_id),txt_Book_name,txt_Book_genre , txt_Book_language,Integer.valueOf(txt_Book_price),Integer.valueOf(txt_Book_sales));
                    view.centerUpdateBook(model.getMs2().getLines(model.getMs2().getFirstLineToDisplay(),model.getMs2().getLastLineToDisplay()),model.getMs2().getHeaders());

                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }


            }
        });
        view.getMbf().getBipp().getDbp().getDeleteBookBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Delete Book Button Clicked");
                String txt_book_idx = view.getMbf().getBipp().getDbp().getTxt_del_book_id().getText();
                try {
                    int b_id = model.getMs2().deleteBook(Integer.valueOf(txt_book_idx));
                    for(int i =0; i < model.getMs2().getTable().size(); i++)
                    {
                        if (b_id == model.getMs2().getTable().get(i).getBookID())

                        {
                            model.getMs2().deleteBook(i);
                        }
                    } view.centerUpdateBook(model.getMs2().getLines(model.getMs2().getFirstLineToDisplay(),model.getMs2().getLastLineToDisplay()),model.getMs2().getHeaders());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        model.getMs3().setLinesBeingDisplayed(20);
        view.centerInitialSetupPubs(model.getMs3().getLinesBeingDisplayed(),model.getMs3().getHeaders().size());
        model.getMs3().setFirstLineToDisplay(0);
        view.centerUpdatePubs(model.getMs3().getLines(model.getMs3().getFirstLineToDisplay(),model.getMs3().getLastLineToDisplay()),model.getMs3().getHeaders());

        view.getMpf().getPipp().getPp().addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                int units = e.getUnitsToScroll();
                System.out.println(units);
                int current_first_line = model.getMs3().getFirstLineToDisplay();
                int current_last_line = model.getMs3().getLastLineToDisplay();
                int no_of_pubs = model.getMs3().getTable().size();
                int no_of_display_lines = model.getMs3().getLinesBeingDisplayed();
                if(units <= 0 && current_first_line == 0)
                {
                    model.getMs3().setFirstLineToDisplay(0);
                }
                else if(units <= 0 && current_first_line > 0)
                {
                    int new_first_line = current_first_line + units;
                    if(new_first_line <= 0)
                    {
                        model.getMs3().setFirstLineToDisplay(0);
                    }
                    else
                    {
                        model.getMs3().setFirstLineToDisplay(new_first_line);
                    }
                }
                else if(units > 0 && current_last_line == no_of_pubs-1)
                {
                    model.getMs3().setFirstLineToDisplay(current_first_line);
                }
                else if (units > 0 && current_last_line < no_of_pubs-1)
                {
                    int new_first_line = current_first_line + units;
                    if(new_first_line > no_of_pubs - no_of_display_lines)
                    {
                        new_first_line = no_of_pubs-no_of_display_lines;
                        model.getMs3().setFirstLineToDisplay(new_first_line);
                    }
                    else
                    {
                        model.getMs3().setFirstLineToDisplay(new_first_line);
                    }
                }

                view.centerUpdatePubs(model.getMs3().getLines(model.getMs3().getFirstLineToDisplay(), model.getMs3().getLastLineToDisplay()), model.getMs3().getHeaders());
            }
        });


      view.getMpf().getPipp().getPps().getAddPublisherBtn().addActionListener(new ActionListener() {
           @Override
         public void actionPerformed(ActionEvent e) {
             String txt_B = view.getMpf().getPipp().getPps().getTxt_B().getText();
             String txt_A = view.getMpf().getPipp().getPps().getTxt_A().getText();
             String txt_publicationDate = view.getMpf().getPipp().getPps().getTxt_publicationDate().getText();
             String txt_publisher = view.getMpf().getPipp().getPps().getTxt_publisher().getText();
             try {
                 model.getMs3().addNewPubs(Integer.valueOf(txt_A),Integer.valueOf(txt_B),txt_publicationDate,txt_publisher);
             } catch (IOException ex) {
                 throw new RuntimeException(ex);
               }
       }
       });
        view.getMpf().getPipp().getEpp().getGetPubsBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Get Publication Details Clicked");
                String txt_pubs_idx = view.getMpf().getPipp().getEpp().getTxt_get_Pubs_idx().getText();
                model.getMs3().readPublicationJsonFile("src/Model/Publications/publication.json");
                int a_id = model.getMs3().getTable().get(Integer.valueOf(txt_pubs_idx)).getA_temp().getAuthorID();
                int b_id = model.getMs3().getTable().get(Integer.valueOf(txt_pubs_idx)).getB_temp().getBookID();
                String publication_date = model.getMs3().getTable().get(Integer.valueOf(txt_pubs_idx)).getPublicationDate();
                String publisher = model.getMs3().getTable().get(Integer.valueOf(txt_pubs_idx)).getPublisher();
                view.getMpf().getPipp().getEpp().getTxt_author_id().setText(String.valueOf(a_id));
                view.getMpf().getPipp().getEpp().getTxt_book_id().setText(String.valueOf(b_id));
                view.getMpf().getPipp().getEpp().getTxt_publication_date().setText(publication_date);
                view.getMpf().getPipp().getEpp().getTxt_publisher().setText(publisher);
            }
        });

        view.getMpf().getPipp().getEpp().getEditPubsBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Edit Publication Button Clicked");
                String txt_pubs_idx = view.getMpf().getPipp().getEpp().getTxt_get_Pubs_idx().getText();
                String txt_author_idx = view.getMpf().getPipp().getEpp().getTxt_author_id().getText();
                String txt_book_idx = view.getMpf().getPipp().getEpp().getTxt_book_id().getText();
                String txt_publication_date = view.getMpf().getPipp().getEpp().getTxt_publication_date().getText();
                String txt_publisher= view.getMpf().getPipp().getEpp().getTxt_publisher().getText();
                try {
                    model.getMs3().editPubs(Integer.valueOf(txt_pubs_idx),Integer.valueOf(txt_author_idx),Integer.valueOf(txt_book_idx),txt_publication_date,txt_publisher);
                    view.centerUpdatePubs(model.getMs3().getLines(model.getMs3().getFirstLineToDisplay(),model.getMs3().getLastLineToDisplay()),model.getMs3().getHeaders());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        view.getMpf().getPipp().getDpp().getDeletePubsBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Delete Publication Button Clicked");
                String txt_pubs_idx = view.getMpf().getPipp().getDpp().getTxt_del_Pubs_idx().getText();
                try {
                    model.getMs3().deletePubs(Integer.valueOf(txt_pubs_idx));
                    view.centerUpdatePubs(model.getMs3().getLines(model.getMs3().getFirstLineToDisplay(),model.getMs3().getLastLineToDisplay()),model.getMs3().getHeaders());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

    }

}
