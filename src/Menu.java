import java.util.Scanner;

public class Menu {

    public static void exibirMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("""
                ===================================================
                Seja bem-vindo/a ao Conversor de Moeda =]
                                
                1) Dólar =>> Peso argentino
                2) Peso argentino =>> Dólar
                3) Dólar =>> Real brasileiro
                4) Real brasileiro =>> Dólar
                5) Dólar =>> Peso colombiano
                6) Peso colombiano =>> Dólar
                7) Sair
                Escolha uma opção válida:
                ===================================================            
                """);

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> Consulta.converter("USD", "ARS");
                case 2 -> Consulta.converter("ARS", "USD");
                case 3 -> Consulta.converter("USD", "BRL");
                case 4 -> Consulta.converter("BRL", "USD");
                case 5 -> Consulta.converter("USD", "COP");
                case 6 -> Consulta.converter("COP", "USD");
                case 7 -> System.out.println("Sistema encerrdo!");
                default -> System.out.println("Opção inválida, tente novamente!");
            }

        } while (opcao != 7);

        scanner.close();
    }
}