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

  private void decreaseCapacity() {
  }

  private void increaseCapacity() {
  }

  @Override
  public void push(T item) {
    elements[totalElements] = item;
    totalElements++;
  }

  @Override
  public Optional<T> pop() {
    return Optional.empty();
  }

  @Override
  public boolean isEmpty() {
    return totalElements == 0;
  }

  @Override
  public int size() {
    return 0;
  }

  @Override
  public Iterator<T> iterator() {
    return null;
  }
}
