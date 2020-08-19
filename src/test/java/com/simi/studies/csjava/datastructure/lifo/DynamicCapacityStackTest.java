package com.simi.studies.csjava.datastructure.lifo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DynamicCapacityStackTest {

  @Test
  public void givenStackWithoutElements_whenCheckingEmptiness_thenShouldBeTrue() {
    final var emptyStack = new DynamicCapacityStack<String>();
    Assertions.assertTrue(emptyStack.isEmpty());
  }

}