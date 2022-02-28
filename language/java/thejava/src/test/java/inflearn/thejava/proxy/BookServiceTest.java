package inflearn.thejava.proxy;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class BookServiceTest {

    // Class 기반의 다이나믹 프록시는 생성할 수 없다.
    // Interface 기반의 다이나믹 프록시만 생성할 수 있다.
    BookService bookService = (BookService) Proxy.newProxyInstance(
            BookService.class.getClassLoader(),
            new Class[]{BookService.class},
            new InvocationHandler() {
                BookService bookService = new DefaultBookService();

                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    if (method.getName().equals("rent")) {
                        System.out.println("=== proxy: aaaa");
                        Object invoke = method.invoke(bookService, args);
                        System.out.println("=== proxy: bbbb");
                        return invoke;
                    }

                    return method.invoke(bookService, args);
                }
            });

    @Test
    void rent() {
        Book book = new Book();
        book.setTitle("spring");
        bookService.rent(book);
        bookService.returnBook(book);
    }

}