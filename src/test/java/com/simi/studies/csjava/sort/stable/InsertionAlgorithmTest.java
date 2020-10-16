package com.simi.studies.csjava.sort.stable;

import com.simi.studies.csjava.sort.SortingAlgorithm;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InsertionAlgorithmTest {

  private SortingAlgorithm<Integer> insertionSort = new InsertionSort();
  private Integer[] unsorted;
  private Integer[] unsortedClone;
  private Integer[] sorted;

  @BeforeEach
  public void refresh() {
    unsorted = new Integer[] {3, 4, 2, 1, 2};
    unsortedClone = new Integer[] {3, 4, 2, 1, 2};
    sorted = new Integer[] {1, 2, 2, 3, 4};
  }

  @Test
  void givenEmptyArray_whenSortingElements_thenShouldBeEmpty() {
    final var emptyArray = new Integer[0];
    final var sortedArray = insertionSort.sort(emptyArray);
    Assertions.assertAll("Testing no side effects in original array",
        () -> Assertions.assertTrue(sortedArray.length == 0),
        () -> Assertions.assertNotEquals(emptyArray, sortedArray));
  }

  @Test
  void givenNullComparator_whenSortingElements_thenIllegalArgumentException() {
    Assertions.assertThrows(IllegalArgumentException.class,
        () -> insertionSort.sort(new Integer[0], null));
  }

}