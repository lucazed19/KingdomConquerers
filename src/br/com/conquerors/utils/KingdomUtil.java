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
		
		kingdom.setResources(getRandomResources());
		kingdom.setHouses(new ArrayList<House>(Collections.nCopies(5, new House())));
		kingdom.setDefenseTowers(new ArrayList<DefenseTower>(Collections.nCopies(12, new DefenseTower())));
		kingdom.setGoldMines(new ArrayList<GoldMine>(Collections.nCopies(2, new GoldMine())));
		kingdom.setIronMines(new ArrayList<IronMine>(Collections.nCopies(2, new IronMine())));
		kingdom.setLumberCamps(new ArrayList<LumberCamps>(Collections.nCopies(2, new LumberCamps())));
		kingdom.setHeadQuarters(new ArrayList<HeadQuarter>(Collections.nCopies(2, new HeadQuarter())));
		getRandomSoldiers(kingdom);
		
		return kingdom;
	}
	
	private static void setGold(Kingdom kingdom, int amnt) {
		kingdom.getResources().get(0).setQuantity(amnt);
	}
	
	public static void build(Kingdom kingdom, int type) {
		int gold = kingdom.getResources().get(0).getQuantity();
		
		switch (type) {
			case 1:
				if (gold >= kingdom.getDefenseTowers().get(0).getBuildPrice()) {
					DefenseTower tower = new DefenseTower();
					setGold(kingdom, gold - tower.getBuildPrice());
					
					kingdom.addDefenseTower(tower);
					System.out.println("Torre de defesa construída.");
				} else {
					System.out.printf("Ouro insuficinte: %d\n", gold);
				}
				break;
			case 2:
				if (gold >= kingdom.getGoldMines().get(0).getBuildPrice()) {
					GoldMine mine = new GoldMine();
					setGold(kingdom, gold - mine.getBuildPrice());
					
					kingdom.addGoldMine(mine);
					System.out.println("Mina de ouro construída.");
				} else {
					System.out.printf("Ouro insuficinte: %d\n", gold);
				}
				break;
			case 3:
				if (gold >= kingdom.getHeadQuarters().get(0).getBuildPrice()) {
					HeadQuarter hq = new HeadQuarter();
					setGold(kingdom, gold - hq.getBuildPrice());
					
					kingdom.addHeadQuarter(hq);
					System.out.println("Quartel construído.");
				} else {
					System.out.printf("Ouro insuficinte: %d\n", gold);
				}
				break;
			case 4:
				if (gold >= kingdom.getHouses().get(0).getBuildPrice()) {
					House house = new House();
					setGold(kingdom, gold - house.getBuildPrice());
					
					kingdom.addHouse(house);
					System.out.println("Casa construída.");
				} else {
					System.out.printf("Ouro insuficinte: %d\n", gold);
				}
				break;
			case 5:
				if (gold >= kingdom.getIronMines().get(0).getBuildPrice()) {
					IronMine mine = new IronMine();
					setGold(kingdom, gold - mine.getBuildPrice());
					
					kingdom.addIronMine(mine);
					System.out.println("Mina de ferro construída.");
				} else {
					System.out.printf("Ouro insuficinte: %d\n", gold);
				}
				break;
			case 6:
				if (gold >= kingdom.getLumberCamps().get(0).getBuildPrice()) {
					LumberCamps camp = new LumberCamps();
					setGold(kingdom, gold - camp.getBuildPrice());
					
					kingdom.addLumberCamp(camp);
					System.out.println("Acampamento construído.");
				} else {
					System.out.printf("Ouro insuficinte: %d\n", gold);
				}
				break;
            default:
                System.out.println("Construção inválida.");
		}
	}
	
	public static void upgrade(Kingdom kingdom, int type) {
		int gold = kingdom.getResources().get(0).getQuantity();
		
		switch (type) {
			case 1:
				List<DefenseTower> towers = kingdom.getDefenseTowers();
				
				if (gold >= towers.get(0).getBuildPrice()) {
					for (DefenseTower tower : towers) {
						tower.increaseLevel();
					}
					
					setGold(kingdom, gold - towers.get(0).getBuildPrice());
					System.out.println("Torres de defesa atualizadas.");
				} else {
					System.out.printf("Ouro insuficinte: %d\n", gold);
				}
				break;
			case 2:
				List<GoldMine> goldMines = kingdom.getGoldMines();
				
				if (gold >= goldMines.get(0).getBuildPrice()) {
					for (GoldMine mine : goldMines) {
						mine.increaseLevel();
					}
					
					setGold(kingdom, gold - goldMines.get(0).getBuildPrice());
					System.out.println("Minas de ouro atualizadas.");
				} else {
					System.out.printf("Ouro insuficinte: %d\n", gold);
				}
				break;
			case 3:
				List<HeadQuarter> hqs = kingdom.getHeadQuarters();
				
				if (gold >= hqs.get(0).getBuildPrice()) {
					for (HeadQuarter hq : hqs) {
						hq.increaseLevel();
					}
					
					setGold(kingdom, gold - hqs.get(0).getBuildPrice());
					System.out.println("Quartéis atualizados.");
				} else {
					System.out.printf("Ouro insuficinte: %d\n", gold);
				}
				break;
			case 4:
				List<House> houses = kingdom.getHouses();
				
				if (gold >= houses.get(0).getBuildPrice()) {
					for (House house : houses) {
						house.increaseLevel();
					}
					
					setGold(kingdom, gold - houses.get(0).getBuildPrice());
					System.out.println("Casas atualizadas.");
				} else {
					System.out.printf("Ouro insuficinte: %d\n", gold);
				}
				break;
			case 5:
				List<IronMine> ironMines = kingdom.getIronMines();
				
				if (gold >= ironMines.get(0).getBuildPrice()) {
					for (IronMine mine : ironMines) {
						mine.increaseLevel();
					}
					
					setGold(kingdom, gold - ironMines.get(0).getBuildPrice());
					System.out.println("Minas de ferro atualizadas.");
				} else {
					System.out.printf("Ouro insuficinte: %d\n", gold);
				}
				break;
			case 6:
				List<LumberCamps> lumberCamps = kingdom.getLumberCamps();
				
				if (gold >= lumberCamps.get(0).getBuildPrice()) {
					for (LumberCamps camp : lumberCamps) {
						camp.increaseLevel();
					}
					
					setGold(kingdom, gold - lumberCamps.get(0).getBuildPrice());
					System.out.println("Acampamentos atualizados.");
				} else {
					System.out.printf("Ouro insuficinte: %d\n", gold);
				}
				break;
            default:
                System.out.println("Construção inválida.");
		}
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
