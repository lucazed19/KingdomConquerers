package br.com.conquerors.entities;

public class HeadQuarter extends Building{
	private int trainingCost;
	private int trainingCapacity;
	
	public HeadQuarter() {
		this.trainingCost = 10;
		this.trainingCapacity = 50;
		this.setBuildPrice(75);
	}

	public int getTrainingCost() {
		return trainingCost;
	}

	public void setTrainingCost(int trainingCost) {
		this.trainingCost = trainingCost;
	}

	public int getTrainingCapacity() {
		return trainingCapacity;
	}

	public void setTrainingCapacity(int trainingCapacity) {
		this.trainingCapacity = trainingCapacity;
	}

	@Override
	public boolean increaseLevel() {
		if (super.increaseLevel()) {
			this.trainingCost += this.trainingCost * 0.05;
			this.trainingCapacity += this.trainingCapacity * 0.10;
		}
		return false; 
	}
	
	
	
}
