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


}