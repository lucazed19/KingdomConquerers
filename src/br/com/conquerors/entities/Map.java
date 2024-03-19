package br.com.conquerors.entities;

import java.util.HashMap;

import br.com.conquerors.utils.MapUtil;


public class Map {
	private int[][] area;
	
	public Map() {};

	public Map(int height, int width) {
		this.area = new int[height][width];
	}

	public int[][] getArea() {
		return area;
	}

	public void setArea(int[][] area) {
		this.area = area;
	}
	
	public void setValuesIntoArea(int height, int width, int value) {
		this.area[height][width] = value;
	}
	
	public void populateAround(int height, int width, int value,int size) {
		for (int i = height - size; i <= height + size; i++) {
			for (int j = width - size; j <= width + size; j++) {
				try {
					this.area[i][j] = value;					
				} catch (Exception e) {
					
				}
			}
		}
	}
	
	public void printArea() {
		HashMap<Integer, String> mapReliefs = MapUtil.createMapReliefs();
		for (int i = 0; i <= area.length; i++) {
			for (int j =  0; j <= area[0].length; j++) {
				if (i == 0) {
		            System.out.printf("%2d ", j);
		        } else if (j == 0) {
		            System.out.printf("%2d ", i);
				} else {
					System.out.print(mapReliefs.get(area[i-1][j-1]) + " ");					
				}
			}
			System.out.println();
		}
	}
	
	public boolean isPositionEmpty(int position1, int position2) {
		return area[position1][position2] == 0;
	}
	
}
