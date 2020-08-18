package com.simi.studies.csjava.datastructure.lifo;

import com.simi.studies.csjava.datastructure.CapacityExceededException;
import java.util.Iterator;
import java.util.NoSuchElementException;
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
    if (isEmpty()) {
      return Optional.empty();
    }
    totalElements--;
    final var poppedElement = elements[totalElements];
    return Optional.of(poppedElement);
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
    return new FixedCapacityStackIterator(elements, totalElements);
  }

  private class FixedCapacityStackIterator<T> implements Iterator<T> {

    private final T[] elements;
    private int position;

    private FixedCapacityStackIterator(final T[] elements, final int totalElements) {
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