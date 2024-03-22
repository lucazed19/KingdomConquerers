package br.com.conquerors.entities;

import br.com.conquerors.enuns.SoldierType;

public class Soldier {
	    private double strength;
	    private double health;
	    private int level;
	    private int quantity;
		private SoldierType type;
		
		public Soldier() {}
	    
	    public Soldier(double strength, double health, int level, int quantity, SoldierType type) {
			super();
			this.strength = strength;
			this.health = health;
			this.level = level;
			this.quantity = quantity;
			this.type = type;
		}

		public int getLevel() {
			return level;
		}

		public void setLevel(int level) {
			this.level = level;
		}


	    public double getStrength() {
	        return strength;
	    }

	    public void setStrength(double strength) {
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

		public void increaseLevel() {
			if (this.level <= 5) {
				if (this.type == SoldierType.ARCHER) {
					this.health = this.health + 10;
					this.strength = this.strength + 10;
					this.level++;
				} else {
					this.health = this.health + 20;
					this.strength = this.strength + 20;
					this.level++;
				}
			}
		}
}
