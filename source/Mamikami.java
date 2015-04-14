import java.util.Scanner;
class Mamikami {
	public static void main(String[] args) {
        Interpretador i = new Interpretador();
        Token t = new Token();
        Function f[];
        String linhas[] = i.CriaVetorArquivo(args[0]);
        f = i.IdentificaFuncoes(linhas);
        i.ExecutaMain(linhas);
    }
}