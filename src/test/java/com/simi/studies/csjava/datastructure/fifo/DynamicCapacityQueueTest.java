package com.simi.studies.csjava.datastructure.fifo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.NoSuchElementException;

class DynamicCapacityQueueTest {

  @Test
  void givenQueueWithoutElements_whenCheckingEmptiness_thenShouldBeTrue() {
    final var emptyQueue = new DynamicCapacityQueue<String>(10);
    Assertions.assertTrue(emptyQueue.isEmpty());
  }

  @Test
  void givenQueueWithOneElement_whenCheckingEmptiness_thenShouldBeFalse() {
    final var dynamicCapacity = new DynamicCapacityQueue<String>(10);
    dynamicCapacity.enqueue("Test");
    Assertions.assertFalse(dynamicCapacity.isEmpty());
  }

  @Test
  void givenQueueWithMultipleElements_whenCheckingSize_thenShouldTwo() {
    final var dynamicCapacity = new DynamicCapacityQueue<String>(1);
    dynamicCapacity.enqueue("Test1");
    dynamicCapacity.enqueue("Test2");
    Assertions.assertEquals(2, dynamicCapacity.size());
  }

  @Test
  void givenQueueWithoutElements_whenDequeueElement_thenShouldBeEmpty() {
    final var dynamicCapacity = new DynamicCapacityQueue<String>(2);
    Assertions.assertTrue(dynamicCapacity.dequeue().isEmpty());
  }

  @Test
  void givenQueueWithOneElement_whenDequeueElement_thenShouldBeEqual() {
    final var dynamicCapacity = new DynamicCapacityQueue<String>(1);
    dynamicCapacity.enqueue("Test1");
    Assertions.assertAll("Testing single dequeue",
        () -> Assertions.assertEquals("Test1", dynamicCapacity.dequeue().get()),
        () -> Assertions.assertEquals(0, dynamicCapacity.size()));
  }

  @Test
  void givenQueueWithMultipleElements_whenDequeueElements_thenShouldBeLifo() {
    final var dynamicCapacity = new DynamicCapacityQueue<String>(2);
    dynamicCapacity.enqueue("Test1");
    dynamicCapacity.enqueue("Test2");
    Assertions.assertAll("Testing multiple dequeue",
        () -> Assertions.assertEquals("Test1", dynamicCapacity.dequeue().get()),
        () -> Assertions.assertEquals(1, dynamicCapacity.size()),
        () -> Assertions.assertEquals("Test2", dynamicCapacity.dequeue().get()),
        () -> Assertions.assertEquals(0, dynamicCapacity.size()));
  }

  @Test
  void givenQueueWithMultipleElements_whenDequeueElementsInterchangeably_thenShouldBeLifo() {
    final var dynamicCapacity = new DynamicCapacityQueue<String>(2);
    dynamicCapacity.enqueue("Test1");
    Assertions.assertEquals("Test1", dynamicCapacity.dequeue().get());
    Assertions.assertEquals(0, dynamicCapacity.size());
    dynamicCapacity.enqueue("Test2");
    Assertions.assertEquals("Test2", dynamicCapacity.dequeue().get());
    Assertions.assertEquals(0, dynamicCapacity.size());
  }


  @Test
  void givenQueueWithMultipleElements_whenCheckingIterable_thenShouldTrue() {
    final var firstItem = "Test1";
    final var lastItem = "Test2";
    final var fixedCapacity = new DynamicCapacityQueue<String>(2);
    fixedCapacity.enqueue(firstItem);
    fixedCapacity.enqueue(lastItem);
    final var list = List.of(firstItem, lastItem);
    Assertions.assertIterableEquals(list, fixedCapacity);
  }

  @Test
  void givenQueueWithoutElements_whenIterating_thenShouldFail() {
    final var fixedCapacity = new DynamicCapacityQueue<>(2);
    final var iterator = fixedCapacity.iterator();
    Assertions.assertThrows(NoSuchElementException.class, () -> iterator.next());
  }

  @Test
  void givenQueueIterator_whenRemoving_thenShouldFail() {
    final var fixedCapacity = new DynamicCapacityQueue<>(2);
    final var iterator = fixedCapacity.iterator();
    Assertions.assertThrows(UnsupportedOperationException.class, () -> iterator.remove());
  }

}
