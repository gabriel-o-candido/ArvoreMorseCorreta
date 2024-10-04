import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MorseTree morseTree = new MorseTree();
        boolean continueProgram = true;

        System.out.println("Bem-vindo ao programa de Árvore Morse!");

        while (continueProgram) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Inserir letra e código Morse");
            System.out.println("2 - Decodificar código Morse");
            System.out.println("3 - Exibir a árvore Morse");
            System.out.println("4 - Sair");
            System.out.print("Opção: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Digite a letra a ser inserida: ");
                    char letter = scanner.nextLine().toUpperCase().charAt(0);
                    System.out.print("Digite o código Morse (use '.' para ponto e '-' para traço): ");
                    String morseCode = scanner.nextLine();
                    morseTree.insert(letter, morseCode);
                    System.out.println("Letra '" + letter + "' inserida com sucesso!");
                    break;

                case 2:
                    System.out.print("Digite o código Morse para decodificação (separar letras por espaço): ");
                    String morseToDecode = scanner.nextLine();
                    String result = morseTree.decode(morseToDecode);
                    System.out.println("Resultado da decodificação: " + result);
                    break;

                case 3:
                    System.out.println("Exibindo a árvore Morse, Nó Direito para cima, " +
                                        "Nó Esquerdo para baixo, da esquerda pra direita");
                    morseTree.displayTree();
                    break;

                case 4:
                    continueProgram = false;
                    System.out.println("Saindo do programa.");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }
}