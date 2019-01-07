package com.in2ittech.verma.IntTransSystem.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Edge {

	@Id
	@GeneratedValue
	 private Integer edgeId;
	  private String source;
	  private String destination;
	  private Double distance;
	  private Double timeDelay;
	  private String updateBy;
	  private Date updateTimestamp;
	
	

	  
	
	public Edge() {
		//super();
	}


	
	public Edge(Integer edgeId, String source, String destination, Double distance, String updateBy,
			Date updateTimestamp) {
		super();
		this.edgeId = edgeId;
		this.source = source;
		this.destination = destination;
		this.distance = distance;
		this.updateBy = updateBy;
		this.updateTimestamp = updateTimestamp;
	}



	public Integer getEdgeId() {
		return edgeId;
	}
	public void setEdgeId(Integer edgeId) {
		this.edgeId = edgeId;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public Double getDistance() {
		return distance;
	}
	public void setDistance(Double distance) {
		this.distance = distance;
	}
	
	public String getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	public Date getUpdateTimestamp() {
		return updateTimestamp;
	}
	public void setUpdateTimestamp(Date updateTimestamp) {
		this.updateTimestamp = updateTimestamp;
	}

	

	public Double getTimeDelay() {
		return timeDelay;
	}



	public void setTimeDelay(Double timeDelay) {
		this.timeDelay = timeDelay;
	}



	@Override
	public String toString() {
		return "Edge [edgeId=" + edgeId + ", source=" + source + ", destination=" + destination + ", distance="
				+ distance + ", updateBy=" + updateBy + ", updateTimestamp="
				+ updateTimestamp + "]";
	}
	
	  
	  
	  
	  
}
