package com.simi.studies.csjava.datastructure.lifo;

import java.util.Iterator;
import java.util.Optional;

public class FixedCapacityStack<T> implements Stack<T> {

  @Override
  public void push(T item) {

  }

  @Override
  public Optional<T> pop() {
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
