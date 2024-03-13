package br.com.conquerors.entities;

public class GoldMine extends Building{
	private Double goldPerMin;

	public Double getGoldPerMin() {
		return goldPerMin;
	}

	public void setGoldPerMin(Double goldPerMin) {
		this.goldPerMin = goldPerMin;
	}
	
	@Override
	public void increaseLevel() {
		super.increaseLevel();
		this.goldPerMin += this.goldPerMin * 0.05;
	}
	
}
