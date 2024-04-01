package br.com.conquerors.entities;

import br.com.conquerors.enuns.SoldierType;

public class Soldier {
	    private int strength;
	    private double health;
	    private int quantity;
		private SoldierType type;
		
		public Soldier() {}
	    
	    public Soldier(int strength, double health, int quantity, SoldierType type) {
			super();
			this.strength = strength;
			this.health = health;
			this.quantity = quantity;
			this.type = type;
		}

	    public int getStrength() {
	        return strength;
	    }

	    public void setStrength(int strength) {
	        this.strength = strength;
	    }

	    public double getHealth() {
	        return health;
	    }

	    public void setHealth(double health) {
	        this.health = health;
	    }

		public SoldierType getType() {
			return type;
		}

		public void setType(SoldierType type) {
			this.type = type;
		}
		
		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		
		public void increaseQuantity(int quantity) {
			this.quantity += quantity;
		}
}
