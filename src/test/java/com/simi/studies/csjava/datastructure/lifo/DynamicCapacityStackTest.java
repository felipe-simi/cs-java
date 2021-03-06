package com.simi.studies.csjava.datastructure.lifo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.NoSuchElementException;

class DynamicCapacityStackTest {

  @Test
  void givenInvalidCapacity_whenCreatingStack_thenThrowException() {
    Assertions.assertThrows(IllegalArgumentException.class,
        () -> new DynamicCapacityStack<String>(0));
  }

  @Test
  void givenLoadFactorGreaterThanOne_whenCreatingStack_thenThrowException() {
    Assertions.assertThrows(IllegalArgumentException.class,
        () -> new DynamicCapacityStack<String>(2f));
  }

  @Test
  void givenNegativeLoadFactor_whenCreatingStack_thenThrowException() {
    Assertions.assertThrows(IllegalArgumentException.class,
        () -> new DynamicCapacityStack<String>(-2.0f));
  }

  @Test
  void givenInvalidInitialization_whenCreatingStack_thenThrowException() {
    Assertions.assertThrows(IllegalArgumentException.class,
        () -> new DynamicCapacityStack<String>(0, -2.0f));
  }

  @Test
  void givenStackWithoutElements_whenCheckingEmptiness_thenShouldBeTrue() {
    final var emptyStack = new DynamicCapacityStack<String>(1);
    Assertions.assertTrue(emptyStack.isEmpty());
  }

  @Test
  void givenStackWithOneElement_whenCheckingEmptiness_thenShouldBeFalse() {
    final var dynamicCapacity = new DynamicCapacityStack<String>(1);
    dynamicCapacity.push("Test");
    Assertions.assertFalse(dynamicCapacity.isEmpty());
  }

  @Test
  void givenStackWithMultipleElements_whenCheckingSize_thenResize() {
    final var dynamicCapacity = new DynamicCapacityStack<String>(1);
    dynamicCapacity.push("Test1");
    dynamicCapacity.push("Test2");
    Assertions.assertEquals(2, dynamicCapacity.size());
  }

  @Test
  void givenStackWithoutElements_whenPopElement_thenShouldBeEmpty() {
    final var dynamicCapacity = new DynamicCapacityStack<String>(10);
    Assertions.assertTrue(dynamicCapacity.pop().isEmpty());
  }

  @Test
  void givenStackWithOneElement_whenPopElement_thenShouldBeEqual() {
    final var dynamicCapacity = new DynamicCapacityStack<String>(1, 0.2f);
    dynamicCapacity.push("Test1");
    Assertions.assertAll("Testing single pop",
        () -> Assertions.assertEquals("Test1", dynamicCapacity.pop().get()),
        () -> Assertions.assertTrue(dynamicCapacity.isEmpty()));
  }

  @Test
  void givenStackWithMultipleElements_whenPopElements_thenShouldBeLifo() {
    final var dynamicCapacity = new DynamicCapacityStack<String>(2);
    dynamicCapacity.push("Test1");
    dynamicCapacity.push("Test2");
    Assertions.assertAll("Testing multiple pop",
        () -> Assertions.assertEquals("Test2", dynamicCapacity.pop().get()),
        () -> Assertions.assertEquals(1, dynamicCapacity.size()),
        () -> Assertions.assertEquals("Test1", dynamicCapacity.pop().get()),
        () -> Assertions.assertTrue(dynamicCapacity.isEmpty()));
  }

  @Test
  void givenStackWithMultipleElements_whenCheckingIterable_thenShouldTrue() {
    final var firstItem = "Test1";
    final var lastItem = "Test2";
    final var dynamicCapacity = new DynamicCapacityStack<String>(2);
    dynamicCapacity.push(firstItem);
    dynamicCapacity.push(lastItem);
    final var list = List.of(lastItem, firstItem);
    Assertions.assertIterableEquals(list, dynamicCapacity);
  }

  @Test
  void givenStackWithoutElements_whenIterating_thenShouldFail() {
    final var dynamicCapacity = new DynamicCapacityStack<>(5);
    final var iterator = dynamicCapacity.iterator();
    Assertions.assertThrows(NoSuchElementException.class, () -> iterator.next());
  }

  @Test
  void givenStackIterator_whenRemoving_thenShouldFail() {
    final var dynamicCapacity = new DynamicCapacityStack<>(5);
    final var iterator = dynamicCapacity.iterator();
    Assertions.assertThrows(UnsupportedOperationException.class, () -> iterator.remove());
  }

}