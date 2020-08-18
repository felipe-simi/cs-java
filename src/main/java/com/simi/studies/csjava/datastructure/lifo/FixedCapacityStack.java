package com.simi.studies.csjava.datastructure.lifo;

import java.util.Iterator;
import java.util.Optional;

public class FixedCapacityStack<T> implements Stack<T> {

  private T[] elements;
  private int totalElements;

  public FixedCapacityStack(int maxCapacity) {
    elements = (T[]) new Object[maxCapacity];
  }

  @Override
  public void push(T item) {
    elements[totalElements] = item;
    totalElements++;
  }

  @Override
  public Optional<T> pop() {
    return Optional.empty();
  }

  @Override
  public boolean isEmpty() {
    return totalElements == 0;
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