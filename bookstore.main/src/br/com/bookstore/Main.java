package br.com.bookstore;

import br.com.bookstore.http.Books;
import br.com.bookstore.domain.Book;
import br.com.bookstore.service.NFEmissor;

import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class Main {

    private static Consumer<Book> showSimilar = similar -> System.out.println("Talvez você também goste do livro: " + similar.getName());

    private static Runnable noSuggestions = () -> System.out.println("Não temos nenhuma sugestão de livro similar no momento");

    public static void main(String...args) {

        System.out.println("Lista de livros disponíveis ");

        List<Book> books = Books.all();

        IntStream.range(0, books.size())
                .forEach(i -> {
                    System.out.println(i + " - " + books.get(i).getName());
                });

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o numero do livro que quer comprar: ");

        try {
            int number = scanner.nextInt();
            Book book = books.get(number);

            System.out.println("O livro escolhido foi: " + book.getName());

            System.out.println("Informe seu nome, para que possamos emitir a nota fiscal: ");

            scanner = new Scanner(System.in);
            String name = scanner.nextLine();
            NFEmissor emissor = new NFEmissor();
            emissor.emit(name, book);

            System.out.println("Obrigado!");

            Books.findSimilar(book)
                    .ifPresentOrElse(showSimilar, noSuggestions);

            // segura a execução para o código assíncrono terminar
            System.out.println("Aperte o enter para sair");
            new Scanner(System.in).nextLine();

            emissor.close();

        } catch(Exception e) {
            System.out.println("Ops, aconteceu um erro: ");
        }
    }
}