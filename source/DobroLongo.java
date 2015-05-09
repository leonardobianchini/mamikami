class DobroLongo extends Variavel {
	private double valor;

	public void setValor(String a) {
		this.valor = Double.valueOf(a);
		this.setTipo("double");
	}
	public Double getValor() {
		return this.valor;
	}
}