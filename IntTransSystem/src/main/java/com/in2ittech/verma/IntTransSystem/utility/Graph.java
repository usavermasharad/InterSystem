package com.in2ittech.verma.IntTransSystem.utility;

import java.util.ArrayList;
import java.util.List;

import com.in2ittech.verma.IntTransSystem.entity.Edge;
import com.in2ittech.verma.IntTransSystem.entity.Traffic;
import com.in2ittech.verma.IntTransSystem.entity.Vertice;

public class Graph {
	  private List<Vertice> Verticees;
	    private List<Edge> edges;
	    private List<Traffic> traffics;
	    private boolean undirectedGraph;
	    private boolean trafficAllowed;

	    public Graph(List<Vertice> Verticees, List<Edge> edges, List<Traffic> traffics) {
	        this.Verticees = Verticees;
	        this.edges = edges;
	        this.traffics = traffics;
	    }

	    public List<Traffic> getTraffics() {
	        return traffics;
	    }

	    public List<Vertice> getVerticees() {
	        return Verticees;
	    }

	    public List<Edge> getEdges() {
	        return edges;
	    }

	    public boolean isUndirectedGraph() {
	        return undirectedGraph;
	    }

	    public void setUndirectedGraph(boolean undirectedGraph) {
	        this.undirectedGraph = undirectedGraph;
	    }

	    public boolean isTrafficAllowed() {
	        return trafficAllowed;
	    }

	    public void setTrafficAllowed(boolean trafficAllowed) {
	        this.trafficAllowed = trafficAllowed;
	    }

	    public void processTraffics() {
	        if (traffics != null && !traffics.isEmpty()) {
	            for (Traffic traffic : traffics) {
	                for (Edge edge : edges) {
	                    if (checkObjectsEqual(edge.getEdgeId(), traffic.getRouteId())) {
	                        if (checkObjectsEqual(edge.getSource(), traffic.getSource()) && checkObjectsEqual(edge.getDestination(), traffic.getDestination())) {
	                            edge.setTimeDelay(traffic.getTimeDelay());
	                        }
	                    }
	                }
	            }
	        }
	    }

	    public List<Edge> getUndirectedEdges() {
	        List<Edge> undirectedEdges = new ArrayList();
	        for (Edge fromEdge : edges) {
	            Edge toEdge = copyAdjacentEdge(fromEdge);
	            undirectedEdges.add(fromEdge);
	            undirectedEdges.add(toEdge);
	        }
	        return undirectedEdges;
	    }

	    public Edge copyAdjacentEdge(Edge fromEdge) {
	        Edge toEdge = new Edge();
	        toEdge.setEdgeId(fromEdge.getEdgeId());
	        toEdge.setSource(fromEdge.getDestination());
	        toEdge.setDestination(fromEdge.getSource());
	        toEdge.setDistance(fromEdge.getDistance());
	        toEdge.setTimeDelay(fromEdge.getTimeDelay());
	        return toEdge;
	    }

	    public boolean checkObjectsEqual(Object object, Object otherObject) {
	        if (object == null && otherObject == null) {
	            //Both objects are null
	            return true;
	        } else if (object == null || otherObject == null) {
	            //One of the objects is null
	            return false;
	        } else if (object instanceof String && otherObject instanceof String) {
	            return ((String) object).equalsIgnoreCase((String) otherObject);
	        } else {
	            //Both objects are not null
	            return object.equals(otherObject);
	        }

	    }
}
