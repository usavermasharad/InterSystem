package com.in2ittech.verma.IntTransSystem.Service;

import java.util.List;
import java.util.Optional;


import com.in2ittech.verma.IntTransSystem.entity.Vertice;

public interface VerticeService {

	List<Vertice> retrieveAllVertices();

	public Optional<Vertice> retrieveVertice(Integer id);

	void deleteVertice(Integer id);

	Vertice saveVertice(Vertice vertice);

	String getVertexById(String sourceVertex);
	
	Vertice getVertexByName(String sourceValue);

}
