package com.simi.studies.csjava.datastructure.bag;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Bag<T> implements Iterable<T> {

  private Node<T> last;
  private int totalElements;

  private static class Node<T> {
    private T element;
    private Node<T> nextElement;
  }

  public void add(final T t) {
    if (t == null) {
      throw new IllegalArgumentException("A bag element can not be null");
    }
    final var old = last;
    last = new Node();
    last.element = t;
    last.nextElement = old;
    totalElements++;
  }

  public boolean isEmpty() {
    return last == null;
  }

  public int size() {
    return totalElements;
  }

  @Override
  public Iterator<T> iterator() {
    return new BagIterator(last);
  }

  private class BagIterator implements Iterator<T> {
    private Node<T> current;

    public BagIterator(final Node<T> first) {
      current = first;
    }

    @Override
    public boolean hasNext() {
      return current != null;
    }

    @Override
    public void remove() {
      throw new UnsupportedOperationException("Can not remove from a Bag");
    }

    @Override
    public T next() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }
      final var element = current.element;
      current = current.nextElement;
      return element;
    }

  }

}
