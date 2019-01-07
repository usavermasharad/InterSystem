package com.in2ittech.verma.IntTransSystem.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in2ittech.verma.IntTransSystem.dao.EdgeRepository;
import com.in2ittech.verma.IntTransSystem.entity.Edge;

@Service
public class EdgeServiceImpl implements EdgeService {

	private EdgeRepository edgeRepository;

	@Autowired
	public EdgeServiceImpl(EdgeRepository edgeRepository) {
		this.edgeRepository = edgeRepository;
	}

	@Override
	public List<Edge> retrieveAllEdge() {
		return edgeRepository.findAll();
	}

	@Override
	public Optional<Edge> retrieveEdge(Integer id) {

		return edgeRepository.findById(id);
	}

	@Override
	public void deleteEdge(Integer id) {
		edgeRepository.deleteById(id);

	}

	@Override
	public Edge saveEdge(Edge edge) {
		// TODO Auto-generated method stub
		return edgeRepository.save(edge);
	}

}
