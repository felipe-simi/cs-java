package com.simi.studies.csjava.datastructure.bag;

public class Bag<T> {

  private Node<T> first;
  private int totalElements;

  private static class Node<T> {
    private T element;
    private Node<T> nextElement;
  }

  public void add(T t) {
    first = new Node();
    first.element = t;
    totalElements++;
  }

  public boolean isEmpty() {
    return first == null;
  }

  public int size() {
    return totalElements;
  }

}
