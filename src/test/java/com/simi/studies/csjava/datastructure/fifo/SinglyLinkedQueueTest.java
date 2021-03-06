package com.simi.studies.csjava.datastructure.fifo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.NoSuchElementException;

class SinglyLinkedQueueTest {

  @Test
  void givenQueueWithoutElements_whenCheckingEmptiness_thenShouldBeTrue() {
    final var emptyQueue = new SinglyLinkedQueue<String>();
    Assertions.assertTrue(emptyQueue.isEmpty());
  }

  @Test
  void givenQueueWithOneElement_whenCheckingEmptiness_thenShouldBeFalse() {
    final var singlyQueue = new SinglyLinkedQueue<String>();
    singlyQueue.enqueue("Test");
    Assertions.assertFalse(singlyQueue.isEmpty());
  }

  @Test
  void givenQueueWithMultipleElements_whenCheckingSize_thenShouldTwo() {
    final var singlyQueue = new SinglyLinkedQueue<String>();
    singlyQueue.enqueue("Test1");
    Assertions.assertEquals(1, singlyQueue.size());
    singlyQueue.enqueue("Test2");
    Assertions.assertEquals(2, singlyQueue.size());
  }

  @Test
  void givenQueueWithoutElements_whenDequeueElement_thenShouldBeEmpty() {
    final var singlyQueue = new SinglyLinkedQueue<String>();
    Assertions.assertTrue(singlyQueue.dequeue().isEmpty());
  }

  @Test
  void givenQueueWithOneElement_whenDequeueElement_thenShouldBeEqual() {
    final var singlyQueue = new SinglyLinkedQueue<String>();
    singlyQueue.enqueue("Test1");
    Assertions.assertAll("Testing single dequeue",
        () -> Assertions.assertEquals("Test1", singlyQueue.dequeue().get()),
        () -> Assertions.assertEquals(0, singlyQueue.size()));
  }

  @Test
  void givenQueueWithMultipleElements_whenDequeueElements_thenShouldBeLifo() {
    final var singlyQueue = new SinglyLinkedQueue<String>();
    singlyQueue.enqueue("Test1");
    singlyQueue.enqueue("Test2");
    Assertions.assertAll("Testing multiple dequeue",
        () -> Assertions.assertEquals("Test1", singlyQueue.dequeue().get()),
        () -> Assertions.assertEquals(1, singlyQueue.size()),
        () -> Assertions.assertEquals("Test2", singlyQueue.dequeue().get()),
        () -> Assertions.assertEquals(0, singlyQueue.size()));

  }

  @Test
  void givenQueueWithMultipleElements_whenCheckingIterable_thenShouldTrue() {
    final var firstItem = "Test1";
    final var lastItem = "Test2";
    final var singlyQueue = new SinglyLinkedQueue<String>();
    singlyQueue.enqueue(firstItem);
    singlyQueue.enqueue(lastItem);
    final var list = List.of(firstItem, lastItem);
    Assertions.assertIterableEquals(list, singlyQueue);
  }

  @Test
  void givenQueueWithoutElements_whenIterating_thenShouldFail() {
    final var singlyQueue = new SinglyLinkedQueue<>();
    final var iterator = singlyQueue.iterator();
    Assertions.assertThrows(NoSuchElementException.class, () -> iterator.next());
  }

  @Test
  void givenQueueIterator_whenRemoving_thenShouldFail() {
    final var singlyQueue = new SinglyLinkedQueue<>();
    final var iterator = singlyQueue.iterator();
    Assertions.assertThrows(UnsupportedOperationException.class, () -> iterator.remove());
  }

}