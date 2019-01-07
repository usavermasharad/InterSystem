package com.in2ittech.verma.IntTransSystem.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in2ittech.verma.IntTransSystem.Service.EdgeService;
import com.in2ittech.verma.IntTransSystem.Service.TrafficService;
import com.in2ittech.verma.IntTransSystem.Service.VerticeService;
import com.in2ittech.verma.IntTransSystem.entity.Edge;
import com.in2ittech.verma.IntTransSystem.entity.Traffic;
import com.in2ittech.verma.IntTransSystem.entity.Vertice;
import com.in2ittech.verma.IntTransSystem.utility.Graph;

@Service
public class GraphService {

	@Autowired
	private VerticeService verticeService;
	@Autowired
	private EdgeService edgeService;
	@Autowired
	private TrafficService trafficService;

	public Graph selectAllGraph() {
		List<Vertice> vertices = verticeService.retrieveAllVertices();
		List<Edge> edges = edgeService.retrieveAllEdge();
		List<Traffic> traffics = trafficService.retrieveAllTraffic();
		Graph graph = new Graph(vertices, edges, traffics);
		//System.out.println(vertices);
		//System.out.println(edges);
		//System.out.println(traffics);
		return graph;
	}

	public Vertice getVertexByName(String sourceValue) {

		return verticeService.getVertexByName(sourceValue);
	}

}
