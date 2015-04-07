import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
class Interpretador {
    private int nota;
    public void Token(String a) {
        
    }
    public String LerLinha(String linhas) {
        try {
            System.out.println(this.NumeroLinhas(linhas));
        } catch (IOException e) {
            System.out.println("Do u try fuck with me?");
        }
        return linhas;
    }
    public int NumeroLinhas(String args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args));
        int linhas = 0;
        while(reader.readLine() != null)
            linhas++;
        return linhas;
    }
}