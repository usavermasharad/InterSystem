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

import com.in2ittech.verma.IntTransSystem.Service.TrafficService;
import com.in2ittech.verma.IntTransSystem.entity.Traffic;
import com.in2ittech.verma.IntTransSystem.entity.Vertice;
import com.in2ittech.verma.IntTransSystem.exception.TrafficNotFoundException;

@CrossOrigin("http://localhost:4200")
@RestController
public class TrafficResource {

	
	@Autowired
	private TrafficService trafficService;

	@GetMapping("/traffics")
	public List<Traffic> listTraffics() {
		return trafficService.retrieveAllTraffic();

	}
	
	
	@GetMapping("/traffics/{id}")
	public  Resource<Traffic> retrieveTraffic(@PathVariable Long id) throws TrafficNotFoundException {
		Optional<Traffic>  traffic =trafficService.retrieveTraffic(id);
		if(!traffic.isPresent())
			throw new TrafficNotFoundException("ID: "+id);
		//HATEOAS (Hypermedia as the Engine of Application State) 
		Resource<Traffic> resource = new Resource<Traffic>(traffic.get());
		// Link for hyper media :
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listTraffics());
		resource.add(linkTo.withRel("all-traffic"));
		
		return resource;
		
	}
	
	@DeleteMapping("/traffic/{id}")
	public void deleteVertice(@PathVariable Long id) {
		trafficService.deleteTraffic(id);
	}
	
	
	@PostMapping("/traffics/create")
	public ResponseEntity<Object> createTraffic(@Valid @RequestBody Traffic traffic) {
		Traffic savedTraffic = trafficService.saveTraffic(traffic);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedTraffic.getRouteId())
				.toUri();

		return ResponseEntity.created(location).build();

	}
	
	@PutMapping("/traffics/update/{id}")
	public ResponseEntity<Traffic> updateTraffice(@PathVariable Long id, @RequestBody Traffic traffic) {
		Optional<Traffic>  findTraffic =trafficService.retrieveTraffic(id);
		Traffic v = null;
		
		if (findTraffic.isPresent()) {
			v = findTraffic.get();
			v.setDestination(traffic.getDestination());
			v.setSource(traffic.getSource());
			v.setTimeDelay(traffic.getTimeDelay());
			v.setUpdateBy(traffic.getUpdateBy());
			v.setUpdateTimestamp(traffic.getUpdateTimestamp());
		}

		Traffic savedTraffic = trafficService.saveTraffic(v);

		return new ResponseEntity<Traffic>(v, HttpStatus.OK);
	}
}
