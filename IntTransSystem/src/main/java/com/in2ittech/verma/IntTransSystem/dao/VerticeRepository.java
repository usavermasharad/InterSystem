package com.in2ittech.verma.IntTransSystem.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.in2ittech.verma.IntTransSystem.entity.Vertice;

@Repository
public interface VerticeRepository extends JpaRepository<Vertice, Integer>  {
	
		/*@Query("SELECT id,vertice_id,vertice_name,update_by,update_date FROM Vertice v where v.vertice_id = :source_value") 
	    Optional<Vertice> getVertexByName(@Param("source_value") String source_value);
	*/
	
	

}