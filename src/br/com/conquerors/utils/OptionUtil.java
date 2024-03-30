package br.com.conquerors.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import br.com.conquerors.entities.Kingdom;
import br.com.conquerors.entities.Resource;
import br.com.conquerors.enuns.ResourceType;
import br.com.conquerors.interfaces.Function;

public class OptionUtil {
	public static Option[] createExplorarOption() {
		Option op1 = new Option();
		op1.setDescription("Você encontrou um acampamento de sobreviventes de guerra. O que deseja fazer?");
		op1.setChoices(new HashMap<String, Function>());
		op1.getChoices().put("1- Saquear", new Function() {
					public void executar(Kingdom kingdom) {
						Random random = new Random();
						Resource resource = new Resource(random.nextInt(10), ResourceType.getResourceTypeByNumber(random.nextInt(3)));
						KingdomUtil.setResource(kingdom, resource.getType(), kingdom.getResourcesQuantityByType(resource.getType()) + resource.getQuantity());
						System.out.printf("Você encontrou %d %s\n", resource.getQuantity(), resource.getType().getDescricao());
					}
		});
		op1.getChoices().put("2- Voltar ao reino", new Function() {
			public void executar(Kingdom kingdom) {
				System.out.println("Voltando para o reino...");
			}
		});
		
		Option op2 = new Option();
		op2.setDescription("Você encotrou um novo reino. O que deseja fazer?");
		op2.setChoices(new HashMap<String, Function>());
		op2.getChoices().put("1- Lutar", new Function() {
			public void executar(Kingdom kingdom) {
				Kingdom enemyKingdom = KingdomUtil.createRandomKingdom();
				// FAZER BATALHA
			}
		});
		op2.getChoices().put("2- Conversar", new Function() {
			public void executar(Kingdom kingdom) {
				Random random = new Random();						
				int chance = random.nextInt(1);
				
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
		});
		op2.getChoices().put("3- Voltar ao reino", new Function() {
			public void executar(Kingdom kingdom) {
				System.out.println("Voltando para o reino...");
			}
		});
		
		Option[] options = {op1, op2};
		return options;
	}
}
