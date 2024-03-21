package br.com.conquerors.entities;

public class LumberCamps extends Building {
	
	private Double woodPerMin;

	public Double getGoldPerMin() {
		return woodPerMin;
	}

	public void setGoldPerMin(Double goldPerMin) {
		this.woodPerMin = goldPerMin;
	}
	
	@Override
	public void increaseLevel() {
		super.increaseLevel();
		this.woodPerMin += this.woodPerMin * 0.05;
}
}
