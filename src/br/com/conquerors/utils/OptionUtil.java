package br.com.conquerors.utils;

import java.util.Random;

import br.com.conquerors.entities.Kingdom;
import br.com.conquerors.entities.Resource;
import br.com.conquerors.entities.Soldier;
import br.com.conquerors.enuns.ResourceType;
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
				new Choice("2 - Voltar ao reino", new Function() {
					public void executar(Kingdom kingdom) {
						System.out.println("Voltando para o reino...");
					}
				})
		};
		
		op1.setDescription("Você encontrou um acampamento de sobreviventes de guerra. O que deseja fazer?");
		op1.setChoices(choices_op1);
		
		Option op2 = new Option();
		Choice[] choices_op2 = {
				new Choice("1 - Lutar", new Function() {
					public void executar(Kingdom kingdom) {
						Kingdom enemyKingdom = KingdomUtil.createRandomKingdom();
						// FAZER BATALHA
					}
				}),
				new Choice("2 - Conversar", new Function() {
					public void executar(Kingdom kingdom) {
						Random random = new Random();						
						int chance = random.nextInt(2);
						
						if (chance == 0) {
							int gold = random.nextInt(40) + 5;
							System.out.printf("Seus reinos se deram bem! Parabéns você recebeu %d ouro(s) do seu novo aliado.\n", gold);
							KingdomUtil.setResource(kingdom, ResourceType.GOLD, kingdom.getResourcesQuantityByType(ResourceType.GOLD) + gold);
						} else {
							int gold = random.nextInt(40) + 5;
							System.out.printf("O novo reino te enganou! Você perdeu %d ouro(s)!\n", gold);
							KingdomUtil.setResource(kingdom, ResourceType.GOLD, kingdom.getResourcesQuantityByType(ResourceType.GOLD) - gold);
						}
					}
				}),
				new Choice("3 - Voltar ao reino", new Function() {
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
		
		Option[] options = {op1, op2, op3};
		return options;
	}
}
