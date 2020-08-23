package com.simi.studies.csjava.datastructure.fifo;

import com.simi.studies.csjava.datastructure.CapacityExceededException;
import java.util.Iterator;
import java.util.NoSuchElementException;
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
    if (isEmpty()) {
      return Optional.empty();
    }
    final var item = elements[0];
    final var temp = (T[]) new Object[elements.length];
    for (int i = 1; i < totalElements; i++) {
      temp[i - 1] = elements[i];
    }
    totalElements--;
    elements = temp;
    return Optional.of(item);
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
    return new FixedCapacityQueueIterator<>(elements, totalElements);
  }

  private class FixedCapacityQueueIterator<T> implements Iterator<T> {

    private final T[] elements;
    private final int totalElements;
    private int position;

    private FixedCapacityQueueIterator(final T[] elements, final int totalElements) {
      this.elements = elements;
      this.totalElements = totalElements;
    }

    @Override
    public boolean hasNext() {
      return position < totalElements;
    }

    @Override
    public T next() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }
      final var element = elements[position];
      position++;
      return element;
    }

    @Override
    public void remove() {
      throw new UnsupportedOperationException("Can not remove from a Queue");
    }

  }

}
