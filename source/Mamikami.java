import java.util.Scanner;
class Mamikami {
	public static void main(String[] args) {
        Interpretador a = new Interpretador();
        int b = a.getNumeroLinhas(args[0]);
        String[] linhas = a.CriaVetor(args[0]);
        String l = a.RemovePontoVirgula(linhas[2]);
        System.out.println(l);
        System.out.println(a.TokenAtribuicaoVariavel(l));
       	a.IdentificaFuncao(linhas);
    }
}