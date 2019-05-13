package BookStore;

import BookStore.Book;
import java.util.ArrayList;
import java.util.Collections;

public class BookStore {

    String name;
    int Book[];
    public BookList library;
    int ISBM;

    public BookStore() 
    {
        library = new BookList();
        library.addBook(new Book("Java Servlets", "Brown", 75.99, true));
        library.addBook(new Book("Advanced HTML", "Green", 56.99, false));
        library.addBook(new Book("Advanced Java", "Green", 65.99, true));
        library.addBook(new Book("Intro to Flash", "James", 34.49, true));
        library.addBook(new Book("Intro to HTML", "James", 29.49, false));
        library.addBook(new Book("Intro to Java", "James", 56.99, true));
        library.trimToSize();
    }
    

    public String getName() 
    {
        return name;
    }

    public BookStore(ArrayList<Book> library) 
    {
        library = library;
    }

    public BookStore(BookList[] library) 
    {
        library = library;
    }

    public BookStore(String name, BookList library) 
    {
        name = name;
        library = library;
    }

    public String toString() 
    {
        String result = "";
        for (Book tempBook : library) 
        {
            result = result + tempBook.toString() + "\n";
        }
        return result;
    }

    public String lookUpAuthor(String searchString) 
    {
        String searchResult = "";
        for (Book currentBook : library) 
        {
            if (searchString == (currentBook.getTitle())) 
            {
                searchResult = currentBook.getAuthor();
            }
        }
        return "Could Not Find Book.";
    }

    public double lookUpPrice(String searchString) 
    {
        double searchResult = 0;
        for (Book currentBook : library) 
        {
            if ((currentBook.getTitle()) == searchString) 
            {
                return searchResult;
            }
        }
        return Double.NaN;

    }

    public BookList searchForTitle(String searchString) 
    {
        BookList searchResult = new BookList();
        searchString = "Java";
        for (Book currentBook : library) 
        {
            if ((currentBook.getTitle()) == (searchString)) 
            {
                searchResult.addBook(currentBook);
            }
        }
        searchResult.trimToSize();
        return searchResult;
    }

    public BookList searchForAuthor(String searchString) 
    {
        BookList searchResult = new BookList();
        for (Book currentBook : library) 
        {
            if ((currentBook.getAuthor()) == (searchString)) 
            {
                searchResult.addBook(currentBook);
            }
        }
        searchResult.trimToSize();
        return searchResult;
    }

    public BookList searchForPrice(String searchString) 
    {
        BookList searchResult = new BookList();
        double min = Double.parseDouble(searchString);
        for (Book currentBook : library) 
        {
            if (currentBook.getPrice() < min) 
            {
                searchResult.addBook(currentBook);
            }
        }
        searchResult.trimToSize();
        return searchResult;

    }

    public Book searchForISBN(int ISBN)
    {
       int indISBN = 0;
       for(int i =0; i < library.getNumberOfBooks(); i++)
       {
           int a = library.getBook(i).getISBN();
           if(a == indISBN)
           {
               return library.getBook(i); //if a, which the isbn equals the same isbn, return the book, if not, it is null.
           }
       }
       return null;
    }
       
    public Book getLowestPrice() 
    {
        return null; //if you find the lowest price, return nothing because that is the lowest price.
    }

}