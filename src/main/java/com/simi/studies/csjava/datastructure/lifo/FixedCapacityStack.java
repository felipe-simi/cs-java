package com.simi.studies.csjava.datastructure.lifo;

import com.simi.studies.csjava.datastructure.CapacityExceededException;
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
    if (totalElements == elements.length) {
      throw new CapacityExceededException("It is not allowed to push into a full stack.");
    }
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
    return totalElements;
  }

  @Override
  public Iterator<T> iterator() {
    return null;
  }
}