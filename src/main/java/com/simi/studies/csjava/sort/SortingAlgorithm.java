package com.simi.studies.csjava.sort;

import java.util.Comparator;

public interface SortingAlgorithm<T extends Comparable> {

  T[] sort(T[] elements);

  T[] sort(T[] elements, Comparator comparator);

}
