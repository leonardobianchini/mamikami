class Matematica {
	public void Expressao(String a, VetorVariavel v) {
		Token t = new Token();
		int i = 0, j = 0;
		String b="", c="";
		while(a.charAt(i) != ';') {
			if (a.charAt(i) == '=') {
				b = a.substring(j,i);
				c = a.substring(i+1, a.length());
				break;
			}
			i++;
		}
		if (v.EuExisto(b)) {
			v.setValor(b,this.Recursao(c,v));
		} else {
			v.setNovaVariavel(b).setValor(this.Recursao(c,v));
		}
	}
	private double Recursao(String a, VetorVariavel v) {
		int i = 0, j = 0;
		while(a.charAt(i) != ';') {
			if (a.charAt(i) == '(') {
				int m = i;
				while(a.charAt(m) != ')') m++;
				a = a.substring(0,i).concat((String.valueOf(Recursao(a.substring(i+1,m).concat(";"),v))).concat(a.substring(m+1,a.length())));
			} else if(a.charAt(i) == '/' && j == 1) {
				int m = i-1, n = i+1;
				while(m > 0 &&a.charAt(m) != '+' &&a.charAt(m) != '-' &&a.charAt(m) != '*'&&a.charAt(m) != '/') m--;
				while(n < a.length() &&a.charAt(n) != '+' &&a.charAt(n) != '-'
					&& a.charAt(n) != ';' &&a.charAt(n) != '*'&&a.charAt(n) != '/') n++;
				a = a.substring(0,m).concat(this.Divisao(a.substring(m,i),a.substring(i+1,n),v)).concat(a.substring(n,a.length()));
				i = 0;
			} else if (a.charAt(i) == '*' && j == 1) {
				int m = i-1, n = i+1;
				while(m > 0 &&a.charAt(m) != '+' &&a.charAt(m) != '-' &&a.charAt(m) != '*'&&a.charAt(m) != '/') m--;
				while(n < a.length() &&a.charAt(n) != '+' &&a.charAt(n) != '-'
					&& a.charAt(n) != ';' &&a.charAt(n) != '*'&&a.charAt(n) != '/') n++;
				a = a.substring(0,m).concat(this.Multiplicacao(a.substring(m,i),a.substring(i+1,n),v)).concat(a.substring(n,a.length()));
				i = 0;
			} else if (a.charAt(i) == '+' && j == 2) {
				int m = i-1, n = i+1;
				while(m > 0 &&a.charAt(m) != '+' &&a.charAt(m) != '-' &&a.charAt(m) != '*'&&a.charAt(m) != '/') m--;
				while(n < a.length() &&a.charAt(n) != '+' &&a.charAt(n) != '-'
					&& a.charAt(n) != ';' &&a.charAt(n) != '*'&&a.charAt(n) != '/') n++;
				a = a.substring(0,m).concat(this.Soma(a.substring(m,i),a.substring(i+1,n),v)).concat(a.substring(n,a.length()));
				i = 0;
			} else if (a.charAt(i) == '-' && j == 2) {
				int m = i-1, n = i+1;
				while(m > 0 &&a.charAt(m) != '+' &&a.charAt(m) != '-' &&a.charAt(m) != '*'&&a.charAt(m) != '/') m--;
				while(n < a.length() &&a.charAt(n) != '+' &&a.charAt(n) != '-'
					&& a.charAt(n) != ';' &&a.charAt(n) != '*'&&a.charAt(n) != '/') n++;
				a = a.substring(0,m).concat(this.Subtracao(a.substring(m,i),a.substring(i+1,n),v)).concat(a.substring(n,a.length()));
				i = 0;
			} else if (a.charAt(i+1) == ';' && j < 3) {
				j++;
				i = 0;
			}
			i++;
		}
		if (v.EuExisto(a.substring(0,(a.length()-1)))) {
			return v.getValor(a.substring(0,(a.length()-1)));
		}
		return Double.valueOf(a.substring(0,(a.length()-1)));
	}
	private String Soma (String a, String b, VetorVariavel v) {
		double i, j;
		if (v.EuExisto(a)) {
			i = v.getValor(a);
		}
		else {
			i = Double.valueOf(a);
		}
		if(v.EuExisto(b)) {
			j = v.getValor(b);
		} else {
			j = Double.valueOf(b);
		}
		if ((i + j) >= 0) return ("+").concat(String.valueOf(i + j));
		return String.valueOf(i + j);
	}
	private String Subtracao(String a, String b, VetorVariavel v){
		double i, j;
		if (v.EuExisto(a)) {
			i = v.getValor(a);
		}
		else {
			i = Double.valueOf(a);
		}
		if(v.EuExisto(b)) {
			j = v.getValor(b);
		} else {
			j = Double.valueOf(b);
		}
		if ((i - j) >= 0) return ("+").concat(String.valueOf(i - j));
		return String.valueOf(i - j);
	}
	private String Multiplicacao(String a, String b, VetorVariavel v){
		double i, j;
		if (v.EuExisto(a)) {
			i = v.getValor(a);
		}
		else {
			i = Double.valueOf(a);
		}
		if(v.EuExisto(b)) {
			j = v.getValor(b);
		} else {
			j = Double.valueOf(b);
		}
		if ((i * j) >= 0) return ("+").concat(String.valueOf(i * j));	
		return String.valueOf(i * j);
	}
	private String Divisao(String a, String b, VetorVariavel v){
		double i, j;
		if (v.EuExisto(a)) {
			i = v.getValor(a);
		}
		else {
			i = Double.valueOf(a);
		}
		if(v.EuExisto(b)) {
			j = v.getValor(b);
		} else {
			j = Double.valueOf(b);
		}
		if ((i / j) >= 0) return ("+").concat(String.valueOf(i / j));
		return String.valueOf(i / j);
	}
}