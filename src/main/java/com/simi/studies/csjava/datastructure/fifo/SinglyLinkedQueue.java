package com.simi.studies.csjava.datastructure.fifo;

import java.util.Iterator;
import java.util.Optional;

public class SinglyLinkedQueue<T> implements Queue<T> {

  private Node<T> firstItem;
  private Node<T> lastItem;

  @Override
  public void enqueue(final T item) {
    if (firstItem == null) {
      firstItem = new Node(item);
      lastItem = firstItem;
      return;
    }
    final var newNode = new Node(item);
    lastItem.nextItem = newNode;
    lastItem = newNode;

  }

  @Override
  public Optional<T> dequeue() {
    return Optional.empty();
  }

  @Override
  public boolean isEmpty() {
    return firstItem == null;
  }

  @Override
  public int size() {
    return 0;
  }

  @Override
  public Iterator<T> iterator() {
    return null;
  }

  private static final class Node<T> {

    private T item;
    private Node<T> nextItem;

    private Node(final T item) {
      this.item = item;
    }

  }

}
