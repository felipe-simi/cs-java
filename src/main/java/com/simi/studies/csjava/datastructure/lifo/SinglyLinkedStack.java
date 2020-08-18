package com.simi.studies.csjava.datastructure.lifo;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Optional;

public class SinglyLinkedStack<T> implements Stack<T> {

  private Node<T> topItem;
  private int totalElements;

  @Override
  public void push(final T item) {
    if (topItem == null) {
      topItem = new Node(item, null);
      totalElements++;
      return;
    }
    final var lastItem = new Node(item, topItem);
    topItem = lastItem;
    totalElements++;
  }

  @Override
  public Optional<T> pop() {
    if (isEmpty()) {
      return Optional.empty();
    }
    final var item = topItem.item;
    topItem = topItem.nextItem;
    return Optional.of(item);
  }

  @Override
  public boolean isEmpty() {
    return topItem == null;
  }

  @Override
  public int size() {
    return totalElements;
  }

  @Override
  public Iterator<T> iterator() {
    return new SinglyLinkedStackIterator(topItem);
  }

  private static final class Node<T> {

    private T item;
    private Node<T> nextItem;

    private Node(final T item, final Node<T> nextItem) {
      this.item = item;
      this.nextItem = nextItem;
    }

  }

  private class SinglyLinkedStackIterator<T> implements Iterator<T> {

    private Node<T> currentItem;

    public SinglyLinkedStackIterator(final Node<T> firstItem) {
      currentItem = firstItem;
    }

    @Override
    public boolean hasNext() {
      return currentItem != null;
    }

    @Override
    public T next() {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }
      final var item = currentItem.item;
      currentItem = currentItem.nextItem;
      return item;
    }

    @Override
    public void remove() {
      throw new UnsupportedOperationException("Can not remove from a Stack");
    }

  }

}
