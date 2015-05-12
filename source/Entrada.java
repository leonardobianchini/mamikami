import java.util.Scanner;
class Entrada {
	public void DoubleEntrada(String a, VetorVariavel v) {
		Scanner sc = new Scanner(System.in);
		double entrada = sc.nextDouble();
		this.VerificaVariavel(a,v).setValor(entrada);
		this.VerificaVariavel(a,v).setNome(a);
	}
	private VariavelTemp VerificaVariavel(String a, VetorVariavel v) {
		if (v.EuExisto(a)) {
			return v.getVariavelPeloNome(a);
		} else {
			return v.setNovaVariavel(a);
		}
	}
}