package com.simi.studies.csjava.union;

public interface UnionAlgorithm<T> {

  Iterable<T> getSet();

  void connect(T firstNodeId, T secondNodeId);

  boolean isConnected(T firstNode, T secondNode);

}
