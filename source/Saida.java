class Saida {
	public void imprimir(String a, VetorVariavel v) {
		this.recursaoPlus(0,a,v);
	}
	public void imprimirln(String a, VetorVariavel v) {
		this.recursaoPlus(0,a,v);
		System.out.println();
	}
	private void recursaoPlus(int i, String a, VetorVariavel v) {
		while (i < a.length()) {
			if (a.charAt(i) == '"') {
				int j = i+1;
				while(a.charAt(j) != '"') j++;
				System.out.print(a.substring(i+1,j));
				i = j;
			} else if(a.charAt(i) != ' ' && a.charAt(i) != '+') {
				int j = i+1;
				while(a.charAt(j) != ' ') j++;
				String b = a.substring(i,j);
				if (v.EuExisto(b)) {
					System.out.print(v.getValor(b));
				} else {
					try {
						System.out.print(Double.valueOf(b));
					} catch (Exception e) {
						System.out.print(b);
					}
				}
				i = j;
			}
			i++;
			if (i == a.length()) break; 
			if (a.charAt(i) == '+') {
				this.recursaoPlus(i,a,v);
				break;
			}
		}
	}
}