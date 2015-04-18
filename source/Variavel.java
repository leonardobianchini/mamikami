class Variavel{

	private String tipo;
	private String nome;
	private String valors;
	private boolean valorb;
	private double valord;
	private int valori;

	public String getNome() {
	        return this.nome;
	}

	public String getTipo(String a){
	 	return tipo;
	}
	/*
	FALTA DAR UM GET VALOR, TEREMOS QUE APRENDER POLIMORSFISMO, IREI FOCAR NO IF
	POR ENQUANTO. VLW FLW.

	*/


	public void setNome(String variavel) {
		this.nome = variavel;
	}

	public void setTipoValor(String valoratribuicao){

			try{
				//verifica se é double
				this.valord= Double.parseDouble(valoratribuicao);
				this.tipo ="double";
			}catch(Exception a){
				try{
					//verifica se é int
					this.valori = Integer.parseInt(valoratribuicao);
					this.tipo="integer";
				}catch(Exception a2){
					try{
						//testa boolean
						this.valorb = Boolean.parseBoolean(valoratribuicao);
						this.tipo ="boolean";
					}catch(Exception a3){
						//default é string
						this.valors= String.valueOf(valoratribuicao);
						this.tipo="String";
					}
				}
			}
	}

}
