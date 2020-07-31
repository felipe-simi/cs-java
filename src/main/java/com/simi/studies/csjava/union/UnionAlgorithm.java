package com.simi.studies.csjava.union;

public interface UnionAlgorithm<T> {

  Iterable<T> getSet();

  void connect(final T firstNode, final T secondNode);

  boolean isConnected(final T firstNode, final T secondNode);

}
