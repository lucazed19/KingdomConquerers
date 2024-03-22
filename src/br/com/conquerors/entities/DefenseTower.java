package br.com.conquerors.entities;

public class DefenseTower extends Building{
	private int archerNum;
	private double atackDamage;
	
	public DefenseTower() {
		this.archerNum = 10;
		this.atackDamage = 50;
		this.setBuildPrice(75);
	}
	
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
	public boolean increaseLevel() {
		if (super.increaseLevel()) {
			this.atackDamage += this.atackDamage * 0.05;
			this.archerNum += 5;			
			return true;
		}
		return false;
	}
}
