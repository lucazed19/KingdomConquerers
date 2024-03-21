package br.com.conquerors.entities;

import br.com.conquerors.enuns.SoldierType;

public class Soldiers {
	    private double strength;
	    private double health;
	    private double range;
	    private int level;
		private SoldierType type;

	    public Soldiers(SoldierType type,double strength, double health, double range) {
	        this.type = type;
	    	this.strength = strength;
	        this.health = health;
	        this.range = range;
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

	    public double getRange() {
	        return range;
	    }

	    public void setRange(double range) {
	        this.range = range;
	    }

		public SoldierType getType() {
			return type;
		}

		public void setType(SoldierType type) {
			this.type = type;
		}
		
		// Spearmans e Warriors terão o mesmo sistema de melhoria
		
		public void IncreaseLevel() {
			
			if (this.level == 5) {
				System.out.println("A tropa se encontra no level maximo");
				return;
			}
			
			if (this.type == SoldierType.ARCHER) {
				this.health = this.health + 10;
				this.strength = this.strength + 10;
				this.range = this.range + 20;
				this.level++;
			} else {
				this.health = this.health + 20;
				this.strength = this.strength + 20;
				this.range = this.range + 0.5;
				this.level++;
			}
		}
}
