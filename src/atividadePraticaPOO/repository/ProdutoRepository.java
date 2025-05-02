package atividadePraticaPOO.repository;

import atividadePraticaPOO.model.Produto;

public interface ProdutoRepository {
	
	public void cadastrarProduto(Produto produto) ;
	public void listarProdutos();
	public void listarProdutoPeloCodigo(int identifier);
	public void atualizarDadosProduto(int identifier, Produto produto);
	public void removerProduto(int identifier);
	
}
