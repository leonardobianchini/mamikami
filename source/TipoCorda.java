class TipoCorda extends Variavel {
	private String valor;

	public void setValor(String a) {
		this.valor = a;
		this.setTipo("String");
	}
	public String getValor() {
		return this.valor;
	}
}