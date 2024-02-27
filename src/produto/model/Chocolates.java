package produto.model;

public class Chocolates extends Produto {

	private String sabor;

	public Chocolates(int id, String nome, int tipo, float preco, String sabor) {
		super(id, nome, tipo, preco);
		this.sabor = sabor;
	}

	public String getSabor() {
		return sabor;
	}

	public void setSabor(String sabor) {
		this.sabor = sabor;
	}

	public void visualizar() {
		super.visualizar();
		System.out.println("Sabor do chocolate:" + this.sabor);
	}
}
