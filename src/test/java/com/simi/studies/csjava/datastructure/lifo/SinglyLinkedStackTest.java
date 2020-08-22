package com.simi.studies.csjava.datastructure.lifo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.NoSuchElementException;

class SinglyLinkedStackTest {

  @Test
  public void givenStackWithoutElements_whenCheckingEmptiness_thenShouldBeTrue() {
    final var emptyStack = new SinglyLinkedStack<String>();
    Assertions.assertTrue(emptyStack.isEmpty());
  }

  @Test
  public void givenStackWithOneElement_whenCheckingEmptiness_thenShouldBeFalse() {
    final var singlyStack = new SinglyLinkedStack<String>();
    singlyStack.push("Test");
    Assertions.assertFalse(singlyStack.isEmpty());
  }

  @Test
  public void givenStackWithMultipleElements_whenCheckingSize_thenShouldTwo() {
    final var singlyStack = new SinglyLinkedStack<String>();
    singlyStack.push("Test1");
    Assertions.assertEquals(1, singlyStack.size());
    singlyStack.push("Test2");
    Assertions.assertEquals(2, singlyStack.size());
  }

  @Test
  public void givenStackWithoutElements_whenPopElement_thenShouldBeEmpty() {
    final var singlyStack = new SinglyLinkedStack<String>();
    Assertions.assertTrue(singlyStack.pop().isEmpty());
  }

  @Test
  public void givenStackWithOneElement_whenPopElement_thenShouldBeEqual() {
    final var singlyStack = new SinglyLinkedStack<String>();
    singlyStack.push("Test1");
    Assertions.assertEquals("Test1", singlyStack.pop().get());
    Assertions.assertEquals(0, singlyStack.size());
  }

  @Test
  public void givenStackWithMultipleElements_whenPopElements_thenShouldBeLifo() {
    final var singlyStack = new SinglyLinkedStack<String>();
    singlyStack.push("Test1");
    singlyStack.push("Test2");
    Assertions.assertEquals("Test2", singlyStack.pop().get());
    Assertions.assertEquals(1, singlyStack.size());
    Assertions.assertEquals("Test1", singlyStack.pop().get());
    Assertions.assertEquals(0, singlyStack.size());
  }

  @Test
  public void givenStackWithMultipleElements_whenCheckingIterable_thenShouldTrue() {
    final var firstItem = "Test1";
    final var lastItem = "Test2";
    final var singlyStack = new SinglyLinkedStack<String>();
    singlyStack.push(firstItem);
    singlyStack.push(lastItem);
    final var list = List.of(lastItem, firstItem);
    Assertions.assertIterableEquals(list, singlyStack);
  }

  @Test
  void givenStackWithoutElements_whenIterating_thenShouldFail() {
    final var linkedStack = new SinglyLinkedStack<>();
    final var iterator = linkedStack.iterator();
    Assertions.assertThrows(NoSuchElementException.class, () -> iterator.next());
  }

  @Test
  void givenStackIterator_whenRemoving_thenShouldFail() {
    final var linkedStack = new SinglyLinkedStack<>();
    final var iterator = linkedStack.iterator();
    Assertions.assertThrows(UnsupportedOperationException.class, () -> iterator.remove());
  }

}