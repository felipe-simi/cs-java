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
    if (comparator == null) {
      throw new IllegalArgumentException("Cannot sort an array using a null comparator.");
    }
    return Arrays.copyOf(elements, elements.length);
  }

}
