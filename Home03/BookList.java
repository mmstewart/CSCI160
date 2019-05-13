package BookStore;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BookList implements Iterable<Book> 
{

    public Book[] list;
    public int numberOfBooks;
    private int lastPosition;

    public BookList() 
    {
        numberOfBooks = 0;
        list = new Book[10];
    }

    public BookList(Book[] booklist) 
    {
        numberOfBooks = list.length;
        list = booklist;

    }

    public int getNumberOfBooks() 
    {
        return numberOfBooks; //size of the booklist
    }

    public void addBook(Book book) 
    {
        if (numberOfBooks == list.length) //if size equals the length, we'll use ensure capcity to expand the size of the booklist
        {
            ensureCapacity();
        }
        list[numberOfBooks] = book;
        numberOfBooks++;
    }

    public void removeBook(Book book) 
    {
        int index = 0;
        for (int i = 0; i < numberOfBooks; i++) 
        {
            if (list[i].equals(book)) 
            {  
                index = i;
            } 
            else
            {
                index = -1;
            }
            
        }

        if (index >= 0 && index <= numberOfBooks) 
        {
            for (int i = index; i < numberOfBooks-1; i++) 
            {
                list[i] = list[i + 1];
            }
            
            list[index-1] = null; //last position would be null
            numberOfBooks--; //decrease the size of the array, so that the size is smaller and the null from the presvious step is gone
        }
    }

    public Book getBook(int index) 
    {
        if (index >= 0 && index <= numberOfBooks) //if index is greater than 0 and less than the list of the books, return the number you have entered for the index.
        {
            return list[index];
        } 
        else 
        {
            return null; //else return nothing
        }
    }

    public void trimToSize() 
    {
        Book temp[] = new Book[numberOfBooks];
        for (int i = 0; i < temp.length; i++) 
        {
            temp[i] = list[i];
            
        }
        list = temp;
    }

    public void ensureCapacity() 
    {
        if (numberOfBooks == list.length) 
        {
            Book temp[] = new Book[list.length + 1];
            for (int i = 0; i < temp.length; i++) 
            {
                temp[i] = list[i]; //copy list to temporary array
            }
            list = temp; //temp is moved to list
        }
    }

    public void displayList() 
    {
        String s= "";
        for (int i = 0; i <= numberOfBooks; i++) 
        {
            System.out.println(list[i]); 
        }
        
    }
    
    public String[] getSeriesOfBooks()
    {
        String[]series = new String[numberOfBooks];
        for(int i = 0; i < numberOfBooks; i++)
        {
            series[i] = list[i].toString(); //list is converted to a string and put in the series array.
        }
        return series;
    }

    public void sortList() 
    {
        boolean isntSorted = true;
        
        while(isntSorted == false) //if is isn't sorted, the last position in the array is the last position
        {
        lastPosition = list.length-1;
        Book temp;
        
        for(int i = 0; i < lastPosition; i++)
        {
            if(list[i].compareTo(list[i+1])) //if the first character in the line is greater than the second character
            {
                temp = list[i+1];    //swap books
                list[i+1] = list[i];
                list[i] = temp;
            }
            lastPosition--; 
            isntSorted = true;
            }
        }
    }
 
    @Override
    public Iterator<Book> iterator()
    {
        return new BookIterator();
    }
    

    /**
     * Private inner class to allow the use of enhanced for loop with the
     * BookList class
     *
     * You should copy this code into your BookList class. Make sure that it is
     * not inside of other methods or it will not work correctly.
     *
     * You will also need to make sure that your BookList class implements the
     * Iterable interface and uses the Book type for the type parameter
     * (implements Iterable<Book>)
     *
     * When overriding the iterator() method that you need to implement, you can
     * return an instance of the BookIterator class by calling its constructor
     * method.
     */
    private class BookIterator implements Iterator<Book> 
    {

        private int cursor;  // Index position for the current Book

        /**
         * Creates a new Iterator for this BookList
         */
        public BookIterator() 
        {
            this.cursor = 0; // Set the cursor to the front of the array
        }

        @Override
        public boolean hasNext() 
        {
            return this.cursor < numberOfBooks; // Determine if the next index position is valid
        }

        @Override
        public Book next() 
        {
            if (this.hasNext()) 
            {
                int current = cursor; // Save teh current cursor position
                cursor++;             // Move the cursor over by one
                return list[current]; // Return the Book at the old cursor position
            }
            throw new NoSuchElementException(); // Attempted to get a non-exist Book
        }

    }

}