package com.simi.studies.csjava.datastructure.lifo;

import java.util.Iterator;
import java.util.Optional;

public class SinglyLinkedStack<T> implements Stack<T> {

  private Node<T> topItem;

  @Override
  public void push(final T item) {
    if (topItem == null) {
      topItem = new Node(item, null);
      return;
    }
    final var lastItem = new Node(item, topItem);
    topItem = lastItem;
  }

  @Override
  public Optional<T> pop() {
    return null;
  }

  @Override
  public boolean isEmpty() {
    return topItem == null;
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

    private Node(final T item, final Node<T> nextItem) {
      this.item = item;
      this.nextItem = nextItem;
    }

  }

}
