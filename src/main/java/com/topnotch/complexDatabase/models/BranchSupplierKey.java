package com.topnotch.complexDatabase.models;

import java.io.Serializable;

public class BranchSupplierKey implements Serializable {

	private Long branch_id;
	private String supplier_name;
	
	public BranchSupplierKey() {}
	
	public BranchSupplierKey(Long branch_id, String supplier_name ) {
		this.branch_id = branch_id;
		this.supplier_name = supplier_name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((branch_id == null) ? 0 : branch_id.hashCode());
		result = prime * result + ((supplier_name == null) ? 0 : supplier_name.hashCode());
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
		BranchSupplierKey other = (BranchSupplierKey) obj;
		if (branch_id == null) {
			if (other.branch_id != null)
				return false;
		} else if (!branch_id.equals(other.branch_id))
			return false;
		if (supplier_name == null) {
			if (other.supplier_name != null)
				return false;
		} else if (!supplier_name.equals(other.supplier_name))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "" + getBranch_id() + "_" + getSupplier_name();
	}
	
	
	public Long getBranch_id() {
		return branch_id;
	}

	public void setBranch_id(Long branch_id) {
		this.branch_id = branch_id;
	}

	public String getSupplier_name() {
		return supplier_name;
	}

	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}	
}
