package com.simi.studies.csjava.datastructure.bag;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BagTest {

  @Test
  public void givenBagWithoutElements_whenCheckEmptiness_thenShouldBeTrue() {
    final var emptyBag = new Bag();
    Assertions.assertTrue(emptyBag.isEmpty());
  }

}