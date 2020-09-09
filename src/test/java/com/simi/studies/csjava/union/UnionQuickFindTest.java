package com.simi.studies.csjava.union;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.HashSet;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UnionQuickFindTest {

  @Test
  public void givenSingleConnection_whenGetSet_thenShouldExists() {
    final var unionQuickFind = new UnionQuickFind<Integer>();
    int firstNode = 2;
    int secondNode = 3;
    unionQuickFind.connect(firstNode, secondNode);
    final var set = new HashSet<Integer>();
    unionQuickFind.getSet().forEach(element -> set.add(element));
    assertTrue(set.contains(firstNode));
    assertTrue(set.contains(secondNode));
  }

  @Test
  public void givenSingleConnection_whenValidUnion_thenShouldBeConnected() {
    final var unionQuickFind = new UnionQuickFind<Integer>();
    int firstNode = 2;
    int secondNode = 3;
    unionQuickFind.connect(firstNode, secondNode);
    assertTrue(unionQuickFind.isConnected(firstNode, secondNode));
  }

  @Test
  public void givenMultipleIntegerConnection_whenValidUnion_thenShouldBeConnected() {
    final var unionQuickFind = new UnionQuickFind<Integer>();
    unionQuickFind.connect(4, 3);
    unionQuickFind.connect(3, 8);
    unionQuickFind.connect(6, 5);
    unionQuickFind.connect(9, 4);
    unionQuickFind.connect(2, 1);
    unionQuickFind.connect(8, 9);
    unionQuickFind.connect(5, 0);
    unionQuickFind.connect(7, 2);
    unionQuickFind.connect(6, 1);
    unionQuickFind.connect(1, 0);
    unionQuickFind.connect(6, 7);

    Assertions.assertAll("Testing union grouped in 1",
        () -> assertTrue(unionQuickFind.isConnected(1, 0)),
        () -> assertTrue(unionQuickFind.isConnected(1, 2)),
        () -> assertTrue(unionQuickFind.isConnected(1, 1)),
        () -> assertTrue(unionQuickFind.isConnected(1, 5)),
        () -> assertTrue(unionQuickFind.isConnected(1, 6)),
        () -> assertTrue(unionQuickFind.isConnected(1, 7)));

    Assertions.assertAll("Testing union grouped in 8",
        () -> assertTrue(unionQuickFind.isConnected(8, 3)),
        () -> assertTrue(unionQuickFind.isConnected(8, 4)),
        () -> assertTrue(unionQuickFind.isConnected(8, 8)),
        () -> assertTrue(unionQuickFind.isConnected(8, 9)));
  }

  @Test
  public void givenMultipleStringConnection_whenValidUnion_thenShouldBeConnected() {
    final var unionQuickFind = new UnionQuickFind<String>();
    unionQuickFind.connect("car", "house");
    unionQuickFind.connect("house", "bed");
    unionQuickFind.connect("work", "subway");

    Assertions.assertAll("Testing valid connections",
        () -> assertTrue(unionQuickFind.isConnected("car", "house")),
        () -> assertTrue(unionQuickFind.isConnected("car", "bed")),
        () -> assertTrue(unionQuickFind.isConnected("work", "subway")));

    Assertions.assertAll("Testing invalid connections",
        () -> assertFalse(unionQuickFind.isConnected("work", "bed")));
  }

  @Test
  public void givenNullNodes_whenInvalidUnion_thenIllegalArgumentException() {
    final var unionQuickFind = new UnionQuickFind<Long>();
    unionQuickFind.connect(4L, 3L);
    Assertions.assertAll("Testing when checking a connection with null arguments",
        () -> assertThrows(IllegalArgumentException.class,
            () -> unionQuickFind.connect(null, null)),
        () -> assertThrows(IllegalArgumentException.class, () -> unionQuickFind.connect(null, 1L)),
        () -> assertThrows(IllegalArgumentException.class, () -> unionQuickFind.connect(1L, null)));

    Assertions.assertAll("Testing when checking a connection non existing node",
        () -> assertThrows(IllegalArgumentException.class,
            () -> unionQuickFind.isConnected(10L, 4L)),
        () -> assertThrows(IllegalArgumentException.class,
            () -> unionQuickFind.isConnected(3L, 12L)),
        () -> assertThrows(IllegalArgumentException.class,
            () -> unionQuickFind.isConnected(30L, 99L)));
  }

}