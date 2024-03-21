package br.com.conquerors.entities;

public class IronMine extends Building {
	
	private Double ironPerMin;

	public Double getGoldPerMin() {
		return ironPerMin;
	}

	public void setGoldPerMin(Double goldPerMin) {
		this.ironPerMin = goldPerMin;
	}
	
	@Override
	public void increaseLevel() {
		super.increaseLevel();
		this.ironPerMin += this.ironPerMin * 0.05;
}
}