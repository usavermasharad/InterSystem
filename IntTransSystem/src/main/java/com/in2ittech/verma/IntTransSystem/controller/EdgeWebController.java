package com.in2ittech.verma.IntTransSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.in2ittech.verma.IntTransSystem.Service.EdgeService;
import com.in2ittech.verma.IntTransSystem.Service.VerticeService;
import com.in2ittech.verma.IntTransSystem.entity.Edge;
import com.in2ittech.verma.IntTransSystem.entity.Vertice;
import com.in2ittech.verma.IntTransSystem.utility.Codes;
import com.in2ittech.verma.IntTransSystem.utility.Constants;
import com.in2ittech.verma.IntTransSystem.viewobject.ShortestPath;

@Controller
public class EdgeWebController {

	private EdgeService edgeService;
	private VerticeService verticeService;

	@Autowired
	public EdgeWebController(EdgeService edgeService ,VerticeService verticeService) {
		this.edgeService = edgeService;
		this.verticeService =verticeService;
	}

	@RequestMapping(value = "/edgesweb", method = RequestMethod.GET)
	public String listEdges(Model model) {
		List<Edge> allEdges = edgeService.retrieveAllEdge();
		model.addAttribute("edges", allEdges);
		return "edges";
	}
	
	
	  @RequestMapping("edge/{edgeId}")
	    public String viewEdge(@PathVariable Integer edgeId, Model model) {
	        model.addAttribute("edge", edgeService.retrieveEdge(edgeId));
	        return "viewedge";
	    }
	  
	    @RequestMapping("edge/delete/{edgeId}")
	    public String deleteEdge(@PathVariable Integer edgeId) {
	    	edgeService.deleteEdge(edgeId);
	        return "redirect:/edges";
	    }
	    
	    @RequestMapping(value = "edge/new", method = RequestMethod.GET)
	    public String addEdge(Model model) {
	        ShortestPath shortestPath = new ShortestPath();
	        List<Vertice> allVertices = verticeService.retrieveAllVertices();
	        model.addAttribute("edge", new Edge());
	        model.addAttribute("edgeShortestPath", shortestPath);
	        model.addAttribute("routeList", allVertices);
	        return "addedge";
	    }
	    
	    @RequestMapping(value = "edge", method = RequestMethod.POST)
	    public String saveEdge(Edge edge, @ModelAttribute ShortestPath pathModel, Model model) {
	     ;
	        edge.setSource(pathModel.getSourceVertex());
	        edge.setDestination(pathModel.getDestinationVertex());
	     /*   if (pathModel.getSourceVertex().equals(pathModel.getDestinationVertex())) {
	            buildEdgeValidation(pathModel, model, Codes.ROUTE_TO_SELF.toString());
	            return "validation";
	        }
	        if (edgeService.edgeExists(edge)) {
	            buildEdgeValidation(pathModel, model, Codes.ROUTE_EXISTS.toString());
	            return "validation";
	        }*/
	        edgeService.saveEdge(edge);
	        return "redirect:/edge/" + edge.getEdgeId();
	    }
	    
	/*    public void buildEdgeValidation(@ModelAttribute ShortestPath pathModel, Model model, String code) {
	        String message = "";
	        Codes mode = Codes.fromString(code);
	        if (mode != null) {
	            switch (mode) {
	                case ROUTE_EXISTS:
	                    String sourceName = verticeService.getVertexById(pathModel.getSourceVertex()) == null ? "" : verticeService.getVertexById(pathModel.getSourceVertex()).getName();
	                    String sourceDestination = verticeService.getVertexById(pathModel.getDestinationVertex()) == null ? "" : verticeService.getVertexById(pathModel.getDestinationVertex()).getName();
	                    message = "The route from " + sourceName + " (" + pathModel.getSourceVertex() + ") to " + sourceDestination + "(" + pathModel.getDestinationVertex() + ") exists already.";
	                    break;
	                case ROUTE_TO_SELF:
	                    message = Constants.DUPLICATE_ROUTE;
	                    break;
	                default:
	                    message = Constants.INVALID_CODE;
	                    break;
	            }
	        }
	        //
	        model.addAttribute("validationMessage", message);
	    }
*/
}
