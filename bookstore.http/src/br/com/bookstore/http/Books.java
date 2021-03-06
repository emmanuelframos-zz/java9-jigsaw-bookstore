package br.com.bookstore.http;

import br.com.bookstore.domain.Book;
import br.com.bookstore.domain.Category;
import jdk.incubator.http.HttpClient;
import jdk.incubator.http.HttpRequest;
import jdk.incubator.http.HttpResponse;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Books {

  public static List<Book> all() {
    try {
      HttpRequest request = HttpRequest.newBuilder()
              .uri(new URI("https://turini.github.io/livro-java-9/books.csv"))
              .GET()
              .build();

      HttpResponse.BodyHandler<String> bodyHandler = HttpResponse.BodyHandler.asString();

      String csv = HttpClient.newHttpClient()
              .send(request, bodyHandler)
              .body();

      return Stream.of(csv.split("\n"))
        .map(Books::create)
        .collect(Collectors.toList());

    } catch (Exception e) {
      throw new RuntimeException("Não foi possível conectar ", e);
    }
  }

  public static Book create(String line) {
    String[] split = line.split(",");
    String name = split[0];
    String author = split[2];
    Category category = Category.valueOf(split[3]);
    return new Book(name, author, category);
  }

  public static Optional<Book> findSimilar(Book book) {
    return Books.all().stream()
      .filter(b -> b.getCategories().equals(book.getCategories()))
      .filter(b -> !b.getAuthor().equals(book.getAuthor()))
      .findAny();
  }
}