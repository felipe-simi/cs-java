package com.simi.studies.csjava.datastructure.bag;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BagTest {

  @Test
  public void givenBagWithoutElements_whenCheckEmptiness_thenShouldBeTrue() {
    final var emptyBag = new Bag();
    Assertions.assertTrue(emptyBag.isEmpty());
  }

  @Test
  public void givenBagWithOneElement_whenCheckEmptiness_thenShouldBeFalse() {
    final var bag = new Bag();
    bag.add("Test");
    Assertions.assertFalse(bag.isEmpty());
  }

}