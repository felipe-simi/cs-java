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
  public void givenStackWithMultipleElements_whenCheckingSize_thenResize() {
    final var dynamicCapacity = new DynamicCapacityStack<String>(1);
    dynamicCapacity.push("Test1");
    dynamicCapacity.push("Test2");
    Assertions.assertEquals(2, dynamicCapacity.size());
  }

  @Test
  public void givenStackWithoutElements_whenPopElement_thenShouldBeEmpty() {
    final var dynamicCapacity = new DynamicCapacityStack<String>(0);
    Assertions.assertTrue(dynamicCapacity.pop().isEmpty());
  }


  @Test
  public void givenStackWithOneElement_whenPopElement_thenShouldBeEqual() {
    final var dynamicCapacity = new DynamicCapacityStack<String>(1);
    dynamicCapacity.push("Test1");
    Assertions.assertEquals("Test1", dynamicCapacity.pop().get());
  }

  @Test
  public void givenStackWithMultipleElements_whenPopElements_thenShouldBeLifo() {
    final var dynamicCapacity = new DynamicCapacityStack<String>(2);
    dynamicCapacity.push("Test1");
    dynamicCapacity.push("Test2");
    Assertions.assertEquals("Test2", dynamicCapacity.pop().get());
    Assertions.assertEquals("Test1", dynamicCapacity.pop().get());
    Assertions.assertTrue(dynamicCapacity.isEmpty());
  }


}