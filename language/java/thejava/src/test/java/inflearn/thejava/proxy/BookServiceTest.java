package inflearn.thejava.proxy;

import org.junit.jupiter.api.Test;

class BookServiceTest {

    BookService bookService = new BookServiceProxy(new DefaultBookService());

    @Test
    void rent() {
        Book book = new Book();
        book.setTitle("spring");
        bookService.rent(book);
    }

}