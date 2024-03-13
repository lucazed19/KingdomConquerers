package br.com.conquerors.entities;

public class HeadQuarter extends Building{
	private Double trainingCost;
	private Integer trainingDuration;
	private Integer trainingCapacity;
	
	public HeadQuarter() {}
	public Double getTrainingCost() {
		return trainingCost;
	}
	public void setTrainingCost(Double trainingCost) {
		this.trainingCost = trainingCost;
	}
	public Integer getTrainingDuration() {
		return trainingDuration;
	}
	public void setTrainingDuration(Integer trainingDuration) {
		this.trainingDuration = trainingDuration;
	}
	public Integer getTrainingCapacity() {
		return trainingCapacity;
	}
	public void setTrainingCapacity(Integer trainingCapacity) {
		this.trainingCapacity = trainingCapacity;
	}
	
}
