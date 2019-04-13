package husarz.sample;

import io.vavr.collection.List;
import lombok.Builder;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

@Slf4j
public class JavaAppTest extends SampleData {


    @Before
    public void before() {

    }

    @Test
    public void firstTest() {



    }


    @After
    public void after() {

    }
}

@Value
@Builder(toBuilder = true)
class Author {
    private Long id;

    private String name;
    private String surname;

    private List<Book> books;
}

@Value
@Builder(toBuilder = true)
class Book {
    private Long id;

    private String title;
    private Author author;
}