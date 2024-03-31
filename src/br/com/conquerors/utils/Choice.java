package br.com.conquerors.utils;

import br.com.conquerors.interfaces.Function;

public class Choice {
	private String description;
	private Function function;
	
	public Choice(String description, Function function) {
		super();
		this.description = description;
		this.function = function;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Function getFunction() {
		return function;
	}
	public void setFunction(Function function) {
		this.function = function;
	}
}
