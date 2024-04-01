package br.com.conquerors.entities;

import br.com.conquerors.enuns.ResourceType;

public class Resource {
	private int quantity;
	private ResourceType type;
	
	public Resource() {}
	public Resource(int quantity, ResourceType type) {
		super();
		this.quantity = quantity;
		this.type = type;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void increaseQuantity(int quantity) {
		this.quantity += quantity;
	}
	public void decreaseQuantity(int quantity) {
		this.quantity -= quantity;
	}
	public ResourceType getType() {
		return type;
	}
	public void setType(ResourceType type) {
		this.type = type;
	}
	
	
}
