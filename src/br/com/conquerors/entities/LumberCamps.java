package br.com.conquerors.entities;

public class LumberCamps extends Building {
	private int woodPerTurn;

	public LumberCamps() {
		this.woodPerTurn = 25;
		this.setBuildPrice(150);
	}
	
	public int getWoodPerTurn() {
		return woodPerTurn;
	}

	public void setWoodPerTurn(int woodPerTurn) {
		this.woodPerTurn = woodPerTurn;
	}
	
	@Override
	public boolean increaseLevel() {
		if (super.increaseLevel()) {			
			this.woodPerTurn += this.woodPerTurn * 0.05;
			return true;
		}
		return false;
}
}
