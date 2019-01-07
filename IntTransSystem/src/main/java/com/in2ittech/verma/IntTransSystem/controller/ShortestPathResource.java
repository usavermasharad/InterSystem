package com.in2ittech.verma.IntTransSystem.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.in2ittech.verma.IntTransSystem.Service.ShortestPathService;
import com.in2ittech.verma.IntTransSystem.entity.Edge;
import com.in2ittech.verma.IntTransSystem.entity.ShortestMessageBean;
import com.in2ittech.verma.IntTransSystem.entity.Vertice;
import com.in2ittech.verma.IntTransSystem.utility.Constants;
import com.in2ittech.verma.IntTransSystem.utility.Graph;

@CrossOrigin("http://localhost:4200")
@RestController
public class ShortestPathResource {

	//
	/*
	 * @Autowired private ShortestPathService shortestPathService;
	 */
	@Autowired
	private GraphService graphService;

	private List<Vertice> vertices;
	private List<Edge> edges;
	private Set<Vertice> visitedVertices;
	private Set<Vertice> unvisitedVertices;
	private Map<Vertice, Vertice> previousPaths;
	private Map<Vertice, Double> distance;

	@GetMapping("/shortest/from/{sourceValue}/to/{destinationValue}")
	public ShortestMessageBean getShortestPath(@PathVariable String sourceValue,
			@PathVariable String destinationValue) {
		StringBuilder path = new StringBuilder();

		/*
		 * path.append("A->B"); path.append("\t"); path.append("A->B");
		 * path.append("\t"); path.append("A->B"); path.append("\t");
		 */
		Graph graph = graphService.selectAllGraph();
		graph.setTrafficAllowed(true);
		graph.setUndirectedGraph(true);

		initializePlanets(graph);
		Vertice source = graphService.getVertexByName(sourceValue);
		Vertice destination = graphService.getVertexByName(destinationValue);
		System.out.println(source + ":" + destination);

		run(source);
		LinkedList<Vertice> paths = getPath(destination);
		System.out.println("paths:" + paths);

		if (paths != null) {
			for (Vertice v : paths) {
				path.append(v.getVerticeName() + " (" + v.getVerticeId() + ")");
				path.append("\t");
			}
		} else if (source != null && destination != null && source.getVerticeId().equals(destination.getVerticeId())) {
			path.append(Constants.PATH_NOT_NEEDED + source.getVerticeName());
		} else {
			path.append(Constants.PATH_NOT_AVAILABLE);
		}

		return new ShortestMessageBean(path.toString());
	}

	private void run(Vertice source) {
		distance = new HashMap<>();
		previousPaths = new HashMap<>();
		visitedVertices = new HashSet<>();
		unvisitedVertices = new HashSet<>();
		distance.put(source, 0d);
		unvisitedVertices.add(source);
		while (unvisitedVertices.size() > 0) {
			Vertice currentVertice = getVerticeWithLowestDistance(unvisitedVertices);
			visitedVertices.add(currentVertice);
			unvisitedVertices.remove(currentVertice);
			evaluateNeighborsWithMinimalDistances(currentVertice);
		}
	}

	private Vertice getVerticeWithLowestDistance(Set<Vertice> Verticees) {
		Vertice lowestVertice = null;
		for (Vertice Vertice : Verticees) {
			if (lowestVertice == null) {
				lowestVertice = Vertice;
			} else if (getShortestDistance(Vertice) < getShortestDistance(lowestVertice)) {
				lowestVertice = Vertice;
			}
		}
		return lowestVertice;
	}

	private void evaluateNeighborsWithMinimalDistances(Vertice currentVertice) {
		List<Vertice> adjacentVertices = getNeighbors(currentVertice);
		for (Vertice target : adjacentVertices) {
			double alternateDistance = getShortestDistance(currentVertice) + getDistance(currentVertice, target);
			if (alternateDistance < getShortestDistance(target)) {
				distance.put(target, alternateDistance);
				previousPaths.put(target, currentVertice);
				unvisitedVertices.add(target);
			}
		}
	}

	private List<Vertice> getNeighbors(Vertice currentVertice) {
		List<Vertice> neighbors = new ArrayList<>();
		for (Edge edge : edges) {
			Vertice destination = fromId(edge.getDestination());
			if (edge.getSource().equals(currentVertice.getVerticeId()) ) {//&& !isVisited(destination)
				neighbors.add(destination);
			}
		}
		return neighbors;
	}

	private Vertice fromId(final String str) {
		for (Vertice v : vertices) {
			if (v.getVerticeId().equalsIgnoreCase(str)) {
				return v;
			}
		}
		Vertice islandVertice = new Vertice();
		islandVertice.setVerticeId(str);
		islandVertice.setVerticeName("Island " + str);
		return islandVertice;
	}

	private boolean isVisited(Vertice Vertice) {
		return visitedVertices.contains(Vertice);
	}

	private Double getShortestDistance(Vertice destination) {
		Double d = distance.get(destination);
		if (d == null) {
			return Double.POSITIVE_INFINITY;
		} else {
			return d;
		}
	}

	private double getDistance(Vertice source, Vertice target) {
		for (Edge edge : edges) {
			if (edge.getSource().equals(source.getVerticeId()) && edge.getDestination().equals(target.getVerticeId())) {
				return edge.getDistance() + edge.getTimeDelay();
			}
		}
		throw new RuntimeException("Error: Something went wrong!");
	}

	private LinkedList<Vertice> getPath(Vertice target) {
		LinkedList<Vertice> path = new LinkedList<>();
		Vertice step = target;

		if (previousPaths.get(step) == null) {
			return null;
		}
		path.add(step);
		while (previousPaths.get(step) != null) {
			step = previousPaths.get(step);
			path.add(step);
		}

		Collections.reverse(path);
		return path;
	}

	private void initializePlanets(Graph graph) {
		this.vertices = new ArrayList<>(graph.getVerticees());
		if (graph.isTrafficAllowed()) {
			graph.processTraffics();
		}
		if (graph.isUndirectedGraph()) {
			this.edges = new ArrayList<>(graph.getUndirectedEdges());
		} else {
			this.edges = new ArrayList<>(graph.getEdges());
		}
	}
}
