package com.simi.studies.csjava.datastructure.lifo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DynamicCapacityStackTest {

  @Test
  public void givenStackWithoutElements_whenCheckingEmptiness_thenShouldBeTrue() {
    final var emptyStack = new DynamicCapacityStack<String>(1);
    Assertions.assertTrue(emptyStack.isEmpty());
  }

  @Test
  public void givenStackWithOneElement_whenCheckingEmptiness_thenShouldBeFalse() {
    final var dynamicCapacity = new DynamicCapacityStack<String>(1);
    dynamicCapacity.push("Test");
    Assertions.assertFalse(dynamicCapacity.isEmpty());
  }

  @Test
  public void givenStackWithMultipleElements_whenCheckingSize_thenShouldTwo() {
    final var dynamicCapacity = new DynamicCapacityStack<String>(1);
    dynamicCapacity.push("Test1");
    dynamicCapacity.push("Test2");
    Assertions.assertEquals(2, dynamicCapacity.size());
  }

}