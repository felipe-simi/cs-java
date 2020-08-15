package com.simi.studies.csjava.datastructure.bag;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BagTest {

  @Test
  public void givenBagWithoutElements_whenCheckingEmptiness_thenShouldBeTrue() {
    final var emptyBag = new Bag();
    Assertions.assertTrue(emptyBag.isEmpty());
  }

  @Test
  public void givenBagWithOneElement_whenCheckingEmptiness_thenShouldBeFalse() {
    final var bag = new Bag<String>();
    bag.add("Test");
    Assertions.assertFalse(bag.isEmpty());
  }

  @Test
  public void givenBagWithMultipleElements_whenCheckingSize_thenShouldTwo() {
    final var bag = new Bag<String>();
    bag.add("Test1");
    bag.add("Test2");
    Assertions.assertEquals(2, bag.size());
  }

}