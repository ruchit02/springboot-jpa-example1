package com.topnotch.complexDatabase.models;

import java.io.Serializable;

public class WorksWithKey implements Serializable{

	private Long emp_id;
	private Long client_id;
	
	public WorksWithKey() {}
	
	public WorksWithKey(Long emp_id, Long client_id) {
		this.emp_id = emp_id;
		this.client_id = client_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((client_id == null) ? 0 : client_id.hashCode());
		result = prime * result + ((emp_id == null) ? 0 : emp_id.hashCode());
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
		WorksWithKey other = (WorksWithKey) obj;
		if (client_id == null) {
			if (other.client_id != null)
				return false;
		} else if (!client_id.equals(other.client_id))
			return false;
		if (emp_id == null) {
			if (other.emp_id != null)
				return false;
		} else if (!emp_id.equals(other.emp_id))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "" + getEmp_id() + "_" + getClient_id();
	}

	public Long getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(Long emp_id) {
		this.emp_id = emp_id;
	}

	public Long getClient_id() {
		return client_id;
	}

	public void setClient_id(Long client_id) {
		this.client_id = client_id;
	}
}
