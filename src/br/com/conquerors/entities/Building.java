package br.com.conquerors.entities;

public abstract class Building {
	private int buildPrice;
	private int level;
	
	public Building() {
		this.level = 1; 
	}
	public int getBuildPrice() {
		return buildPrice;
	}
	public void setBuildPrice(int buildPrice) {
		this.buildPrice = buildPrice;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public boolean increaseLevel() {
		if (this.level <= 5) {			
			this.level++;
			return true;
		}
		return false;
	}
	
}
