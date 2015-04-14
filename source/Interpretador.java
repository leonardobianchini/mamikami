import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
class Interpretador {
    private int nota;
    private Function f[];
    //private Variavel v[];
    private Token t;

    public Function[] IdentificaFuncoes(String[] a) { //recebe o arquivo String e identifica as funções
        int j, k=0,l;
        t = new Token();
        j = t.getQtdPalavra(a, "function");
        f = new Function[j+1];
        String b;
        for (int i = 0; i < a.length ; i++) {
            if(a[i].toLowerCase().contains("main")) break;
            if(a[i].toLowerCase().contains("function")) {
                j = 0;
                while(a[i].charAt(j) != ')') j++;
                b = a[i].substring(0,j+1);
                b = t.RemovePalavra(b,"function");
                f[k] = new Function();
                f[k].setTipoRetorno(t.getRetornoFuncao(b));
                f[k].setNome(t.getNomeFuncao(b));
                f[k].setParametros(t.getParametrosFuncao(b));
                k++;
            }
        }
        return f;
    }
    //função que retorna o numero de linhas que tem o arquivo
    public int getNumeroLinhas(String args) {
        try {
            return this.NumeroLinhas(args);
        } catch (IOException e) {
            System.out.println("Do u try fuck with me?");
        }
        return 0;
    }
    //Função que diz exatamente o numero de linhas que tem o arquivo
    private int NumeroLinhas(String args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args));
        int linhas = 0;
        while(reader.readLine() != null)
            linhas++;
        return linhas;
    }
    //Função que cria o vetor, chamada pela main
    public String[] CriaVetorArquivo(String args){
        try {
            return this.ConverteArquivoVetorString(args,this.getNumeroLinhas(args));
        } catch (IOException e) {
            System.out.println("Arquivo não existente");
        }
        return null;
    }
    /*
    Função que utilizando do numero de linhas e do arquivo, aloca cada linha em um vetor.
    Tive que adicionar uma exceção a essa merda porque java ficaria me enchendo o saco caso isso nao ocorresse apesar
    de ter certeza que o arquivo existe porque a função numeroLinhas já diz isso para mim, enfim gg Java.
    */
    private String[] ConverteArquivoVetorString(String args, int a) throws IOException {
        /*é um vetor em que cada indice  tem toda  a a linha transformada em uma String*/
        String linhas[] = new String[a];
        File f = new File(args);
        Scanner s = new Scanner(f);
        int i = 0;
        while(s.hasNext()) {
            linhas[i] = s.nextLine();
            i++;
        }
        return linhas;
    }
    public void ExecutaMain(String[] args) {
        System.out.println(t.FuncaoParaString(args, "main"));
    }
}
