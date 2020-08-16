package com.simi.studies.csjava.datastructure.lifo;

import java.util.Optional;

public interface Stack<T> extends Iterable<T> {

  void push(final T item);

  Optional<T> pop();

  boolean isEmpty();

  int size();

}