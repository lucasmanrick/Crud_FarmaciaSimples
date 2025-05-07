package atividadePraticaPOO.model;

public class Cosmetico extends Produto{
	private String fragrancia;

	public Cosmetico(int id, String nome, int tipo, float preco, String fragrancia) {
		super(id, nome, tipo, preco);
		this.fragrancia = fragrancia;
	}

	public String getfragrancia() {
		return fragrancia;
	}

	public void setfragrancia(String fragrancia) {
		this.fragrancia = fragrancia;
	}
	
	@Override
	public void	visualizar() {
		super.visualizar();
		System.out.println("fragrancia do produto: " + this.getfragrancia());
		System.out.println("*************************************************");
	};
}
