import java.util.*;
import java.io.*;
class Mamikami {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(new FileReader("um.mmk")).useDelimiter(";");
		while(scanner.hasNext()) {    
			String nome = scanner.next();
			String cidade = scanner.next();
			String dd = scanner.next();
			System.out.println(nome);
			System.out.println(cidade);
			System.out.println(dd);
		}
	}
}
