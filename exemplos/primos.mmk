main(){
	printiln("Informe um número positivo e inteiro");
	escaneadordofuturo(n);
	cont = 0;
	println(n);
	ifi(n > 0){
		quatro(i = 1; i <= n; i = i+1){
			aux = n % i;			
			ifi(aux == 0){
				cont = cont +1;
			}
		}
	}elsi{
		printiln(" Número negativo ou zero");
	}
	
	ifi(cont == 2){
		printiln("o número:" + n + "é primo");
	}
}
