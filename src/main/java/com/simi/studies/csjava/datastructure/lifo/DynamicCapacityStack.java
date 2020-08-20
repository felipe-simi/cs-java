package com.simi.studies.csjava.datastructure.lifo;

import java.util.Iterator;
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
    return Optional.of(poppedElement);
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
    return null;
  }
}
