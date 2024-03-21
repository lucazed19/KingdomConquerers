package br.com.conquerors.entities;

public class DefenseTower extends Building{
	/*
	private Double life;
	private Double buildPrice;
	private Double buildTime;
	private Integer capacity;
	private Integer level;
	*/
	
	private int archerNum;
	private double atackDamage;

	
	public int getArcherNum() {
		return archerNum;
	}

	public void setArcherNum(int archerNum) {
		this.archerNum = archerNum;
	}

	public double getAtackDamage() {
		return atackDamage;
	}

	public void setAtackDamage(double atackDamage) {
		this.atackDamage = atackDamage;
	}

	@Override
	public void increaseLevel() {
		super.increaseLevel();
		this.atackDamage++;
		this.archerNum++;
		
	}
}
