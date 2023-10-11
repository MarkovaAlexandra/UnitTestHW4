package Task2;

import java.util.List;

public interface BookRepository {
    Book findById(int id);
    List<Book> showAll();


}
