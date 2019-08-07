#!/bin/bash

compile_domain() {
  echo 'Compiling [domain]'
  javac -d mods/bookstore.domain \
  --module-path mods \
  bookstore.domain/src/module-info.java \
  $(find bookstore.domain/src/br/com/bookstore -name "*.java")
  echo 'Ok [domain]'
}

compile_http(){
  echo 'Compiling [http]'
  javac -d mods/bookstore.http \
  --module-path mods \
  bookstore.http/src/module-info.java \
  $(find bookstore.http/src/br/com/bookstore -name "*.java")
  echo 'Ok [http]'
}

compile_nf(){
  echo 'Compiling [nf]'
  javac -d mods/bookstore.nf \
  --module-path mods \
  bookstore.nf/src/module-info.java \
  $(find bookstore.nf/src/br/com/bookstore -name "*.java")
  echo 'Ok [nf]'
}

compile_main(){
  echo 'Compiling [main]'
  javac -d mods/bookstore.main \
  --module-path mods \
  bookstore.main/src/module-info.java \
  $(find bookstore.main/src/br/com/bookstore -name "*.java")
  echo 'Ok [main]'
}

compile_domain
compile_http
compile_nf
compile_main

echo 'All sources compiled.'