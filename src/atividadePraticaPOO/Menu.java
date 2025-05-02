package atividadePraticaPOO;

import java.io.IOException;
import java.util.Scanner;

import atividadePraticaPOO.controller.ProdutoController;
import atividadePraticaPOO.model.Cosmetico;
import atividadePraticaPOO.model.Medicamento;
import atividadePraticaPOO.util.Cores;

public class Menu {

	public static void main(String[] args) {

		Scanner leia = new Scanner(System.in);
		
		ProdutoController instanciaProduto = new ProdutoController();
		
		float preco;
		int tipo, numeroProduto;
		String nomeProduto,generico,fragancia;

		int opcao;

		while (true) {

			System.out.println(Cores.TEXT_GREEN + Cores.ANSI_BLACK_BACKGROUND
					+ "*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                  Farmacia Do Lucas                  ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Cadastrar Produto                    ");
			System.out.println("            2 - Ver Todos Produtos registrados       ");
			System.out.println("            3 - Buscar Produto pelo numero           ");
			System.out.println("            4 - Atualizar Dados de um produto        ");
			System.out.println("            5 - Retirar um Produto do Catalogo       ");
			System.out.println("            0 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Insira a opção desejada:                             ");
			System.out.println("                                                     " + Cores.TEXT_WHITE_BOLD);

			opcao = leia.nextInt();

			if (opcao == 0) {
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nFarmacia Do Lucas, Onde sua Saúde é a prioridade!");
				sobre();
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_WHITE + "Cadastrando novo Produto");
				
				System.out.println("Digite o nome do produto:");
				leia.skip("\\R");
				nomeProduto = leia.nextLine();
				System.out.println("Digite o preço do produto:");
				preco = leia.nextFloat();
				System.out.println("Selecione uma opção que retrate o produto: \n 1 - Medicamento \n 2 - Cosmético");
				int productChoose = leia.nextInt();
				
				
				if(productChoose == 1) {
					tipo = productChoose;
					System.out.println("O medicamento é generico? ");
					System.out.println("Digite (S) para sim e (N) para não");
					generico = leia.next();
					generico = generico.toUpperCase();

					if(generico.equalsIgnoreCase("N") || generico.equalsIgnoreCase("S")) {
						Medicamento newProduct = new Medicamento(instanciaProduto.identifierNumGenerate(),nomeProduto,tipo,preco,generico); 
						instanciaProduto.cadastrarProduto(newProduct);
					}else {
						System.out.println("opção invalida!");
					}
				}else if (productChoose == 2) {
					tipo = productChoose;
					System.out.println("Qual a fragancia do produto?");
					leia.skip("\\R");
					fragancia = leia.nextLine();
					Cosmetico newProd = new Cosmetico (instanciaProduto.identifierNumGenerate(),nomeProduto,tipo,preco,fragancia);
					instanciaProduto.cadastrarProduto(newProd);
				}
				keyPress();
				break;
			case 2:
				System.out.println(Cores.TEXT_WHITE + "Listando todos Produtos cadastrados \n\n");
				instanciaProduto.listarProdutos();

				keyPress();
				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE + "Listando informações de um produto especifico\n\n");
				System.out.println("Digite o numero do produto para ver sua descrição");
				numeroProduto = leia.nextInt();
				instanciaProduto.listarProdutoPeloCodigo(numeroProduto);
				keyPress();
				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE + "Atualizando dados de um produto\n\n");
				System.out.println("Digite o codigo do produto que será alterado");
				numeroProduto = leia.nextInt();
				System.out.println("Digite os novos dados que esse produto receberá:");
				
				System.out.println("Nome do produto:");
				leia.skip("\\R");
				nomeProduto = leia.nextLine();
				System.out.println("Preço do produto:");
				preco = leia.nextFloat();
				System.out.println("Tipo do produto: \n 1 - Medicamento \n 2 - Cosmético");
				int rechangeProdType = leia.nextInt();
				
				
				if(rechangeProdType == 1) {
					tipo = rechangeProdType;
					System.out.println("O medicamento é generico? ");
					System.out.println("Digite (S) para sim e (N) para não");
					generico = leia.next();
					generico = generico.toUpperCase();

					if(generico.equalsIgnoreCase("N") || generico.equalsIgnoreCase("S")) {
						instanciaProduto.atualizarDadosProduto(numeroProduto, new Medicamento(numeroProduto,nomeProduto,tipo,preco,generico));
					}else {
						System.out.println("opção invalida!");
					}
				}else if (rechangeProdType == 2) {
					tipo = rechangeProdType;
					System.out.println("Qual a fragancia do produto?");
					leia.skip("\\R");
					fragancia = leia.nextLine();
					instanciaProduto.atualizarDadosProduto(numeroProduto,new Cosmetico (numeroProduto,nomeProduto,tipo,preco,fragancia));
				}
				keyPress();
				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE + "Removendo dados de um produto\n\n");
				System.out.println("Digite o codigo do produto para ser removido");
				numeroProduto = leia.nextInt();
				instanciaProduto.removerProduto(numeroProduto);
				keyPress();
				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n" + Cores.TEXT_RESET);
				keyPress();
				break;
			}
		}
	}

	public static void sobre() {
		System.out.println("\n*********************************************************");
		System.out.println("Projeto Desenvolvido por: ");
		System.out.println("Lucas Manrick Teodoro da Fonseca");
		System.out.println("https://github.com/lucasmanrick");
		System.out.println("*********************************************************");
	}

	public static void keyPress() {

		try {

			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
			System.in.read();

		} catch (IOException e) {

			System.out.println("Você pressionou uma tecla diferente de enter!");

		}

	}

}
