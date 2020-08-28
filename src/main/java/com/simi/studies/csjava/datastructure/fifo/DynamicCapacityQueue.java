package com.simi.studies.csjava.datastructure.fifo;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Optional;

public class DynamicCapacityQueue<T> implements Queue<T> {

  private T[] elements;
  private int totalElements;
  private final float loadFactor;

  public DynamicCapacityQueue(final int initialCapacity) {
    this(initialCapacity, 0.75f);
  }

  public DynamicCapacityQueue(final float loadFactor) {
    this(10, loadFactor);
  }

  public DynamicCapacityQueue(final int initialCapacity, final float loadFactor) {
    this.loadFactor = loadFactor;
    this.elements = (T[]) new Object[initialCapacity];
  }

  @Override
  public void enqueue(T item) {
    if (elements.length * loadFactor > totalElements) {
      increaseCapacity();
    }
    elements[totalElements] = item;
    totalElements++;
  }

  private void increaseCapacity() {
    final var temp = (T[]) new Object[elements.length * 2];
    for (int i = 0; i < totalElements; i++) {
      temp[i] = elements[i];
    }
    elements = temp;
  }

  @Override
  public Optional<T> dequeue() {
    if (isEmpty()) {
      return Optional.empty();
    }
    final var item = elements[0];
    elements[0] = null;
    decreaseCapacity();
    totalElements--;
    return Optional.of(item);
  }

  private void decreaseCapacity() {
    var newSize = elements.length;
    if (elements.length * (1 - loadFactor) > totalElements) {
      newSize = Math.round(elements.length * 0.5f);
    }
    final var temp = (T[]) new Object[newSize];
    for (int i = 1; i < totalElements; i++) {
      temp[i - 1] = elements[i];
    }
    elements = temp;
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
    return new DynamicCapacityQueueIterator(elements, totalElements);
  }

  private class DynamicCapacityQueueIterator<T> implements Iterator<T> {

    private final T[] elements;
    private final int totalElements;
    private int position;

    private DynamicCapacityQueueIterator(final T[] elements, final int totalElements) {
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
