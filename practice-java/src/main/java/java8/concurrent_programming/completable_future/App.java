package java8.concurrent_programming.completable_future;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class App {
    public static void main(String[] args) {

        String url = "http://www.test.com";



    }

    private static void pipeline(String url) {
        CompletableFuture<String> contents = CompletableFuture
                .supplyAsync(() -> blockingReadPage(url));

        CompletableFuture<List<URL>> links = CompletableFuture
                .supplyAsync(() -> blockingReadPage(url))
                .thenApply(Parser::getLinks);

        CompletableFuture<Void> printLinks = CompletableFuture
                .supplyAsync(() -> blockingReadPage(url))
                .thenApply(Parser::getLinks)
                .thenAccept(System.out::println);
    }

    private static void composability(String url) {
        CompletableFuture<String> contents = readPage(url);
        CompletableFuture<List<URL>> links = contents.thenApply(Parser::getLinks);
    }

    private static CompletableFuture<String> readPage(String url) {
        CompletableFuture<String> result = new CompletableFuture<>();
        // 로직
        return result;
    }

    private static String blockingReadPage(String url) {
        return "result";
    }

    static class Parser {

        public static List<URL> getLinks(String contents) {
            List<URL> result = new ArrayList<>();
            // 로직
            return result;
        }
    }

}
