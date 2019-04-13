package husarz.sample;

import io.vavr.collection.List;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

class SampleData {

    private final static AtomicLong idAuthor = new AtomicLong(0L);
    private final static AtomicLong idBook = new AtomicLong(0L);

    List<Author> authorList = List.of(
            getAuthor("gregor", "gg"),
            getAuthor("alex", "ggd")
    );

    private Book b1 = Book.builder()
            .id(getIdBook())
            .title("title2")
            .author(
                    authorList.get(0)
            )
            .build();
    private Book b2 = Book.builder()
            .id(getIdBook())
            .title("title4")
            .author(
                    authorList.get(1)
            )
            .build();
    List<Book> bookList = List.of(
            b1, b2
    );

    private Author getAuthor(String name, String surname) {
        return Author.builder()
                .id(getIdAuthor())
                .name(name)
                .surname(surname)
                .books(
                        bookList
                                .filter(b -> isEqualsNames(name, b.getAuthor().getName()))
                                .filter(b -> isEqualsNames(surname, b.getAuthor().getSurname()))
                )
                .build();
    }

    private boolean isEqualsNames(String name, String name2) {
        return Objects.equals(name2, name);
    }

    private long getIdAuthor() {
        return idAuthor.getAndAdd(1);
    }

    private long getIdBook() {
        return idBook.getAndAdd(1);
    }


}
