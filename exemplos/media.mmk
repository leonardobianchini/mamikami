main(){
	printiln("informe a qtd de valores a serem inseridos");
	escaneadordofuturo(qtd);
	valor = 0;
	quatro(i = 0; i < qtd; i = i+1){
		printiln("informe um valor");
		escaneadordofuturo(aux);
		valor = aux + valor;
	}
	media = valor / qtd;
	printiln("a média é :"+ media);
	
}
