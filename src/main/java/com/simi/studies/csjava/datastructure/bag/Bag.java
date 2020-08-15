package com.simi.studies.csjava.datastructure.bag;

public class Bag<T> {

  private Node<T> first;

  private static class Node<T> {
    private T element;
    private Node<T> nextElement;
  }

  public void add(T t) {
    first = new Node();
    first.element = t;
  }

  public boolean isEmpty() {
    return first == null;
  }

}
