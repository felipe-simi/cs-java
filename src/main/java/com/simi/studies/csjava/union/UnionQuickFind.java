package com.simi.studies.csjava.union;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class UnionQuickFind<T> implements UnionAlgorithm<T> {

  private Map<T, Integer> elements = new HashMap();

  @Override
  public Iterable<T> getSet() {
    return Collections.unmodifiableSet(elements.keySet());
  }

  @Override
  public void connect(final T firstNode, final T secondNode) {
    areValidNodes(firstNode, secondNode);
    boolean containsFirst = elements.containsKey(firstNode);
    boolean containsSecond = elements.containsKey(secondNode);
    if (containsFirst && containsSecond) {
      connectFromExisting(firstNode, secondNode);
      return;
    }
    if (containsFirst) {
      connectFromExisting(firstNode, secondNode);
      return;
    }
    if (containsSecond) {
      connectFromExisting(secondNode, firstNode);
      return;
    }
    connectNew(firstNode, secondNode);
  }

  private void connectFromExisting(T firstNode, T secondNode) {
    final var setLocation = elements.get(firstNode);
    elements.put(secondNode, setLocation);
  }


  private void connectNew(T firstNode, T secondNode) {
    var lastValue = 0;
    for (Integer value : elements.values()) {
      lastValue = value;
    }
    lastValue++;
    elements.put(firstNode, lastValue);
    elements.put(secondNode, lastValue);
  }

  @Override
  public boolean isConnected(final T firstNode, final T secondNode) {
    areValidNodes(firstNode, secondNode);
    if (!(elements.containsKey(firstNode) && elements.containsKey(secondNode))) {
      throw new IllegalArgumentException("Both nodes need to be in the set.");
    }
    return elements.get(firstNode).equals(elements.get(secondNode));
  }

  private void areValidNodes(T firstNode, T secondNode) {
    if (firstNode == null || secondNode == null) {
      throw new IllegalArgumentException("Node can not be null.");
    }
  }

}
