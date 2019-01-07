package com.in2ittech.verma.IntTransSystem.Service;

import java.util.List;
import java.util.Optional;


import com.in2ittech.verma.IntTransSystem.entity.Traffic;

public interface TrafficService {
	List <Traffic> retrieveAllTraffic();
	public Optional<Traffic> retrieveTraffic(Long id);
	void deleteTraffic(Long id);
	Traffic saveTraffic(Traffic traffic);
	
}
