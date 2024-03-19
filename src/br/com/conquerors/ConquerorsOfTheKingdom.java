package br.com.conquerors;

import br.com.conquerors.entities.HeadQuarter;
import br.com.conquerors.entities.Map;
import br.com.conquerors.utils.MapUtil;

public class ConquerorsOfTheKingdom {
	public static void main(String[] args) {
		HeadQuarter hq = new HeadQuarter();
		
		Map map = MapUtil.createInitialazedMap(30, 30);
		map.printArea();
	}
	
}
