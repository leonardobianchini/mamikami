class VariavelTemp extends Variavel {
	private double valor;


	public void setTipo() {
		super.setTipo("double");
	}
	public double getValor() {
		return this.valor;
	}
	public void setValor(double a) {
		this.setTipo();
		this.valor = a;
	}
}