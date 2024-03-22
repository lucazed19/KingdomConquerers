package br.com.conquerors.enuns;

public enum ResourceType {
	GOLD(0, "Ouro"), 
	WOOD(1, "Madeira"), 
	IRON(2, "Ferro"), 
	LAND(3, "Terra");
	
	private int number;
	private String descricao;

	public int getNumber() {
		return number;
	}
	
	public String getDescricao() {
		return descricao;
	}

	private ResourceType(int number, String descricao) {
		this.number = number;
		this.descricao = descricao;
	}
	
	public static ResourceType getResourceTypeByNumber(int number) {
		for (ResourceType resourceType : ResourceType.values()) {
			if (resourceType.getNumber() == number) {
				return resourceType;
			}
		}
		return null;
	}
	
	
}
