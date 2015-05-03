class Variavel{

	private String tipo;
	private String nome;

	public String getNome() {
		return this.nome;
	}

	public String getTipo(){
	 	return this.tipo;
	}
	/*
	FALTA DAR UM GET VALOR, TEREMOS QUE APRENDER POLIMORSFISMO, IREI FOCAR NO IF
	POR ENQUANTO. VLW FLW.
	*/
	public void setNome(String a) {
		this.nome = a;
	}

	public void setTipo(String valoratribuicao){

		try{
			//verifica se é double
			//this.valord= Double.parseDouble(valoratribuicao);
			this.tipo ="double";
		}catch(Exception a){
			try{
				//verifica se é int
				//this.valori = Integer.parseInt(valoratribuicao);
				this.tipo="integer";
			}catch(Exception a2){
				try{
					//testa boolean
					//this.valorb = Boolean.parseBoolean(valoratribuicao);
					this.tipo ="boolean";
				}catch(Exception a3){
					//default é string
					//this.valors= String.valueOf(valoratribuicao);
					this.tipo="String";
				}
			}
		}
	}
}
