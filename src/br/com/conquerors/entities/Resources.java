package br.com.conquerors.entities;

import br.com.conquerors.enuns.ResourcesType;

public class Resources {
	
	private int quantity;
	private ResourcesType type;
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public ResourcesType getType() {
		return type;
	}
	public void setType(ResourcesType type) {
		this.type = type;
	}
	
	
}
