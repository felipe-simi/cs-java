package com.simi.studies.csjava.datastructure.fifo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FixedCapacityQueueTest {

 @Test
 public void givenQueueWithoutElements_whenCheckingEmptiness_thenShouldBeTrue() {
  final var emptyQueue = new FixedCapacityQueue<String>();
  Assertions.assertTrue(emptyQueue.isEmpty());
 }

}
