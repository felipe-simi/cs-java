package com.simi.studies.csjava.union;

public interface UnionAlgorithm<T> {

  Iterable<T> getSet();

  void connect(final T firstNodeId, final T secondNodeId);

  boolean isConnected(final T firstNode, final T secondNode);

}
