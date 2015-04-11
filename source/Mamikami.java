import java.util.Scanner;
class Mamikami {
	public static void main(String[] args) {
        Interpretador a = new Interpretador();
        Token t = new Token();
        int b = a.getNumeroLinhas(args[0]);
        String linhas[] = a.CriaVetorArquivo(args[0]);
        a.IdentificaFuncoes(linhas);
    }
}