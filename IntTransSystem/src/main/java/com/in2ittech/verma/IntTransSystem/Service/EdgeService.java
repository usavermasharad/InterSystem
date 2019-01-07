package com.in2ittech.verma.IntTransSystem.Service;

import java.util.List;
import java.util.Optional;

import com.in2ittech.verma.IntTransSystem.entity.Edge;
import com.in2ittech.verma.IntTransSystem.entity.Vertice;

public interface EdgeService {

	List <Edge> retrieveAllEdge();
	public Optional<Edge> retrieveEdge(Integer id);
	void deleteEdge(Integer id);
	Edge saveEdge(Edge edge);
}
