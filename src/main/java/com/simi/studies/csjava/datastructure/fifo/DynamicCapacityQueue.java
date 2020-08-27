package com.simi.studies.csjava.datastructure.fifo;

import java.util.Iterator;
import java.util.Optional;

public class DynamicCapacityQueue<T> implements Queue<T> {

  private T[] elements;
  private int totalElements;
  private final float loadFactor;

  public DynamicCapacityQueue(final int initialCapacity) {
    this(initialCapacity, 0.75f);
  }

  public DynamicCapacityQueue(final float loadFactor) {
    this(10, loadFactor);
  }

  public DynamicCapacityQueue(final int initialCapacity, final float loadFactor) {
    this.loadFactor = loadFactor;
    this.elements = (T[]) new Object[initialCapacity];
  }

  @Override
  public void enqueue(T item) {
    if (elements.length * loadFactor > totalElements) {
      increaseCapacity();
    }
    elements[totalElements] = item;
    totalElements++;
  }

  private void increaseCapacity() {
    final var temp = (T[]) new Object[elements.length * 2];
    for (int i = 0; i < totalElements; i++) {
      temp[i] = elements[i];
    }
    elements = temp;
  }

  @Override
  public Optional<T> dequeue() {
    return Optional.empty();
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
    return null;
  }

}
