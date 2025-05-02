package atividadePraticaPOO.controller;

import java.util.ArrayList;

import atividadePraticaPOO.model.Produto;
import atividadePraticaPOO.repository.ProdutoRepository;

public class ProdutoController implements ProdutoRepository{

	private ArrayList<Produto> productsList = new ArrayList<Produto>();
	
	int identifier = 0;
	
	@Override
	public void cadastrarProduto(Produto produto) {
		int length = productsList.size();
		productsList.add(produto);
		
		if(productsList.size() == length) {
			System.out.println("Não foi possivel cadastrar o produto, tente novamente");
			return;
		} 
		System.out.println("Produto cadastrado com sucesso!");
	}

	@Override
	public void listarProdutos() {
		for(var product : productsList) {
			product.visualizar();
		}
	}

	@Override
	public void listarProdutoPeloCodigo(int identifier) {
		int found = 0;
		
		for(var product : productsList) {
			if(product.getId() == identifier) {
				product.visualizar();
				found = 1;
				return;
			}
		}
		
		if (found == 0) {
			System.out.println("produto não existe ou não foi identificado, tente novamente!");
		}
		
	}

	@Override
	public void atualizarDadosProduto(int identifier, Produto produto) {
		productsList.set(--identifier, produto);
		System.out.println("Dados do produto atualizados com sucesso!");
	}

	@Override
	public void removerProduto(int identifier) {
		productsList.remove(--identifier);
		System.out.println("Produto removido com sucesso!");
	}
	
	
	public int identifierNumGenerate () {
		return ++identifier;
	}
	
}
