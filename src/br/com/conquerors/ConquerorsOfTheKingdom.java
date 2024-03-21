package br.com.conquerors;

import br.com.conquerors.entities.HeadQuarter;
import br.com.conquerors.entities.Soldiers;
import br.com.conquerors.enuns.SoldierType;

public class ConquerorsOfTheKingdom {
	public static void main(String[] args) {
		HeadQuarter hq = new HeadQuarter();
        Soldiers archer = new Soldiers(SoldierType.ARCHER, 10, 30, 50);
        Soldiers gladiator = new Soldiers(SoldierType.WARRIOR, 25, 70, 5);
        Soldiers spearman = new Soldiers(SoldierType.SPEARMAN, 30, 50, 10);
	}
}
