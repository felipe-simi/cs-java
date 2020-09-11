package com.simi.studies.csjava.datastructure.bag;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;

class BagTest {

  @Test
  void givenBagWithoutElements_whenCheckingEmptiness_thenShouldBeTrue() {
    final var emptyBag = new Bag();
    Assertions.assertTrue(emptyBag.isEmpty());
  }

  @Test
  void givenBagWithOneElement_whenCheckingEmptiness_thenShouldBeFalse() {
    final var bag = new Bag<String>();
    bag.add("Test");
    Assertions.assertFalse(bag.isEmpty());
  }

  @Test
  void givenBagWithMultipleElements_whenCheckingSize_thenShouldTwo() {
    final var bag = new Bag<String>();
    bag.add("Test1");
    bag.add("Test2");
    Assertions.assertEquals(2, bag.size());
  }

  @Test
  void givenBagWithMultipleElements_whenCheckingIterable_thenShouldTrue() {
    final var firstItem = "Test1";
    final var lastItem = "Test2";
    final var bag = new Bag<String>();
    bag.add(firstItem);
    bag.add(lastItem);
    final var list = List.of(lastItem, firstItem);
    Assertions.assertIterableEquals(list, bag);
  }

}