class Variavel{

	private String tipo;
	private String nome;

//---------------------------------GETES----------------------------------------
	public String getNome() {
		return this.nome;
	}

	public String getTipo(){
	 	return this.tipo;
	}

	public Object getValor(){
		if(this.getTipo()== "double"){

		}
		if(this.getTipo() == "integer"){

		}
		if(this.getTipo() == "boolean"){

		}
		if(this.getTipo() == "string"){

		}
		return null; //tem que retornar algo sabia?
	}


//---------------------------------SETES----------------------------------------
	public void setNome(String a) {
		this.nome = a;
	}
	public void setValor(String valoratribuicao){

		
	}
}
