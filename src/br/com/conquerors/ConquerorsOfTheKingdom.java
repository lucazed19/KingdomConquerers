package br.com.conquerors;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import br.com.conquerors.entities.Kingdom;
import br.com.conquerors.enuns.SoldierType;
import br.com.conquerors.interfaces.Function;
import br.com.conquerors.utils.Choice;
import br.com.conquerors.utils.KingdomUtil;
import br.com.conquerors.utils.Option;
import br.com.conquerors.utils.OptionUtil;

public class ConquerorsOfTheKingdom {
	public static void main(String[] args) {
		Kingdom kingdom = KingdomUtil.createRandomKingdom();
		
		Scanner scanner = new Scanner(System.in);
        int escolha;
        int turno = 1;

        do {
        	System.out.printf("Turno: %d\n", turno);
        	kingdom.printStatus();
            System.out.println("Escolha uma opção:");
            System.out.println("1. Gerenciar Reino");
            System.out.println("2. Explorar");
            System.out.println("3. Instruções");
            System.out.println("4. Sair do Jogo");

            System.out.print("Opção: ");
            escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                	gerenciarReino(scanner, kingdom);
                    break;
                case 2:
                    explorar(scanner, kingdom);
                    KingdomUtil.updateKingdomResourcesPerTurn(kingdom);
                    turno++;
                    break;
                case 3:
                	printInstruction();
                    break;
                case 4:
                    System.out.println("Saindo do jogo...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
            
            try {
	            if (System.getProperty("os.name").contains("Windows")) {
	            	Runtime.getRuntime().exec("cls");
	            } else {
	                Runtime.getRuntime().exec("clear");
	            }
            } catch (Exception e) {}
        } while (escolha != 3);

        scanner.close();
	}
	
	public static void gerenciarReino(Scanner scanner, Kingdom kingdom) {
        int escolha;

        do {
            System.out.println("\nGerenciar Reino");
            System.out.println("Escolha uma opção:");
            System.out.println("1. Construir");
            System.out.println("2. Aumentar Nível das Construções");
            System.out.println("3. Treinar Soldados");
            System.out.println("4. Voltar ao Menu Principal");

            System.out.print("Opção: ");
            escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                	construirUpgrade(scanner, kingdom, 1);
                    break;
                case 2:
                	construirUpgrade(scanner, kingdom, 2);
                    break;
                case 3:
                	treinarSoldados(scanner, kingdom);
                    break;
                case 4:
                    System.out.println("Voltando ao Menu Principal...\n");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        } while (escolha != 4);
    }
	
	public static void construirUpgrade(Scanner scanner, Kingdom kingdom, int type) {
        int escolha;
        
        if (kingdom.getResources().get(3).getQuantity() <= 0 && type == 1) {
        	System.out.println("Você não possui terras para construir.");
        } else {        	
        	do {
        		System.out.println("\nEscolha uma opção:");
        		System.out.printf("1. Torre de Defesa (%d)\n", kingdom.getDefenseTowers().get(0).getBuildPrice());
        		System.out.printf("2. Mina de Ouro (%d)\n", kingdom.getGoldMines().get(0).getBuildPrice());
        		System.out.printf("3. Quartel (%d)\n", kingdom.getHeadQuarters().get(0).getBuildPrice());
        		System.out.printf("4. Casa (%d)\n", kingdom.getHouses().get(0).getBuildPrice());
        		System.out.printf("5. Mina de Ferro (%d)\n", kingdom.getIronMines().get(0).getBuildPrice());
        		System.out.printf("6. Acampamento Madeireiro (%d)\n", kingdom.getLumberCamps().get(0).getBuildPrice());
        		System.out.println("7. Voltar ao Menu Gerenciar Reino");
        		
        		System.out.print("Opção: ");
        		escolha = scanner.nextInt();
        		
        		if (escolha >= 1 && escolha <= 6) {
        			if (type == 1) KingdomUtil.build(kingdom, escolha);
        			else if (type == 2) KingdomUtil.upgrade(kingdom, escolha);            	
        		} else if (escolha == 7) {
        			System.out.println("Voltando ao Menu Gerenciar Reino...\n");            	
        		} else {
        			System.out.println("Opção inválida. Por favor, escolha novamente.");            	
        		}
        		
        	} while (escolha != 7);
        }
    }
	
	public static void treinarSoldados(Scanner scanner, Kingdom kingdom) {
		int escolha;
		
		do {
			System.out.println("\nEscolha uma opção:");
			System.out.printf("1. %s (%d)\n",SoldierType.ARCHER.getDescricao(), kingdom.getHeadQuarters().get(0).getTrainingCost());
			System.out.printf("2. %s (%d)\n",SoldierType.WARRIOR.getDescricao(), kingdom.getHeadQuarters().get(0).getTrainingCost());
			System.out.printf("3. %s (%d)\n",SoldierType.SPEARMAN.getDescricao(), kingdom.getHeadQuarters().get(0).getTrainingCost());
			System.out.println("4. Voltar ao Menu Gerenciar Reino");
			
			System.out.print("Opção: ");
            escolha = scanner.nextInt();
            
            if (escolha >= 1 && escolha <= 3) {            	
            	SoldierType soldierType = SoldierType.getSoldierTypeByNumber(escolha - 1);
            	
            	System.out.printf("\nEscolha a quantidade de %s para treinar - (CAPACIDADE: %d): ", soldierType.getDescricao(), kingdom.getHousesCapacity() - kingdom.getSoldiersQuantity());
            	escolha = scanner.nextInt();
            	
            	KingdomUtil.trainingSoldiers(kingdom, soldierType, escolha);
            } else if (escolha == 4) {
            	System.out.println("Voltando ao Menu Gerenciar Reino...\n"); 
            } else {            	
            	System.out.println("Opção inválida. Por favor, escolha novamente.");            	
            }
		} while (escolha != 4);
	}
	
	public static void explorar(Scanner scanner, Kingdom kingdom) {
		int escolha;
		int voltar = 0;
		Random random = new Random();
		
		Option[] options = OptionUtil.createExplorarOption();
		
		do {
			Option option = options[random.nextInt(options.length)];
			voltar = option.getChoices().length;
			
			System.out.println("\n"+option.getDescription());
			List<Function> listFunctions = new ArrayList<Function>();
			
			for (Choice choice : option.getChoices()) {
	            listFunctions.add(choice.getFunction());
	            System.out.println(choice.getDescription());
	        }
			
			if (option.getChoices().length == 1) {
				escolha = 0;
			} else {
				escolha = scanner.nextInt() - 1;				
			}
			Function function = listFunctions.get(escolha);
			function.executar(kingdom);
			
		} while (escolha + 1 != voltar);
	}
	
	public static void printInstruction() {
		
	}
}
