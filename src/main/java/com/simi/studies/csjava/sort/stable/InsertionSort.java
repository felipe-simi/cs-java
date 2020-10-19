package com.simi.studies.csjava.sort.stable;

import com.simi.studies.csjava.sort.SortingAlgorithm;
import java.util.Arrays;
import java.util.Comparator;

public final class InsertionSort<T extends Comparable> implements SortingAlgorithm<T> {

  @Override
  public T[] sort(final T[] elements) {
    return sort(elements, Comparator.naturalOrder());
  }

  @Override
  public T[] sort(final T[] elements, final Comparator comparator) {
    validateInput(elements, comparator);
    final var elementsSize = elements.length;
    final var sortingArray = Arrays.copyOf(elements, elements.length);
    for (int i = 1; i < elementsSize; i++) {
      for (int j = i; hasToSwap(sortingArray, comparator, j); j--) {
        swapElements(sortingArray, j, j - 1);
      }
    }
    return sortingArray;
  }

  private boolean hasToSwap(final T[] sortingArray, final Comparator comparator, int j) {
    return (j > 0 && isSmallerThan(sortingArray[j], sortingArray[j - 1], comparator));
  }

  private void validateInput(final T[] elements, final Comparator comparator) {
    if (comparator == null) {
      throw new IllegalArgumentException("Cannot sort an array using a null comparator.");
    }
    if (elements == null) {
      throw new IllegalArgumentException("Cannot sort a null array.");
    }
  }

}
