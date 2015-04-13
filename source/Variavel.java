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

	public void setNome(String variavel) {
		this.nome = variavel;
	}

	public void setTipoValor(String valoratribuicao){
		// recebe  oque tem depois do = e antes do ; e testa qual o melhor tipo
		//e atribui aqui mesmo
		for(int i=0;i<valoratribuicao.length();i++){
			if(valoratribuicao.equals("¬¬")) {
				this.valors= valoratribuicao;
				this.tipo = "String";
			}
			else if(valoratribuicao.equalsIgnoreCase("true")){
				this.valorb=true;
				this.tipo = "boolean";
			}
			else if(valoratribuicao.equalsIgnoreCase("false")){
				this.valorb = false;
				this.tipo = "boolean";
			}
			else if(valoratribuicao.charAt(i) == '.'){
				this.valord= Double.parseDouble(valoratribuicao);
				this.tipo = "double";
			}
			else{
				this.valori = Integer.parseInt(valoratribuicao);
	       		this.tipo="int";
			}
		}
	}
}
