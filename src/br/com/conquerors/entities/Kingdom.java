package br.com.conquerors.entities;

import java.util.ArrayList;
import java.util.List;

public class Kingdom {
	private List<Resource> resources;
	private List<Soldier> soldiers;
	private List<DefenseTower> defenseTowers;
	private List<GoldMine> goldMines;
	private List<HeadQuarter> headQuarters;
	private List<House> houses;
	private List<IronMine> ironMines;
	private List<LumberCamps> lumberCamps;
	
	public Kingdom() {
		this.resources = new ArrayList<>();
		this.soldiers = new ArrayList<>();
		this.defenseTowers = new ArrayList<>();
		this.goldMines = new ArrayList<>();
		this.headQuarters = new ArrayList<>();
		this.houses = new ArrayList<>();
		this.ironMines = new ArrayList<>();
		this.lumberCamps = new ArrayList<>();
	}
	public Kingdom(List<Resource> resources, List<Soldier> soldiers, List<DefenseTower> defenseTowers,
			List<GoldMine> goldMines, List<HeadQuarter> headQuarters, List<House> houses, List<IronMine> ironMines,
			List<LumberCamps> lumberCamps) {
		this.resources = resources;
		this.soldiers = soldiers;
		this.defenseTowers = defenseTowers;
		this.goldMines = goldMines;
		this.headQuarters = headQuarters;
		this.houses = houses;
		this.ironMines = ironMines;
		this.lumberCamps = lumberCamps;
	}
	public List<Resource> getResources() {
		return resources;
	}
	public void setResources(List<Resource> resources) {
		this.resources = resources;
	}
	public List<Soldier> getSoldiers() {
		return soldiers;
	}
	public void setSoldiers(List<Soldier> soldiers) {
		this.soldiers = soldiers;
	}
	public List<DefenseTower> getDefenseTowers() {
		return defenseTowers;
	}
	public void setDefenseTowers(List<DefenseTower> defenseTowers) {
		this.defenseTowers = defenseTowers;
	}
	public List<GoldMine> getGoldMines() {
		return goldMines;
	}
	public void setGoldMines(List<GoldMine> goldMines) {
		this.goldMines = goldMines;
	}
	public List<HeadQuarter> getHeadQuarters() {
		return headQuarters;
	}
	public void setHeadQuarters(List<HeadQuarter> headQuarters) {
		this.headQuarters = headQuarters;
	}
	public List<House> getHouses() {
		return houses;
	}
	public void setHouses(List<House> houses) {
		this.houses = houses;
	}
	public List<IronMine> getIronMines() {
		return ironMines;
	}
	public void setIronMines(List<IronMine> ironMines) {
		this.ironMines = ironMines;
	}
	public List<LumberCamps> getLumberCamps() {
		return lumberCamps;
	}
	public void setLumberCamps(List<LumberCamps> lumberCamps) {
		this.lumberCamps = lumberCamps;
	}
	
	public int getHousesCapacity() {
		if (houses.isEmpty()) {
			return 0;
		}
		return houses.get(0).getCapacity() * houses.size();
	}
	
	public int getSoldiersQuantity() {
		int quantity = 0;
		
		for (Soldier soldier: soldiers) {
			quantity += soldier.getQuantity();
		}
		
		return quantity;
	}
	
	public void printStatus() {
		System.out.println("---------- Status do seu reino ----------");
		for (Resource resource : resources) {
			System.out.printf("%s: %s  ", resource.getType().getDescricao(), resource.getQuantity());
		}
		System.out.println();
		for (Soldier soldier : soldiers) {
			System.out.printf("%s: %s  ", soldier.getType().getDescricao(), soldier.getQuantity());
		}
		System.out.println("\n-----------------------------------------");
	}
	
}
