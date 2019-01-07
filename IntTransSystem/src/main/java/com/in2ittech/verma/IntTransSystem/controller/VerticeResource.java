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
import com.in2ittech.verma.IntTransSystem.Service.VerticeService;
import com.in2ittech.verma.IntTransSystem.entity.Edge;
import com.in2ittech.verma.IntTransSystem.entity.Vertice;
import com.in2ittech.verma.IntTransSystem.exception.VerticeNotFoundException;

@CrossOrigin("http://localhost:4200")
@RestController
public class VerticeResource {

	@Autowired
	private VerticeService verticeService;

	@GetMapping("/vertices")
	public List<Vertice> listVertices() {
		return verticeService.retrieveAllVertices();

	}

	@GetMapping("/vertices/{id}")
	public Resource<Vertice> retrieveVertice(@PathVariable Integer id) throws VerticeNotFoundException {
		Optional<Vertice> vertice = verticeService.retrieveVertice(id);
		if (!vertice.isPresent())
			throw new VerticeNotFoundException("ID: " + id);
		// HATEOAS (Hypermedia as the Engine of Application State)
		Resource<Vertice> resource = new Resource<Vertice>(vertice.get());
		// Link for hyper media :
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listVertices());
		resource.add(linkTo.withRel("all-vertices"));

		return resource;

	}

	@DeleteMapping("/vertices/{id}")
	public void deleteVertice(@PathVariable Integer id) {
		verticeService.deleteVertice(id);
	}

	@PostMapping("/vertices/create")
	public ResponseEntity<Void> createVertice(@Valid @RequestBody Vertice vertice) {
		Vertice savedVertice = verticeService.saveVertice(vertice);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedVertice.getId()).toUri();
		return ResponseEntity.created(location).build();

	}

	@PutMapping("/vertices/update/{id}")
	public ResponseEntity<Vertice> updateVertice(@PathVariable Integer id, @RequestBody Vertice vertice) {
		Optional<Vertice> findVertice = verticeService.retrieveVertice(id);
		Vertice v = null;
		;
		if (findVertice.isPresent()) {
			v = findVertice.get();
			v.setVerticeId(vertice.getVerticeId());
			v.setVerticeName(vertice.getVerticeName());
			v.setUpdateBy(vertice.getUpdateBy());
			v.setUpdateDate(vertice.getUpdateDate());
		}

		Vertice savedVertice = verticeService.saveVertice(v);

		return new ResponseEntity<Vertice>(v, HttpStatus.OK);
	}

}
