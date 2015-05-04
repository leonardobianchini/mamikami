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
			Variavel a = new PontoFlutuante();
			return a.getValor();
		}
		if(this.getTipo() == "integer"){
			Variavel a = new Inteiro();
			return a.getValor();
		}
		if(this.getTipo() == "boolean"){
			Variavel a = new Bool();
			return a.getValor();
		}
		if(this.getTipo() == "string"){
			Variavel a = new Corda();//by:google translate
			return a.getValor();
		}
		return null;
	}


//---------------------------------SETES----------------------------------------
	public void setNome(String a) {
		this.nome = a;
	}
	public void setValor(String valoratribuicao){


		try{
			//verifica se é double
			//this.valord= Double.parseDouble(valoratribuicao);
			this.tipo ="double";
		}catch(Exception a){
			try{
				//verifica se é double
				Variavel a = new PontoFlutuante();//bug bug bug bug
				a.setValor(valoratribuicao);
				this.tipo ="double";
			}catch(Exception a){
				try{
					//verifica se é int
					Variavel b = new Inteiro();//bug bug bug bug
					b.setValor(valoratribuicao);
					this.tipo="integer";
				}catch(Exception a2){
					try{
						//testa boolean
						Variavel c = new Bool();//bug bug bug bug
						c.setValor(valoratribuicao);
						this.tipo ="boolean";
					}catch(Exception a3){
						//default é string
						Variavel d = new Corda();// bug bug bug bug
						d.setValor(valoratribuicao);
						this.tipo="string";
					}
				}
			}
		}
	}
}
