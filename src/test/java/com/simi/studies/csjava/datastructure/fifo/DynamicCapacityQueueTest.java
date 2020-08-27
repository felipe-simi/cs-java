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

}