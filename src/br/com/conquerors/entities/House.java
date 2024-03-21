package br.com.conquerors.entities;

public class House extends Building{
	
	private int populationPerMin = 10;

	public int getPopulationPerMin() {
		return populationPerMin;
	}

	public void setPopulationPerMin(int populationPerMin) {
		this.populationPerMin = populationPerMin;
	}
	
	@Override
	public void increaseLevel() {
		super.increaseLevel();
		this.populationPerMin+= this.populationPerMin + 5;
	}
	
}
