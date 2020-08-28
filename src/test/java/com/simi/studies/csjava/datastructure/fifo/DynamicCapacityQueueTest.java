package com.simi.studies.csjava.datastructure.fifo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DynamicCapacityQueueTest {

  @Test
  public void givenQueueWithoutElements_whenCheckingEmptiness_thenShouldBeTrue() {
    final var emptyQueue = new DynamicCapacityQueue<String>(10);
    Assertions.assertTrue(emptyQueue.isEmpty());
  }

  @Test
  public void givenQueueWithOneElement_whenCheckingEmptiness_thenShouldBeFalse() {
    final var dynamicCapacity = new DynamicCapacityQueue<String>(10);
    dynamicCapacity.enqueue("Test");
    Assertions.assertFalse(dynamicCapacity.isEmpty());
  }

  @Test
  public void givenQueueWithMultipleElements_whenCheckingSize_thenShouldTwo() {
    final var dynamicCapacity = new DynamicCapacityQueue<String>(1);
    dynamicCapacity.enqueue("Test1");
    dynamicCapacity.enqueue("Test2");
    Assertions.assertEquals(2, dynamicCapacity.size());
  }

  @Test
  public void givenQueueWithoutElements_whenDequeueElement_thenShouldBeEmpty() {
    final var dynamicCapacity = new DynamicCapacityQueue<String>(2);
    Assertions.assertTrue(dynamicCapacity.dequeue().isEmpty());
  }

  @Test
  public void givenQueueWithOneElement_whenDequeueElement_thenShouldBeEqual() {
    final var dynamicCapacity = new DynamicCapacityQueue<String>(1);
    dynamicCapacity.enqueue("Test1");
    Assertions.assertEquals("Test1", dynamicCapacity.dequeue().get());
  }

  @Test
  public void givenQueueWithMultipleElements_whenDequeueElements_thenShouldBeLifo() {
    final var dynamicCapacity = new DynamicCapacityQueue<String>(2);
    dynamicCapacity.enqueue("Test1");
    dynamicCapacity.enqueue("Test2");
    Assertions.assertEquals("Test1", dynamicCapacity.dequeue().get());
    Assertions.assertEquals("Test2", dynamicCapacity.dequeue().get());
  }

  @Test
  public void givenQueueWithMultipleElements_whenDequeueElementsInterchangeably_thenShouldBeLifo() {
    final var dynamicCapacity = new DynamicCapacityQueue<String>(2);
    dynamicCapacity.enqueue("Test1");
    Assertions.assertEquals("Test1", dynamicCapacity.dequeue().get());
    Assertions.assertEquals(0, dynamicCapacity.size());
    dynamicCapacity.enqueue("Test2");
    Assertions.assertEquals("Test2", dynamicCapacity.dequeue().get());
    Assertions.assertEquals(0, dynamicCapacity.size());
  }

}
