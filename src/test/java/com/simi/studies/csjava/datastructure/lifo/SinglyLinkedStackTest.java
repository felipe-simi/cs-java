package com.simi.studies.csjava.datastructure.lifo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
  }

  @Test
  public void givenStackWithMultipleElements_whenPopElements_thenShouldBeLifo() {
    final var singlyStack = new SinglyLinkedStack<String>();
    singlyStack.push("Test1");
    singlyStack.push("Test2");
    Assertions.assertEquals("Test2", singlyStack.pop().get());
    Assertions.assertEquals("Test1", singlyStack.pop().get());
  }

}