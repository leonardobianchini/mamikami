class Saida {
	public void imprimir(String a, VetorVariavel v) {
		this.imprimindoAsBagacaTudo(a,v);
	}
	public void imprimirln(String a, VetorVariavel v) {
		this.imprimindoAsBagacaTudo(a,v);
		System.out.println();
	}
	private void imprimindoAsBagacaTudo(String a, VetorVariavel v) {
		if (a.equals("()")) return; //Gambiarra everywere, vou vier disso até quando? já é um vicio incuravel
		int j, i = 0;               //alguem me salva por favor!!
		while (a.charAt(i) != ')') {
			i++; //"correção" de bug, muito foda jogar o problema pra cima...
			if(a.charAt(i) == '+' || a.charAt(i) == ')') {
				if (a.charAt(i-1) == '"') {
					j = i-2;
					while(a.charAt(j) != '"') j--;
					System.out.print(a.substring(j+1,i-1));
				} else  {
					j = i-1;
					while(a.charAt(j) != '(' && a.charAt(j) != '+') j--;
					String b = a.substring(j+1,i);
					if (v.EuExisto(b)) {
						System.out.print(v.getValor(b));
					} else {
						try {
							System.out.print(Double.valueOf(b));
						} catch (Exception e) {
							System.out.print(b);
						}
					}
				}
			}
		}
	}
}