class Saida {
	public void imprimir(String a, VetorVariavel v) {
		this.imprimindoAsBagacaTudo(a,v);
	}
	public void imprimirln(String a, VetorVariavel v) {
		this.imprimindoAsBagacaTudo(a,v);
		System.out.println();
	}
	private void imprimindoAsBagacaTudo(String a, VetorVariavel v) {
		int j, i = 0;
		//String b;
		while (a.charAt(i) != ')') {
			/*
			if (a.charAt(i) == '(' && a.charAt(i) == '+') {
				j = i+1;
				while(a.charAt(j) != ')' && a.charAt(j) != '+') j++;
				b = a.substring(i+1,j);
				System.out.println(b.toString());
				i = j;
			}
			i++; */
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
			i++;
		}
	}
}