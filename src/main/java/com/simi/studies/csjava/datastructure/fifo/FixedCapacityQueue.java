package com.simi.studies.csjava.datastructure.fifo;

import com.simi.studies.csjava.datastructure.CapacityExceededException;
import java.util.Iterator;
import java.util.Optional;

public class FixedCapacityQueue<T> implements Queue<T> {

  private T[] elements;
  private int totalElements;

  public FixedCapacityQueue(int maxCapacity) {
    if (maxCapacity < 1) {
      throw new IllegalArgumentException("Maximum capacity must be greater than zero!");
    }
    elements = (T[]) new Object[maxCapacity];
  }

  @Override
  public void enqueue(T item) {
    if (totalElements == elements.length) {
      throw new CapacityExceededException("It is not allowed to enqueue into a full queue.");
    }
    elements[totalElements] = item;
    totalElements++;
  }

  @Override
  public Optional<T> dequeue() {
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
