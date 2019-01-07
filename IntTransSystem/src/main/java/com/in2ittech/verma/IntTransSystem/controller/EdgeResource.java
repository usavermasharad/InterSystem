package com.in2ittech.verma.IntTransSystem.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.in2ittech.verma.IntTransSystem.Service.EdgeService;
import com.in2ittech.verma.IntTransSystem.entity.Edge;
import com.in2ittech.verma.IntTransSystem.exception.EdgesNotFoundException;

@CrossOrigin("http://localhost:4200")
@RestController
public class EdgeResource {

	@Autowired
	private EdgeService edgeService;

	@GetMapping("/edges")
	public List<Edge> listEdges() {
		return edgeService.retrieveAllEdge();
	}

	@GetMapping("/edges/{id}")
	public Resource<Edge> retrieveEdges(@PathVariable Integer id) throws EdgesNotFoundException {
		Optional<Edge> edge = edgeService.retrieveEdge(id);
		if (!edge.isPresent())
			throw new EdgesNotFoundException("ID: " + id);
		// HATEOAS (Hypermedia as the Engine of Application State)
		Resource<Edge> resource = new Resource<Edge>(edge.get());
		// Link for hyper media :
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listEdges());
		resource.add(linkTo.withRel("all-edges"));

		return resource;

	}

	@DeleteMapping("/edges/{id}")
	public void deleteEdges(@PathVariable Integer id) {
		edgeService.deleteEdge(id);
	}

	@PostMapping("/edges/create")
	public ResponseEntity<Void> createEdge(@Valid @RequestBody Edge edge) {
		Edge savedEdge = edgeService.saveEdge(edge);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{edgeId}").buildAndExpand(savedEdge.getEdgeId()).toUri();
		System.out.println(location.toString());
		return ResponseEntity.created(location).build();

	}
	
	@PutMapping("/edges/update/{id}")
	public ResponseEntity<Edge> updateEdge(
			@PathVariable Integer id, @RequestBody Edge edge){
		
		Optional<Edge> findEdge =edgeService.retrieveEdge(id);
		Edge e=null;;
		if(findEdge.isPresent()) {
			e =findEdge.get();
		
			e.setDistance(edge.getDistance());
			e.setDestination(edge.getDestination());
			e.setSource(edge.getSource());
			e.setUpdateBy(edge.getUpdateBy());
			e.setUpdateTimestamp(e.getUpdateTimestamp());
		}
		
		Edge savedEdge = edgeService.saveEdge(e);
		
		return new ResponseEntity<Edge>(e, HttpStatus.OK);
	}
	
}
