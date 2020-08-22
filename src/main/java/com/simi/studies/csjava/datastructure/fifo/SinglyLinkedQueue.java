package com.simi.studies.csjava.datastructure.fifo;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Optional;

public class SinglyLinkedQueue<T> implements Queue<T> {

  private Node<T> firstItem;
  private Node<T> lastItem;
  private int totalElements;

  @Override
  public void enqueue(final T item) {
    if (firstItem == null) {
      firstItem = new Node(item);
      lastItem = firstItem;
      totalElements++;
      return;
    }
    final var newNode = new Node(item);
    lastItem.nextItem = newNode;
    lastItem = newNode;
    totalElements++;
  }

  @Override
  public Optional<T> dequeue() {
    if (isEmpty()) {
      return Optional.empty();
    }
    totalElements--;
    final var item = firstItem.item;
    firstItem = firstItem.nextItem;
    return Optional.of(item);
  }

  @Override
  public boolean isEmpty() {
    return firstItem == null;
  }

  @Override
  public int size() {
    return totalElements;
  }

  @Override
  public Iterator<T> iterator() {
    return new SinglyLinkedQueueIterator(firstItem);
  }

  private static final class Node<T> {

    private T item;
    private Node<T> nextItem;

    private Node(final T item) {
      this.item = item;
    }

  }


  private class SinglyLinkedQueueIterator<T> implements Iterator<T> {

    private Node<T> currentItem;

    private SinglyLinkedQueueIterator(final Node<T> firstItem) {
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
      throw new UnsupportedOperationException("Can not remove from a Queue");
    }

  }

}
