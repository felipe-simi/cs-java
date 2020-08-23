package com.simi.studies.csjava.datastructure.fifo;

import com.simi.studies.csjava.datastructure.CapacityExceededException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FixedCapacityQueueTest {

  @Test
  public void givenQueueWithoutElements_whenCheckingEmptiness_thenShouldBeTrue() {
    final var emptyQueue = new FixedCapacityQueue<String>(10);
    Assertions.assertTrue(emptyQueue.isEmpty());
  }

  @Test
  public void givenQueueWithOneElement_whenCheckingEmptiness_thenShouldBeFalse() {
    final var fixedCapacity = new FixedCapacityQueue<String>(1);
    fixedCapacity.enqueue("Test");
    Assertions.assertFalse(fixedCapacity.isEmpty());
  }

  @Test
  public void givenQueueWithMultipleElements_whenCheckingSize_thenShouldTwo() {
    final var fixedCapacity = new FixedCapacityQueue<String>(2);
    fixedCapacity.enqueue("Test1");
    fixedCapacity.enqueue("Test2");
    Assertions.assertEquals(2, fixedCapacity.size());
  }

  @Test
  public void givenQueueWithMultipleElements_whenExceedingCapacity_thenThrowException() {
    final var fixedCapacity = new FixedCapacityQueue<String>(2);
    fixedCapacity.enqueue("Test1");
    fixedCapacity.enqueue("Test2");
    Assertions.assertThrows(CapacityExceededException.class, () -> fixedCapacity.enqueue("Test3"));
  }

}