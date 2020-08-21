package com.simi.studies.csjava.datastructure.fifo;

import java.util.Optional;

public interface Queue<T> extends Iterable<T> {

  void enqueue(final T item);

  Optional<T> dequeue();

  boolean isEmpty();

  int size();

}
