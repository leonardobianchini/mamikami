import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
class Interpretador {
    private int nota;
    
    public String IdentificaFuncao(String[] a) { //recebe o arquivo String e identifica as funções
        String l[];// = a; //faco essa atribuição porque Java enche o saco dizendo que a variavel não foi declarada
        for (int i = 0; i < a.length ; i++) {
            if(a[i].toLowerCase().contains("function")) {
                System.out.println(a[i]);
            }
            if(a[i].toLowerCase().contains("main")) break;
        }
        return a[0];
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
    public String[] CriaVetor(String args) {
        try {
            return this.criaString(args,this.getNumeroLinhas(args));
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
    private String[] criaString(String args, int a) throws IOException {
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
}