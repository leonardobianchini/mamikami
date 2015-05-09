abstract class Variavel{

	private String tipo;
	private String nome;

//---------------------------------GETES----------------------------------------
	public String getNome() {
		return this.nome;
	}

	public String getTipo() {
	 	return this.tipo;
	}

	abstract public Object getValor();


//---------------------------------SETES----------------------------------------
	public void setNome(String a) {
		this.nome = a;
	}


	abstract public void setValor(String a);

	public void setTipo(String a) {
		this.tipo = a;
	}
}

