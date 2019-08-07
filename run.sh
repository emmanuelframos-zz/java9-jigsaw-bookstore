#!/bin/bash

run(){
  java --module-path mods \
  -m bookstore.main/br.com.bookstore.Main
}

run
