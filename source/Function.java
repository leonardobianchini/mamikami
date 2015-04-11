class Function {
	private String nome;
	private String tipoRetorno;
	private String parametros;

	public void setNome(String a) {
		this.nome = a;
	}
	public void setTipoRetorno(String a){
		this.tipoRetorno = a;
	}
	public void setParametros(String a) {
		this.parametros = a;
	}
	public String getNome() {
		return this.nome;
	}
	public String getTipoRetorno() {
		return this.tipoRetorno;
	}
	public String getParametros() {
		return this.parametros;
	}
}