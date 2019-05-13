package BookStore;

public class Book {

    String title;
    String author;
    double price;
    boolean hardCover;
    int ISBN;
    private static int ISBNCounter = 0;
    Book[]list;

    public Book() 
    {
        title = "";
        author = "";
        price = 0.0;
        ISBNCounter++;
        ISBN = ISBNCounter;
    }
    
    public Book(String newTitle, String newAuthor, double newPrice, boolean hardCover) 
    {
        title = newTitle;
        author = newAuthor;
        price = newPrice;
        ISBNCounter++;
        ISBN = ISBNCounter;
        this.hardCover = hardCover;
    }
    
    public boolean compareTo(Book book2)
    {
        String title1 = this.getTitle().toLowerCase();
        String title2 = book2.getTitle().toLowerCase();
        boolean titles = false;
        
        for(int i =0; i < title1.length();i++)//write a for loop, compare each index, and which one is ever smaller goes first.
        {
       
            if(title2.charAt(i) > title1.charAt(i))
            {
                titles = false;
            }
            else if(title1.charAt(i) > title2.charAt(i))
            {
                titles = true;
            }
        }
        return titles;
        
    }

    public String getTitle() 
    {
        return title;
    }

    public String getAuthor() 
    {
        return author;
    }

    public double getPrice() 
    {
        return price;
    }

    public int getISBN()
    {
        return ISBN;
    }
    
    public boolean getHardCover()
    {
        return hardCover;
    }
    
    @Override
    public String toString() 
    {
        return ("Title: " + title + "\t"
                + "Author: " + getAuthor() + "\t"
                + "Price: " + price + "\t"
                + "ISBN: " + ISBN + "\t" 
                + "Hardcover: " + hardCover + "\t");

    }
    
    public boolean equals(Object o)
    {
        if(!(o instanceof Book))
            return false;
        else
        {
            Book books = (Book) o;
            if(title.equals(books.title)
            && author.equals(books.author)
            && price == books.price
            && ISBN == books.ISBN
            && hardCover == books.hardCover)
                return true;
            else
                return false;
        }
    
    
    }
}