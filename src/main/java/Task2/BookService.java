package Task2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookService implements BookRepository{

    public Map<Integer, Book> books;
    public BookService(){
        this.books = new HashMap<>();
        books.putIfAbsent(1, book1);
        books.putIfAbsent(2, book2);
        books.putIfAbsent(3, book3);
        books.putIfAbsent(4,new Book("Pinokkio","Kolodi"));

    }
    Book book1 = new Book("Onegin", "Pushkin");
    Book book2 = new Book( "WarAndPeace", "Tolstoy");
    Book book3 = new Book(  "Neznajka", "Nosov");


    @Override
    public Book findById(int id) {

        return books.get(id);
    }

    @Override
    public List<Book> showAll() {
        return new ArrayList<>(books.values());
    }


    //тут просто тестирую функционал
    public static void main(String[] args) {
        BookService library = new BookService();
        List<Book> resultList = library.showAll();
        System.out.println(resultList);
        Book result = library.findById(1);
        System.out.println(result);
    }

}
