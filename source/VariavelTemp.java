class VariavelTemp {
	private double valor;
	private String nome;
	private String tipo;

	public void setNome(String a) {
		this.nome = a;
	}
	public String getNome() {
		return this.nome;
	}
	public String getTipo() {
		return this.tipo;
	}
	public void setTipo() {
		this.tipo = "double";
	}
	public double getValor() {
		return this.valor;
	}
	public void setValor(double a) {
		this.setTipo();
		this.valor = a;
	}
}