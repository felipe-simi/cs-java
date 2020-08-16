package com.simi.studies.csjava.datastructure.lifo;

import java.util.Iterator;
import java.util.Optional;

public class SinglyLinkedStack<T> implements Stack<T> {

  @Override
  public void push(final T item) {
  }

  @Override
  public Optional<T> pop() {
    return null;
  }

  @Override
  public boolean isEmpty() {
    return true;
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
