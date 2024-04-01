package br.com.conquerors.utils;

import java.util.Random;

import br.com.conquerors.entities.Kingdom;
import br.com.conquerors.entities.Resource;
import br.com.conquerors.entities.Soldier;
import br.com.conquerors.enuns.ResourceType;
import br.com.conquerors.enuns.SoldierType;
import br.com.conquerors.interfaces.Function;

public class OptionUtil {
	public static Option[] createExplorarOption() {
		Option op1 = new Option();
		Choice[] choices_op1 = {
				new Choice("1 - Saquear", new Function() {
					public void executar(Kingdom kingdom) {
						Random random = new Random();
						Resource resource = new Resource(random.nextInt(10), ResourceType.getResourceTypeByNumber(random.nextInt(3)));
						
						if (resource.getQuantity() != 0)
							KingdomUtil.setResource(kingdom, resource.getType(), kingdom.getResourcesQuantityByType(resource.getType()) + resource.getQuantity());
						
						System.out.printf("Você encontrou %d %s\n", resource.getQuantity(), resource.getType().getDescricao());
					}
				}),
				new Choice("2 - Recrutar soldados", new Function() {
					public void executar(Kingdom kingdom) {
						Random random = new Random();
						
						if (random.nextInt(2) == 0) {
							System.out.println("Nenhum habitante local quis ser recrutado!");
						} else {
							Soldier soldier = new Soldier();
							soldier.setType(SoldierType.getSoldierTypeByNumber(random.nextInt(3)));
							soldier.setQuantity(random.nextInt(10) + 1);
							kingdom.getSoldiers().get(soldier.getType().getNumber()).increaseQuantity(soldier.getQuantity());
							System.out.printf("Você conseguiu recrutar %d %s(s)!\n", soldier.getQuantity(), soldier.getType().getDescricao());
						}
					}
				}),
				new Choice("3 - Voltar ao reino", new Function() {
					public void executar(Kingdom kingdom) {
						System.out.println("Voltando para o reino...");
					}
				})
		};
		
		op1.setDescription("Você encontrou um acampamento de habitantes locais. O que deseja fazer?");
		op1.setChoices(choices_op1);
		
		Option op2 = new Option();
		Choice[] choices_op2 = {
				new Choice("1 - Lutar", new Function() {
					public void executar(Kingdom kingdom) {
						Kingdom enemyKingdom = KingdomUtil.createRandomKingdomMin();
						KingdomUtil.battle(kingdom, enemyKingdom);
					}
				}),
				new Choice("2 - Conversar", new Function() {
					public void executar(Kingdom kingdom) {
						Random random = new Random();						
						int chance = random.nextInt(2);
						
						if (chance == 0) {
							int gold = random.nextInt(40) + 5;
							System.out.printf("Seus reinos se deram bem! Parabéns você recebeu %d ouro(s) do reino desconhecido.\n", gold);
							KingdomUtil.setResource(kingdom, ResourceType.GOLD, kingdom.getResourcesQuantityByType(ResourceType.GOLD) + gold);
						} else {
							int gold = random.nextInt(40) + 5;
							System.out.printf("O reino desconhecido te enganou! Você perdeu %d ouro(s)!\n", gold);
							KingdomUtil.setResource(kingdom, ResourceType.GOLD, kingdom.getResourcesQuantityByType(ResourceType.GOLD) - gold);
						}
					}
				}),
				new Choice("3 - Formar aliança", new Function() {
					public void executar(Kingdom kingdom) {
						Kingdom unknownKingdom = KingdomUtil.createRandomKingdomMin();
						Random random = new Random();						
						int chance = random.nextInt(2);
						
						if (chance == 0) {
							System.out.println("Parabéns, seus reinos formaram uma aliança! Você poderá contar com seu aliado em sua próxima batalha!");
							kingdom.getAllies().add(unknownKingdom);
						} else {
							System.out.println("Você ofereceu os seguintes recursos na aliança:");
							for (ResourceType resourceType : ResourceType.values()) {
								int quantity = random.nextInt(kingdom.getResourcesQuantityByType(resourceType));
								System.out.printf("%s: %d\n", resourceType.getDescricao(), quantity);
								KingdomUtil.setResource(kingdom, resourceType, kingdom.getResourcesQuantityByType(resourceType) - quantity);
							}
							System.out.println("Porém o reino desconhecido negou uma aliança!\n");
						}
						
					}
				}),
				new Choice("4 - Voltar ao reino", new Function() {
					public void executar(Kingdom kingdom) {
						System.out.println("Voltando para o reino...");
					}
				})
		};
		
		op2.setDescription("Você encotrou um novo reino. O que deseja fazer?");
		op2.setChoices(choices_op2);
		
		Option op3 = new Option();
		Choice[] choices_op3 = {
				new Choice("1 - Explorar", new Function() {
					public void executar(Kingdom kingdom) {
						Random random = new Random();
						int chance = random.nextInt(2);
						
						switch (chance) {
							case 0:
								System.out.println("Parte da sua tropa caiu em uma armadilha na ruína.");
								
								int soldier_index = random.nextInt(3);
								int soldiers_lost = random.nextInt(11) + 5;
								
								Soldier soldier = kingdom.getSoldiers().get(soldier_index);
								
								if (soldiers_lost > soldier.getQuantity())
									soldiers_lost = soldier.getQuantity();
								kingdom.getSoldiers().get(soldier_index).setQuantity(soldier.getQuantity() - soldiers_lost);

								System.out.printf("Você perdeu %d %s(s).\n\n", soldiers_lost, soldier.getType().getDescricao());
								break;
							case 1:
								Resource resource = new Resource(random.nextInt(10), ResourceType.getResourceTypeByNumber(random.nextInt(3)));
								
								if (resource.getQuantity() != 0)
									KingdomUtil.setResource(kingdom, resource.getType(), kingdom.getResourcesQuantityByType(resource.getType()) + resource.getQuantity());
								
								System.out.printf("Você encontrou %d %s(s)\n\n", resource.getQuantity(), resource.getType().getDescricao());
								break;
						}
					}
				}),
				new Choice("2 - Voltar ao reino", new Function() {
					public void executar(Kingdom kingdom) {
						System.out.println("Voltando para o reino...\n");
					}
				})
		};
		
		op3.setDescription("Você encontrou uma ruína antiga. O que deseja fazer?");
		op3.setChoices(choices_op3);
		
		Option op4 = new Option();
		Choice[] choices_op4 = {
				new Choice("", new Function() {
					public void executar(Kingdom kingdom) {
						Kingdom enemyKingdom = KingdomUtil.createRandomKingdomMin();
						
						int newEnemyHealth = KingdomUtil.getSoldiersHealth(enemyKingdom.getSoldiers()) - KingdomUtil.getDefenseTowersAttack(kingdom.getDefenseTowers());
						int newHealth = KingdomUtil.getDefenseTowersHealth(kingdom.getDefenseTowers()) - KingdomUtil.getSoldiersStrength(enemyKingdom.getSoldiers());
						
						if (newHealth > newEnemyHealth) {
							System.out.println("Parabéns você conseguiu defender o seu reino!");
						} else {
							System.out.println("FIM DE JOGO!");
							System.out.println("Suas torres não conseguiram conter o ataque inimigo!");
							kingdom.printStatus();
							System.exit(1);
						}
					}
				})
		};
		
		op4.setDescription("Seu reino está sendo atacado por um reino desconhecido! \nSuas torres de defesa tentarão defender o reino!");
		op4.setChoices(choices_op4);
		
		Option[] options = {op1, op2, op3, op4};
		return options;
	}
}
