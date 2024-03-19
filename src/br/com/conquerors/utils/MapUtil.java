package br.com.conquerors.utils;

import java.util.HashMap;
import java.util.Random;

import br.com.conquerors.entities.Map;

public class MapUtil {
	public static Map createInitialazedMap(int height, int width) {
		Map map = new Map(height, width);
		Random random = new Random();
		
		int heightRandom = random.nextInt(31);
		int widhtRandom = random.nextInt(31);
		map.populateAround(widhtRandom, heightRandom, 1, 2);
		return map;
	}
	
	public static HashMap<Integer, String> createMapReliefs() {
		HashMap<Integer, String> mapReliefs = new HashMap<>();
		mapReliefs.put(0, "  ");
		mapReliefs.put(1, "**");
		return mapReliefs;
	}
}
