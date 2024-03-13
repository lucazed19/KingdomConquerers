package br.com.conquerors.entities;

public abstract class Building {
	private Double life;
	private Double buildPrice;
	private Double buildTime;
	private Integer capacity;
	private Integer level;
	
	public Building() {
		this.level = 1; 
	}
	public Double getLife() {
		return life;
	}
	public void setLife(Double life) {
		this.life = life;
	}
	public Double getBuildPrice() {
		return buildPrice;
	}
	public void setBuildPrice(Double buildPrice) {
		this.buildPrice = buildPrice;
	}
	public Double getBuildTime() {
		return buildTime;
	}
	public void setBuildTime(Double buildTime) {
		this.buildTime = buildTime;
	}
	public Integer getCapacity() {
		return capacity;
	}
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	
	public void increaseLevel() {
		this.level++;
		this.life += this.life * 0.1;
		this.capacity += Integer.valueOf((int) (this.capacity * 0.15));
	}
	
}
