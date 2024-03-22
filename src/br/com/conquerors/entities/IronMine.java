package br.com.conquerors.entities;

public class IronMine extends Building {
	
	private int ironPerTurn;
	
	public IronMine() {
		this.ironPerTurn = 25;
		this.setBuildPrice(150);
	}

	public int getIronPerTurn() {
		return ironPerTurn;
	}

	public void setIronPerTurn(int ironPerTurn) {
		this.ironPerTurn = ironPerTurn;
	}

	@Override
	public boolean increaseLevel() {
		if (super.increaseLevel()) {
			this.ironPerTurn += this.ironPerTurn * 0.05;
			return true;
		}
		return false;
	}
}