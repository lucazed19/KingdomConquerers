package br.com.conquerors.entities;

public class GoldMine extends Building{
	private int goldPerTurn;
	
	public GoldMine() {
		this.goldPerTurn = 25;
		this.setBuildPrice(150);
	}

	public int getGoldPerTurn() {
		return goldPerTurn;
	}

	public void setGoldPerTurn(int goldPerTurn) {
		this.goldPerTurn = goldPerTurn;
	}

	@Override
	public boolean increaseLevel() {
		if (super.increaseLevel()) {
			this.goldPerTurn += this.goldPerTurn * 0.05;
			return true;
		}
		return false;
	}
	
}
