package com.in2ittech.verma.IntTransSystem.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Vertice {
	@Id
	@GeneratedValue
	private Integer id;
	private String verticeId;
	private String verticeName;
	private String updateBy;
	private Date  updateDate;

	
	
	public Vertice() {
		//super();
	}
	public Vertice(String verticeId, String verticeName, String updateBy, Date updateDate) {
		super();
		this.verticeId = verticeId;
		this.verticeName = verticeName;
		this.updateBy = updateBy;
		this.updateDate = updateDate;
	}

	
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}

	public String getVerticeId() {
		return verticeId;
	}

	public void setVerticeId(String verticeId) {
		this.verticeId = verticeId;
	}

	public String getVerticeName() {
		return verticeName;
	}

	public void setVerticeName(String verticeName) {
		this.verticeName = verticeName;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	

	public Date getUpdateDate() {
		return updateDate;
	}






	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}






	@Override
	public String toString() {
		return "Vertice [verticeId=" + verticeId + ", verticeName=" + verticeName + ", updateBy=" + updateBy
				+ ", updateDate=" + updateDate + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((verticeId == null) ? 0 : verticeId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vertice other = (Vertice) obj;
		if (verticeId == null) {
			if (other.verticeId != null)
				return false;
		} else if (!verticeId.equals(other.verticeId))
			return false;
		return true;
	}

	
	
	
}
