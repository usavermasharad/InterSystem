package com.in2ittech.verma.IntTransSystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.in2ittech.verma.IntTransSystem.entity.Edge;

@Repository
public interface EdgeRepository extends JpaRepository<Edge, Integer>  {

}
