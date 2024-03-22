package br.com.conquerors.enuns;

public enum SoldierType {
	ARCHER(0, "Arqueiro"), 
	WARRIOR(1, "Guerreiro"), 
	SPEARMAN(2, "Lanceiro");
	
	private int number;
	private String descricao;

	public int getNumber() {
		return number;
	}
	
	public String getDescricao() {
		return descricao;
	}

	private SoldierType(int number, String descricao) {
		this.number = number;
		this.descricao = descricao;
	}
	
	public static SoldierType getSoldierTypeByNumber(int number) {
		for (SoldierType soldierType : SoldierType.values()) {
			if (soldierType.getNumber() == number) {
				return soldierType;
			}
		}
		return null;
	}
}
