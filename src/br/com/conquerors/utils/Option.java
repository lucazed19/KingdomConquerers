package br.com.conquerors.utils;

import java.util.HashMap;
import java.util.Map;

import br.com.conquerors.interfaces.Function;

public class Option {
	private String description;
	private Map<String, Function> choices;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Map<String, Function> getChoices() {
		return choices;
	}
	public void setChoices(Map<String, Function> choices) {
		this.choices = choices;
	}
}
