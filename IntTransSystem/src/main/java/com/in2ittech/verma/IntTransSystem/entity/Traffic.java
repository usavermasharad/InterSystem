package com.in2ittech.verma.IntTransSystem.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Traffic {
	@Id
	@GeneratedValue
	private Long routeId;
	private String source;
	private String destination;
	private Double timeDelay;
	private String updateBy;
	private Date updateTimestamp;

	
	
	public Traffic() {
		//super();
	}

	public Traffic(Long routeId, String source, String destination, Double timeDelay, String updateBy,
			Date updateTimestamp) {
		super();
		this.routeId = routeId;
		this.source = source;
		this.destination = destination;
		this.timeDelay = timeDelay;
		this.updateBy = updateBy;
		this.updateTimestamp = updateTimestamp;
	}

	public Long getRouteId() {
		return routeId;
	}

	public void setRouteId(Long routeId) {
		this.routeId = routeId;
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

	public Double getTimeDelay() {
		return timeDelay;
	}

	public void setTimeDelay(Double timeDelay) {
		this.timeDelay = timeDelay;
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

	@Override
	public String toString() {
		return "Traffic [routeId=" + routeId + ", source=" + source + ", destination=" + destination + ", timeDelay="
				+ timeDelay + ", updateBy=" + updateBy + ", updateTimestamp=" + updateTimestamp + "]";
	}

	
}
