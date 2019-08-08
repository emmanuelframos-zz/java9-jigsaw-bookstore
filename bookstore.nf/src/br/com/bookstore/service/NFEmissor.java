package br.com.bookstore.service;

import br.com.bookstore.domain.Book;
import br.com.bookstore.model.NF;

import java.util.concurrent.SubmissionPublisher;

public class NFEmissor {

  private SubmissionPublisher<NF> publisher;

  public NFEmissor() {
    this.publisher = new SubmissionPublisher<>();
    publisher.subscribe(new NFSubscriber());
  }

  public void emit(String clientName, Book book) {
    NF nf = new NF(clientName, book.getName(), 39.99);
    publisher.submit(nf);
  }

  public void close() {
    this.publisher.close();
  }
}