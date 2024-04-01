package br.com.conquerors.entities;

public class DefenseTower extends Building{
	private int attackDamage;
	private int health;
	
	public DefenseTower() {
		this.attackDamage = 350;
		this.health = 350;
		this.setBuildPrice(75);
	}

	public int getAttackDamage() {
		return attackDamage;
	}

	public void setAttackDamage(int atackDamage) {
		this.attackDamage = atackDamage;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	@Override
	public boolean increaseLevel() {
		if (super.increaseLevel()) {
			this.attackDamage += this.attackDamage * 0.05;	
			this.health += this.health * 0.05;
			return true;
		}
		return false;
	}
}
