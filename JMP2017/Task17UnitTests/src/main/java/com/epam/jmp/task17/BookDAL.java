package com.epam.jmp.task17;

/**
 * Created by Gleb88 on 27.05.2017.
 */
import java.util.Collections;
import java.util.List;

public class BookDAL {

    private static BookDAL bookDAL = new BookDAL();

    public List<Book> getAllBooks(){
        return Collections.EMPTY_LIST;
    }

    public Book getBook(String isbn){
        return null;
    }

    public String addBook(Book book){
        return book.getIsbn();
    }

    public String updateBook(Book book){
        return book.getIsbn();
    }

    public static BookDAL getInstance(){
        return bookDAL;
    }
}
