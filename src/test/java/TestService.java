import com.alfa.model.ServiceBooks;
import com.alfa.model.entity.Book;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class TestService {
    private static ServiceBooks service;

    @BeforeClass
    public static void init() {
        service = new ServiceBooks();
        service.setBooks(Arrays.asList(
                new Book("Morozov", "Title1", "BHV", 2000, 345, 200.0),
                new Book("Shevchenko", "Title2", "Word", 2010, 1000, 760.0)));
    }

    @Test
    public void testYearOneBook() {
        List<Book> result = service.searchYear(2010);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals(2010, result.get(0).getYear());
    }

    @Test
    public void testYearManyBooks() {
        List<Book> result = service.searchYear(2000);
        Assert.assertEquals(2, result.size());
    }

    @Test
    public void testYearNoBooks() {
        List<Book> result = service.searchYear(2011);
        Assert.assertEquals(0, result.size());
    }
}
