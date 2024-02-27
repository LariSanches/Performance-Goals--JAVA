package produto;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import produto.model.Chocolates;
import produto.model.Formas;
import produto.util.Cores;

public class Menu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner leia = new Scanner(System.in);

		// testando sub-classe chocolates
		Chocolates c1 = new Chocolates(1, "Chocolate Sicao", 1, 72.0f, "meio amargo");
		c1.visualizar();

		// testando sub-classe formas
		Formas f1 = new Formas(2, "Forma Retangular", 2, 35.5f, "15x10x8");
		f1.visualizar();

		int opcao;

		opcao = 0;

		while (true) {

			System.out.println(Cores.TEXT_RED + Cores.ANSI_WHITE_BACKGROUND
					+ "*****************************************************");
			System.out.println("                                                     ");
			System.out.println(" 	DOCE JAVA PRODUTOS PARA CONFEITARIA          ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Criar Produto                        ");
			System.out.println("            2 - Listar todas os produtos             ");
			System.out.println("            3 - Consultar produto por ID             ");
			System.out.println("            4 - Atualizar produto		     ");
			System.out.println("            5 - Deletar produto                      ");
			System.out.println("            6 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Digite o número da opção desejada:                   ");
			System.out.println("                                                     " + Cores.TEXT_RESET);

			try {
				opcao = leia.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("\nDigite valores inteiros!");
				leia.nextLine();
				opcao = 0;
			}

			if (opcao == 6) {
				System.out.println("\nAtendimento Doce Java finalizado!");
				System.exit(0);
			}
			switch (opcao) {

			case 1:
				System.out.println("\n Criar Produto");
				keyPress();
				break;
			case 2:
				System.out.println("\n Listar todas os produtos");
				keyPress();
				break;
			case 3:
				System.out.println("\n Consultar produto por ID");
				keyPress();
				break;
			case 4:
				System.out.println("\n Atualizar dados do Produto");
				keyPress();
				break;
			case 5:
				System.out.println("\n Deletar produto");

			default:
				System.out.println("\nOpção Inválida" + Cores.TEXT_RESET);
				keyPress();
				break;

			}
		}
	}

	public static void keyPress() {

		try {

			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar.");
			System.in.read();

		} catch (IOException e) {

			System.out.println("\nVocê pressionou uma tecla diferente de enter!");

		}
	}
}