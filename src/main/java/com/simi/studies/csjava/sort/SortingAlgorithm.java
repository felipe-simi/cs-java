package com.simi.studies.csjava.sort;

import java.util.Comparator;

public interface SortingAlgorithm<T extends Comparable> {

  T[] sort(T[] elements);

  T[] sort(T[] elements, Comparator comparator);

  default boolean isSmallerThan(T nextElement, T currentElement, Comparator comparator) {
    if (currentElement == null || nextElement == null) {
      throw new IllegalArgumentException("An array containing null element cannot be sorted.");
    }
    if (comparator == null) {
      return nextElement.compareTo(currentElement) < 0;
    }
    return comparator.compare(nextElement, currentElement) < 0;
  }

  default void swapElements(T[] elements, int nextElement, int currentElement) {
    T temp = elements[nextElement];
    elements[nextElement] = elements[currentElement];
    elements[currentElement] = temp;
  }

}
