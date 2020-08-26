package com.simi.studies.csjava.datastructure.fifo;

import java.util.Iterator;
import java.util.Optional;

public class DynamicCapacityQueue<T> implements Queue<T> {

  @Override
  public void enqueue(T item) {
  }

  @Override
  public Optional<T> dequeue() {
    return Optional.empty();
  }

  @Override
  public boolean isEmpty() {
    return true;
  }

  @Override
  public int size() {
    return 0;
  }

  @Override
  public Iterator<T> iterator() {
    return null;
  }

}
