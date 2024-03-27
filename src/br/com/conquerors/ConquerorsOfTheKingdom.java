package br.com.conquerors;

import java.util.Scanner;

import br.com.conquerors.entities.Kingdom;
import br.com.conquerors.utils.KingdomUtil;

public class ConquerorsOfTheKingdom {
	public static void main(String[] args) {
		Kingdom kingdom = KingdomUtil.createRandomKingdom();
		
		Scanner scanner = new Scanner(System.in);
        int escolha;

        do {
        	kingdom.printStatus();
            System.out.println("Escolha uma opção:");
            System.out.println("1. Gerenciar Reino");
            System.out.println("2. Explorar");
            System.out.println("3. Sair do Jogo");

            System.out.print("Opção: ");
            escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                	gerenciarReino(scanner, kingdom);
                    break;
                case 2:
                    System.out.println("Você escolheu Explorar.");
                    // Coloque aqui o código para a opção Explorar
                    break;
                case 3:
                    System.out.println("Saindo do jogo...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
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
                    System.out.println("Você escolheu Treinar Soldados.");
                    // Coloque aqui o código para a opção Treinar Soldados
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
            
            if (type == 1) KingdomUtil.build(kingdom, escolha);
            else if (type == 2) KingdomUtil.upgrade(kingdom, escolha);
        } while (escolha != 7);
    }
}
