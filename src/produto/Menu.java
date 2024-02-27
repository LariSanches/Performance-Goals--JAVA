package produto;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import produto.controller.ProdutoController;
import produto.model.Chocolates;
import produto.model.Formas;
import produto.util.Cores;

public class Menu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner leia = new Scanner(System.in);
		ProdutoController produtos = new ProdutoController();

		int opcao, id, tipo;
		String sabor, medidas, nomeProduto;
		float preco;

		// Criando produto pada teste.
		Chocolates c1 = new Chocolates(1, "Chocolate Nestlé", 1, 72.0f, "meio amargo");
		produtos.criarProduto(c1);

		// Criando produto para teste.
		Formas f1 = new Formas(2, "Forma Retangular Caparroz", 2, 35.5f, "15x10x8");
		produtos.criarProduto(f1);

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
				System.out.println("\nDigite o ID do produto: ");
				id = leia.nextInt();
				System.out.println("Digite o Nome do Produto: ");
				leia.skip("\\R?");
				nomeProduto = leia.nextLine();
				System.out.println("Digite o preço do produto: ");
				preco = leia.nextFloat();

				do {
					System.out.println("Digite o Tipo de produto (1-Chocolates ou 2-Formas): ");
					tipo = leia.nextInt();
				} while (tipo < 1 && tipo > 2);

				switch (tipo) {
				case 1:
					System.out.println("\nDigite o sabor do chocolate: ");
					leia.skip("\\R?");
					sabor = leia.nextLine();
					produtos.criarProduto(new Chocolates(id, nomeProduto, tipo, preco, sabor));
					break;
				case 2:
					System.out.println("\nDigite as medidas da forma: ");
					medidas = leia.nextLine();
					produtos.criarProduto(new Formas(id, nomeProduto, tipo, preco, medidas));
					break;

				}

				keyPress();
				break;
			case 2:
				System.out.println("\n Listar todas os produtos");
				produtos.listarTodos();
				keyPress();
				break;
			case 3:
				System.out.println("\n Consultar produto por ID");

				System.out.println("\nDigite o ID do produto: ");
				id = leia.nextInt();
				produtos.consultarProdutoPorID(id);
				keyPress();
				break;
			case 4:
				System.out.println("\n Atualizar dados do Produto");

				System.out.println("\nDigite o ID do produto: ");
				id = leia.nextInt();

				var buscaProduto = produtos.buscarNaCollection(id);

				if (buscaProduto != null) {

					tipo = buscaProduto.getTipo();

					System.out.println("Digite o Nome do Produto: ");
					leia.skip("\\R?");
					nomeProduto = leia.nextLine();
					System.out.println("Digite o preço do produto: ");
					preco = leia.nextFloat();

					switch (tipo) {
					case 1:
						System.out.println("\nDigite o sabor do chocolate: ");
						leia.skip("\\R?");
						sabor = leia.nextLine();
						produtos.atualizarProduto(new Chocolates(id, nomeProduto, tipo, preco, sabor));
						break;
					case 2:
						System.out.println("\nDigite as medidas da forma: ");
						medidas = leia.nextLine();
						produtos.atualizarProduto(new Formas(id, nomeProduto, tipo, preco, medidas));
						break;

					default: {
						System.out.println("\nTipo de produto inválido!");
					}
					}
				} else {
					System.out.println("\nO produto não foi encontrado!");
				}

				keyPress();
				break;
			case 5:
				System.out.println("\n Deletar produto");
				System.out.println("\nDigite o ID do produto: ");
				id = leia.nextInt();
				produtos.deletarProduto(id);
				keyPress();
				break;
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