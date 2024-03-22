package br.com.conquerors.entities;

public class House extends Building{
	private int populationPerTurn;
	private int capacity;

	public House() {
		this.populationPerTurn = 10;
		this.capacity = 100;
		this.setBuildPrice(75);
	}

	public int getPopulationPerTurn() {
		return populationPerTurn;
	}

	public void setPopulationPerTurn(int populationPerTurn) {
		this.populationPerTurn = populationPerTurn;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public boolean increaseLevel() {
		if (super.increaseLevel()) {
			this.populationPerTurn += this.populationPerTurn * 0.05;
			this.capacity += this.capacity + 0.1;
			return true;
		}
		return false;
	}
	
}
