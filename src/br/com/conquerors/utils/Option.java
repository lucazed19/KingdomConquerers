package br.com.conquerors.utils;

public class Option {
	private String description;
	private Choice[] choices;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Choice[] getChoices() {
		return choices;
	}
	public void setChoices(Choice[] choices) {
		this.choices = choices;
	}
}
