package br.com.conquerors.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import br.com.conquerors.entities.DefenseTower;
import br.com.conquerors.entities.GoldMine;
import br.com.conquerors.entities.HeadQuarter;
import br.com.conquerors.entities.House;
import br.com.conquerors.entities.IronMine;
import br.com.conquerors.entities.Kingdom;
import br.com.conquerors.entities.LumberCamps;
import br.com.conquerors.entities.Resource;
import br.com.conquerors.entities.Soldier;
import br.com.conquerors.enuns.ResourceType;
import br.com.conquerors.enuns.SoldierType;

public class KingdomUtil {
	public static Kingdom createRandomKingdom() {
		Kingdom kingdom = new Kingdom();
		Random random = new Random();
		
		kingdom.setResources(getRandomResources());
		kingdom.setHouses(new ArrayList<House>(Collections.nCopies(5, new House())));
		kingdom.setDefenseTowers(new ArrayList<DefenseTower>(Collections.nCopies(12, new DefenseTower())));
		kingdom.setGoldMines(new ArrayList<GoldMine>(Collections.nCopies(random.nextInt(2), new GoldMine())));
		kingdom.setIronMines(new ArrayList<IronMine>(Collections.nCopies(random.nextInt(2), new IronMine())));
		kingdom.setLumberCamps(new ArrayList<LumberCamps>(Collections.nCopies(random.nextInt(2), new LumberCamps())));
		kingdom.setHeadQuarters(new ArrayList<HeadQuarter>(Collections.nCopies(2, new HeadQuarter())));
		getRandomSoldiers(kingdom);
		
		return kingdom;
	}
	
	private static List<Resource> getRandomResources() {
		List<Resource> resources = new ArrayList<Resource>();
		
		Random random = new Random();
		for (int i = 0; i < 4; i++) {
			Resource resource = new Resource();
			resource.setType(ResourceType.getResourceTypeByNumber(i));
			if (resource.getType().equals(ResourceType.LAND)) {				
				resource.setQuantity(random.nextInt(10));				
			} else {
				resource.setQuantity(random.nextInt(50) + 50);				
			}
			resources.add(resource);
		}
		
		return resources;
	}
	
	private static void getRandomSoldiers(Kingdom kingdom) {
		Random random = new Random();
		for (int i = 0; i < 3; i++) {
			Soldier soldier = new Soldier();
			soldier.setType(SoldierType.getSoldierTypeByNumber(i));
			soldier.setQuantity(random.nextInt(kingdom.getHousesCapacity() - kingdom.getSoldiersQuantity()));
			kingdom.getSoldiers().add(soldier);
		}
	}

}
