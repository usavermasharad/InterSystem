package com.in2ittech.verma.IntTransSystem.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.in2ittech.verma.IntTransSystem.dao.TrafficRepository;
import com.in2ittech.verma.IntTransSystem.entity.Traffic;

@Service
public class TrafficServiceImpl implements TrafficService {

	private TrafficRepository trafficRepository;
	
	public TrafficServiceImpl(TrafficRepository trafficRepository) {
		this.trafficRepository=trafficRepository;
	}

	@Override
	public List<Traffic> retrieveAllTraffic() {
		return trafficRepository.findAll();
	}

	@Override
	public Optional<Traffic> retrieveTraffic(Long id) {
		return trafficRepository.findById(id);
	}

	@Override
	public void deleteTraffic(Long id) {
		trafficRepository.deleteById(id);

	}

	@Override
	public Traffic saveTraffic(Traffic traffic) {
		return trafficRepository.save(traffic);
	}

}
