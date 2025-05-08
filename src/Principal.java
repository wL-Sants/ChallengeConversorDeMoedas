import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Valor 100.0 [USD] corresponde ao valor final de >>> 486.650000000003 [BRL]");
        System.out.println("********************************************************");


        System.out.println("Seja bem-vindo/a ao Conversor de Moeda =]");
        System.out.println("**************************************************");
        System.out.println("1) Dólar  ==> Peso argentino");
        System.out.println("2) Peso argentino ==> Dólar");
        System.out.println("3) Dólar ==> Real brasileiro");
        System.out.println("4) Real brasileiro ==> Dólar");
        System.out.println("5) Dólar ==> Peso colombiano");
        System.out.println("6) Peso colombiano ==> Dólar");
        System.out.println("7) Sair");
        System.out.println("**************************************************");


        while (true) {

            System.out.print("Escolha uma opção válida: ");
            int opcao = scanner.nextInt();


            if (opcao == 7) {
                System.out.println("Saindo...");
                break;
            }


            System.out.print("Digite o valor que deseja converter: ");
            double valor = scanner.nextDouble();


            Conversor conversor = new Conversor();

            switch (opcao) {
                case 1: // Dólar > Peso argentino
                    double resultado1 = conversor.converter(valor, 1.0, 486.65);  // Exemplo de taxa
                    System.out.printf("Valor convertido: %.2f ARS\n", resultado1);
                    break;
                case 2: // Peso argentino > Dólar
                    double resultado2 = conversor.converter(valor, 486.65, 1.0);  // Exemplo de taxa
                    System.out.printf("Valor convertido: %.2f USD\n", resultado2);
                    break;
                case 3: // Dólar > Real brasileiro
                    double resultado3 = conversor.converter(valor, 1.0, 5.0);  // Exemplo de taxa
                    System.out.printf("Valor convertido: %.2f BRL\n", resultado3);
                    break;
                case 4: // Real brasileiro > Dólar
                    double resultado4 = conversor.converter(valor, 5.0, 1.0);  // Exemplo de taxa
                    System.out.printf("Valor convertido: %.2f USD\n", resultado4);
                    break;
                case 5: // Dólar > Peso colombiano
                    double resultado5 = conversor.converter(valor, 1.0, 3800.0);  // Exemplo de taxa
                    System.out.printf("Valor convertido: %.2f COP\n", resultado5);
                    break;
                case 6: // Peso colombiano > Dólar
                    double resultado6 = conversor.converter(valor, 3800.0, 1.0);  // Exemplo de taxa
                    System.out.printf("Valor convertido: %.2f USD\n", resultado6);
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }

            System.out.println("********************************************************");
        }

        scanner.close();
    }
}
