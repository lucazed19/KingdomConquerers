package br.com.conquerors.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

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
	
	public static Kingdom createRandomKingdomMin() {
		Kingdom kingdom = new Kingdom();
		
		kingdom.setResources(getRandomResources());
		kingdom.setHouses(new ArrayList<House>(Collections.nCopies(5, new House())));
		getRandomSoldiers(kingdom);
		
		return kingdom;
	}
	
	private static void setGold(Kingdom kingdom, int amnt) {
		kingdom.getResources().get(0).setQuantity(amnt);
	}
	
	public static void setResource(Kingdom kingdom, ResourceType resourceType, int quantity) {
		for (Resource resource : kingdom.getResources()) {
			if (resource.getType().equals(resourceType)) {
				resource.setQuantity(quantity);
			}
		}
	}
	
	public static void build(Kingdom kingdom, int type) {
		int gold = kingdom.getResources().get(0).getQuantity();
		int land = kingdom.getResources().get(3).getQuantity();
		
		switch (type) {
			case 1:
				if (gold >= kingdom.getDefenseTowers().get(0).getBuildPrice()) {
					DefenseTower tower = new DefenseTower();
					setGold(kingdom, gold - tower.getBuildPrice());
					setResource(kingdom, ResourceType.LAND, land - 1);
					
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
					setResource(kingdom, ResourceType.LAND, land - 1);
					
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
					setResource(kingdom, ResourceType.LAND, land - 1);
					
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
					setResource(kingdom, ResourceType.LAND, land - 1);
					
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
					setResource(kingdom, ResourceType.LAND, land - 1);
					
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
					setResource(kingdom, ResourceType.LAND, land - 1);
					
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
			if (soldier.getType().equals(SoldierType.ARCHER)) {
				soldier.setHealth(5);
				soldier.setStrength(15);
			} else {
				soldier.setHealth(10);
				soldier.setStrength(10);
			}
			soldier.setQuantity(random.nextInt(kingdom.getHousesCapacity() - kingdom.getSoldiersQuantity()));
			kingdom.getSoldiers().add(soldier);
		}
	}
	
	public static void trainingSoldiers(Kingdom kingdom, SoldierType soldierType, int quantity) {
		int gold = kingdom.getResources().get(0).getQuantity();
		if (gold < kingdom.getHeadQuarters().get(0).getTrainingCapacity()) {
			System.out.printf("Ouro insuficinte: %d\n", gold);
			return;
		}
		if (quantity > (kingdom.getHousesCapacity() - kingdom.getSoldiersQuantity())) {
			System.out.printf("Capacidade do reino insuficiente: %d\n", (kingdom.getHousesCapacity() - kingdom.getSoldiersQuantity()));
			return;
		}
		if (quantity > kingdom.getHeadQuartersCapacity()) {			
			System.out.printf("Capacidade dos quarteis insuficiente: %d\n", kingdom.getHeadQuartersCapacity());
			return;
		}
		for (Soldier soldier : kingdom.getSoldiers()) {
			if (soldier.getType().equals(soldierType)) {
				soldier.increaseQuantity(quantity);
				setGold(kingdom, gold - kingdom.getHeadQuarters().get(0).getTrainingCost());
				System.out.println("Tropas treinadas!");
			}
		}
	}
	
	public static void updateKingdomResourcesPerTurn(Kingdom kingdom) {
		if (!kingdom.getGoldMines().isEmpty()) {
			int gold = kingdom.getResources().get(0).getQuantity();
			int goldPerTurn = kingdom.getGoldMines().get(0).getGoldPerTurn() * kingdom.getGoldMines().size();
			setResource(kingdom, ResourceType.GOLD, gold + goldPerTurn);
		}
		if (!kingdom.getIronMines().isEmpty()) {
			int iron = kingdom.getResources().get(2).getQuantity();
			int ironPerTurn = kingdom.getIronMines().get(0).getIronPerTurn() * kingdom.getIronMines().size();
			setResource(kingdom, ResourceType.IRON, iron + ironPerTurn);
		}
		if (!kingdom.getLumberCamps().isEmpty()) {
			int wood = kingdom.getResources().get(1).getQuantity();
			int woodPerTurn = kingdom.getLumberCamps().get(0).getWoodPerTurn() * kingdom.getLumberCamps().size();
			setResource(kingdom, ResourceType.WOOD, wood + woodPerTurn);
		}
	}
	
	public static int getDefenseTowersAttack(List<DefenseTower> defenseTowers) {
		int attack = 0;
		
		for (DefenseTower defenseTower : defenseTowers) {
			attack += defenseTower.getAttackDamage();
		}
		
		return attack;
	}
	
	public static int getDefenseTowersHealth(List<DefenseTower> defenseTowers) {
		int health = 0;
		
		for (DefenseTower defenseTower : defenseTowers) {
			health += defenseTower.getHealth();
		}
		
		return health;
	}
	
	public static int getSoldiersStrength(List<Soldier> soldiers) {
		int strength = 0;
		
		for (Soldier soldier : soldiers) {
			strength += soldier.getStrength() * soldier.getQuantity();
		}
		
		return strength;
	}
	
	public static int getSoldiersHealth(List<Soldier> soldiers) {
		int health = 0;
		
		for (Soldier soldier : soldiers) {
			health += soldier.getHealth() * soldier.getQuantity();
		}
		
		return health;
	}
	
	public static void battle(Kingdom kingdom, Kingdom enemyKingdom) {
		Scanner scan = new Scanner(System.in);
		Random random = new Random();
		
		System.out.printf("Força Inimiga: %d  |  Vida Inimiga: %d\n", getSoldiersStrength(enemyKingdom.getSoldiers()), getSoldiersHealth(enemyKingdom.getSoldiers()));
		List<Soldier> soldiers = List.of(new Soldier(5, 15, 0, SoldierType.ARCHER), new Soldier(10, 10, 0, SoldierType.WARRIOR), new Soldier(10, 10, 0, SoldierType.SPEARMAN));
		if (!kingdom.getAllies().isEmpty()) {
			for (Kingdom ally : kingdom.getAllies()) {
				for (Soldier soldier : ally.getSoldiers()) {
					int quantity = random.nextInt(soldier.getQuantity());
					soldier.setQuantity(soldier.getQuantity() - quantity);
					soldiers.get(soldier.getType().getNumber()).increaseQuantity(quantity);
				}
			}
			System.out.println("Seus aliados enviaram tropas para ajudar na batalha!");
			System.out.printf("Força das tropas aliadas: %d  |  Vida das tropas aliadas: %d\n", getSoldiersStrength(soldiers), getSoldiersHealth(soldiers));
		}
		
		for (Soldier soldier : kingdom.getSoldiers()) {
			System.out.printf("Insira quantos %s deseja enviar para a batalha:.\n(FORÇA UNITÁRIA= %d) (MÁXIMO = %d)\n", soldier.getType().getDescricao(), soldier.getStrength(),soldier.getQuantity());
			int quantity = scan.nextInt();
			
			if (quantity > soldier.getQuantity()) {
				quantity = soldier.getQuantity();
				System.out.printf("Quantidade maior que a máxima. Enviando todos os %s!\n", soldier.getType().getDescricao());
			}
			
			soldier.setQuantity(soldier.getQuantity() - quantity);
			soldiers.get(soldier.getType().getNumber()).increaseQuantity(quantity);
		}
		System.out.printf("Força total: %d  |  Vida total: %d\n", getSoldiersStrength(soldiers), getSoldiersHealth(soldiers));
		
		int newEnemyHealth = getSoldiersHealth(enemyKingdom.getSoldiers()) - getSoldiersStrength(soldiers);
		int newHealth = getSoldiersHealth(soldiers) - getSoldiersStrength(enemyKingdom.getSoldiers());
		
		if (newHealth > newEnemyHealth) {
			System.out.println("Parabéns você venceu a batalha! Os recursos inimigos agora são seus!");
			System.out.println("Recursos adquiridos:");
			for (Resource resource : enemyKingdom.getResources()) {
				System.out.printf("%s: %d\n", resource.getType().getDescricao(), resource.getQuantity());
				kingdom.getResources().get(resource.getType().getNumber()).increaseQuantity(resource.getQuantity());
			}
		} else {
			System.out.println("Você perdeu a batalha! O reino inimigo saqueou seus recursos!");
			System.out.println("Recursos saqueados:");
			int resourcesQuantity = 0;
			for (Resource resource : kingdom.getResources()) {
				int quantity = random.nextInt(resource.getQuantity());
				System.out.printf("%s: %d\n", resource.getType().getDescricao(), quantity);
				kingdom.getResources().get(resource.getType().getNumber()).decreaseQuantity(quantity);
				resourcesQuantity += kingdom.getResources().get(resource.getType().getNumber()).getQuantity();
			}
			
			if (resourcesQuantity == 0) {
				System.out.println("FIM DE JOGO!! \nVocê perdeu todos os seus recursos!");
				System.exit(1);
			}
		}
	}

}
