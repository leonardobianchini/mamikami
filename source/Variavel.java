class Variavel{

	private String tipo;
	private String nome;
	private Object valor;

//---------------------------------GETES----------------------------------------
	public String getNome() {
		return this.nome;
	}

	public String getTipo(){
	 	return this.tipo;
	}

	public Object getValor(){
		if(this.getTipo()== "double"){
			return this.valor;
		}
		if(this.getTipo() == "integer"){
			return this.valor;
		}
		if(this.getTipo() == "boolean"){
			return this.valor;
		}
		if(this.getTipo() == "string"){
			return this.valor;
		}
		return null;
	}


//---------------------------------SETES----------------------------------------
	public void setNome(String a) {
		this.nome = a;
	}


	public void setValor(String valoratribuicao){
		try{
			//verifica double
			this.valor = Double.parseDouble(valoratribuicao);
			this.tipo = "double";
		}catch(Exception a){
			try{
				this.valor = Integer.parseInt(valoratribuicao);
				this.tipo = "integer";
			}catch(Exception a1){
				try{
					this.valor = Boolean.parseBoolean(valoratribuicao);
					this.tipo ="boolean";
				}catch(Exception a2){
					this.valor = String.valueOf(valoratribuicao);				
				}
			}
		}


	}
}

