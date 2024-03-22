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
                	gerenciarReino(scanner);
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
	
	public static void gerenciarReino(Scanner scanner) {
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
                    construir(scanner);
                    break;
                case 2:
                    System.out.println("Você escolheu Aumentar Nível das Construções.");
                    // Coloque aqui o código para a opção Aumentar Nível das Construções
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
	
	public static void construir(Scanner scanner) {
        int escolha;

        do {
            System.out.println("\nConstruir");
            System.out.println("Escolha uma opção:");
            System.out.println("1. Torre de Defesa");
            System.out.println("2. Casa");
            System.out.println("3. Quartel");
            System.out.println("4. Mina de Ouro");
            System.out.println("5. Mina de Ferro");
            System.out.println("6. Acampamento Madeireiro");
            System.out.println("7. Voltar ao Menu Gerenciar Reino");

            System.out.print("Opção: ");
            escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    System.out.println("Você escolheu Construir Torre de Defesa.");
                    // Coloque aqui o código para a opção Construir Torre de Defesa
                    break;
                case 2:
                    System.out.println("Você escolheu Construir Casa.");
                    // Coloque aqui o código para a opção Construir Casa
                    break;
                case 3:
                    System.out.println("Você escolheu Construir Quartel.");
                    // Coloque aqui o código para a opção Construir Quartel
                    break;
                case 4:
                    System.out.println("Você escolheu Construir Mina de Ouro.");
                    // Coloque aqui o código para a opção Construir Mina de Ouro
                    break;
                case 5:
                    System.out.println("Você escolheu Construir Mina de Ferro.");
                    // Coloque aqui o código para a opção Construir Mina de Ferro
                    break;
                case 6:
                    System.out.println("Você escolheu Construir Acampamento Madeireiro.");
                    // Coloque aqui o código para a opção Construir Acampamento Madeireiro
                    break;
                case 7:
                    System.out.println("Voltando ao Menu Gerenciar Reino...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        } while (escolha != 7);
    }
}
