package com.simi.studies.csjava.datastructure.lifo;

import com.simi.studies.csjava.datastructure.CapacityExceededException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.NoSuchElementException;

class FixedCapacityStackTest {

  @Test
  public void givenInvalidCapacity_whenCreatingStack_thenThrowException() {
    Assertions.assertThrows(IllegalArgumentException.class,
        () -> new FixedCapacityStack<String>(0));
  }

  @Test
  public void givenStackWithoutElements_whenCheckingEmptiness_thenShouldBeTrue() {
    final var emptyStack = new FixedCapacityStack<String>(10);
    Assertions.assertTrue(emptyStack.isEmpty());
  }

  @Test
  public void givenStackWithOneElement_whenCheckingEmptiness_thenShouldBeFalse() {
    final var fixedCapacity = new FixedCapacityStack<String>(1);
    fixedCapacity.push("Test");
    Assertions.assertFalse(fixedCapacity.isEmpty());
  }

  @Test
  public void givenStackWithMultipleElements_whenCheckingSize_thenShouldTwo() {
    final var fixedCapacity = new FixedCapacityStack<String>(2);
    fixedCapacity.push("Test1");
    fixedCapacity.push("Test2");
    Assertions.assertEquals(2, fixedCapacity.size());
  }

  @Test
  public void givenStackWithMultipleElements_whenExceedingCapacity_thenThrowException() {
    final var fixedCapacity = new FixedCapacityStack<String>(2);
    fixedCapacity.push("Test1");
    fixedCapacity.push("Test2");
    Assertions.assertThrows(CapacityExceededException.class, () -> fixedCapacity.push("Test3"));
  }

  @Test
  public void givenStackWithoutElements_whenPopElement_thenShouldBeEmpty() {
    final var fixedCapacity = new FixedCapacityStack<String>(2);
    Assertions.assertTrue(fixedCapacity.pop().isEmpty());
  }

  @Test
  public void givenStackWithOneElement_whenPopElement_thenShouldBeEqual() {
    final var fixedCapacity = new FixedCapacityStack<String>(1);
    fixedCapacity.push("Test1");
    Assertions.assertEquals("Test1", fixedCapacity.pop().get());
  }

  @Test
  public void givenStackWithMultipleElements_whenPopElements_thenShouldBeLifo() {
    final var fixedCapacity = new FixedCapacityStack<String>(2);
    fixedCapacity.push("Test1");
    fixedCapacity.push("Test2");
    Assertions.assertEquals("Test2", fixedCapacity.pop().get());
    Assertions.assertEquals("Test1", fixedCapacity.pop().get());
  }

  @Test
  public void givenStackWithMultipleElements_whenCheckingIterable_thenShouldTrue() {
    final var firstItem = "Test1";
    final var lastItem = "Test2";
    final var fixedCapacity = new FixedCapacityStack<String>(2);
    fixedCapacity.push(firstItem);
    fixedCapacity.push(lastItem);
    final var list = List.of(lastItem, firstItem);
    Assertions.assertIterableEquals(list, fixedCapacity);
  }

  @Test
  void givenStackWithoutElements_whenIterating_thenShouldFail() {
    final var fixedCapacity = new FixedCapacityStack<>(5);
    final var iterator = fixedCapacity.iterator();
    Assertions.assertThrows(NoSuchElementException.class, () -> iterator.next());
  }

  @Test
  void givenStackIterator_whenRemoving_thenShouldFail() {
    final var fixedCapacity = new FixedCapacityStack<>(5);
    final var iterator = fixedCapacity.iterator();
    Assertions.assertThrows(UnsupportedOperationException.class, () -> iterator.remove());
  }

}