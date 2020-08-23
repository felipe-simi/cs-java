package com.simi.studies.csjava.datastructure.fifo;

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

}
