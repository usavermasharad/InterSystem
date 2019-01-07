package com.in2ittech.verma.IntTransSystem.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.in2ittech.verma.IntTransSystem.dao.VerticeRepository;
import com.in2ittech.verma.IntTransSystem.entity.Vertice;

@Service
public class VerticeServiceImpl implements VerticeService {

	private VerticeRepository verticeRepository;

	/**
	 * Using Constructor  injection 
	 * @param verticeRepository
	 */
	@Autowired
	public VerticeServiceImpl(VerticeRepository verticeRepository) {
		this.verticeRepository = verticeRepository;
	}

	@Override
	public List<Vertice> retrieveAllVertices() {
		return verticeRepository.findAll();
	}

	@Override
	public Optional<Vertice> retrieveVertice(Integer id) {
		return verticeRepository.findById(id);
	}

	@Override
	public void deleteVertice(Integer id) {
		verticeRepository.deleteById(id);
		
	}

	@Override
	public Vertice saveVertice(Vertice vertice) {
		return verticeRepository.save(vertice);
	}

	@Override
	public String getVertexById(String sourceVertex) {
		return null;
	}

	@Override
	public Vertice getVertexByName(String sourceValue) {
		List<Vertice> allData=   retrieveAllVertices();
		for (Vertice vertice : allData) {
			if(vertice.getVerticeId().equals(sourceValue)) {
				return vertice;
			}
		}
		return null;
	}

}
