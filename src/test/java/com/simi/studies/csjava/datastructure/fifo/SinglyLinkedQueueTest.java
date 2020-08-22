package com.simi.studies.csjava.datastructure.fifo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SinglyLinkedQueueTest {

  @Test
  public void givenQueueWithoutElements_whenCheckingEmptiness_thenShouldBeTrue() {
    final var emptyQueue = new SinglyLinkedQueue<String>();
    Assertions.assertTrue(emptyQueue.isEmpty());
  }

  @Test
  public void givenQueueWithOneElement_whenCheckingEmptiness_thenShouldBeFalse() {
    final var singlyQueue = new SinglyLinkedQueue<String>();
    singlyQueue.enqueue("Test");
    Assertions.assertFalse(singlyQueue.isEmpty());
  }

  @Test
  public void givenQueueWithMultipleElements_whenCheckingSize_thenShouldTwo() {
    final var singlyQueue = new SinglyLinkedQueue<String>();
    singlyQueue.enqueue("Test1");
    Assertions.assertEquals(1, singlyQueue.size());
    singlyQueue.enqueue("Test2");
    Assertions.assertEquals(2, singlyQueue.size());
  }

}