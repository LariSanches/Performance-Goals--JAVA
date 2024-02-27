package produto.model;

public class Formas extends Produto {

	private String medidas;

	public Formas(int id, String nome, int tipo, float preco, String medidas) {
		super(id, nome, tipo, preco);
		this.medidas = medidas;
	}

	public String getMedidas() {
		return medidas;
	}

	public void setMedidas(String medidas) {
		this.medidas = medidas;
	}

	public void visualizar() {
		super.visualizar();
		System.out.println("Medidas da forma:" + this.medidas);
	}
}