package Task2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

// Подключаем расширение Mockito к тестируемому классу
@ExtendWith(MockitoExtension.class)
class BookServiceTest {
     //Создаем заглушку типа Mock для класса BookService
    @Mock
    private BookService mockBookService;
    /**
     * Тестируем поведение метода findById класса BookService
     */
    @Test
    public void testFindById() {
        /* Задаем поведение заглушки:
            когда будет вызван метод findById() с аргументом 1, данный метод должен вернуть книгу с:
            title = "Evgeniy Onegin"; author = "Pushkin";
         */
        Book expected= new Book("Onegin","Pushkin");
        when(mockBookService.findById(1)).thenReturn(expected);

        //Создаем ожидаемую строку и получаем строку  при вызове метода findBookById() класса BookService.

        String expectBook = expected.toString();
        String actualBook = mockBookService.findById(1).toString();

        // Проверяем что у заглушки один раз был вызван метод findById() с аргументом 1
        verify(mockBookService).findById(1);

        // Проверяем что ожидаемая строка равена полученной
        assertEquals(expectBook, actualBook, "Метод findBookById возвращает объект с не корректным ID");

    }

    /**
     * Проверяем поведение метода findAllBooks класса BookService
     */
    @Test
    public void testShowAll() {
    // Задаем поведение заглушки:когда будет вызван метод showAll(), данный метод должен вернуть список всех книгам
        List<Book> expectedList = new ArrayList<>(Arrays.asList(
                new Book("Evgeniy Onegin", "Pushkin"),
                new Book("WarAndPeace", "Tolstoy"),
                new Book("Neznajka", "Nosov"),
                new Book("Pinokkio","Kolodi")
                ));
        when(mockBookService.showAll()).thenReturn(expectedList);
        List<Book>actualList = mockBookService.showAll();
        // Проверяем что у заглушки один раз был вызван метод showAll()
        verify(mockBookService).showAll();
        // Проверяем что размер листа одинаковые
        assertEquals(expectedList, actualList, "ошибка в методе showAll");
    }

}
