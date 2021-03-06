package com.simi.studies.csjava.datastructure.lifo;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Optional;

public class DynamicCapacityStack<T> implements Stack<T> {

  private T[] elements;
  private int totalElements;
  private final float loadFactor;

  public DynamicCapacityStack(final int initialCapacity) {
    this(initialCapacity, 0.75f);
  }

  public DynamicCapacityStack(final float loadFactor) {
    this(10, loadFactor);
  }

  public DynamicCapacityStack(final int initialCapacity, final float loadFactor) {
    if (initialCapacity < 1) {
      throw new IllegalArgumentException("Initial capacity must be greater than zero!");
    }
    if (loadFactor <= 0 || loadFactor >= 1) {
      throw new IllegalArgumentException("Load factor must be between zero and one!");
    }
    this.loadFactor = loadFactor;
    this.elements = (T[]) new Object[initialCapacity];
  }

  private void resizeArray(final float resizingFactor) {
    final var newSize = Math.round(elements.length * resizingFactor);
    final var temp = (T[]) new Object[newSize];
    for (int i = 0; i < totalElements; i++) {
      temp[i] = elements[i];
    }
    elements = temp;
  }

  @Override
  public void push(final T item) {
    increaseCapacity();
    elements[totalElements] = item;
    totalElements++;
  }

  private void increaseCapacity() {
    if (elements.length * loadFactor > totalElements) {
      resizeArray(2f);
    }
  }

  @Override
  public Optional<T> pop() {
    if (isEmpty()) {
      return Optional.empty();
    }
    totalElements--;
    final var poppedElement = elements[totalElements];
    elements[totalElements] = null;
    decreaseCapacity();
    return Optional.ofNullable(poppedElement);
  }

  private void decreaseCapacity() {
    if (elements.length * (1 - loadFactor) > totalElements) {
      resizeArray(0.5f);
    }
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
    return new DynamicCapacityStackIterator(elements, totalElements);
  }

  private class DynamicCapacityStackIterator<T> implements Iterator<T> {

    private final T[] elements;
    private int position;

    private DynamicCapacityStackIterator(final T[] elements, final int totalElements) {
      this.elements = elements;
      this.position = totalElements - 1;
    }

    @Override
    public boolean hasNext() {
      return position >= 0;
    }

    @Override
    public T next() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }
      final var element = elements[position];
      position--;
      return element;
    }

    @Override
    public void remove() {
      throw new UnsupportedOperationException("Can not remove from a Stack");
    }

  }

}
