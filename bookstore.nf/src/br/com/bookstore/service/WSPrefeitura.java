package br.com.bookstore.service;

import br.com.bookstore.model.NF;

class WSPrefeitura {

  static void emit(NF nf) {
    try {
      System.out.println("Emitindo...");
      Thread.sleep(3000);
      System.out.println("Emitido!");
    } catch(Exception e) {
      System.out.println("Falha ao emitir a nf");
    }
  }
}