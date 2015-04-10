class Token {
	public String getNomeVariavel(String a) { 
        String b = a; //faco essa atribuição porque Java enche o saco dizendo que a variavel não foi declarada
        for(int i = 0; i < a.length() ; i++) {
            if(a.charAt(i) == '=') {
                b = a.substring(0, i);
                b = b.trim();
            }
        }
        return b;
    }
    public String RemovePontoVirgula(String a) {
        String l = a; //faco essa atribuição porque Java enche o saco dizendo que a variavel não foi declarada
        for(int i = 0; i < a.length(); i++) {
            if(a.charAt(i) == ';') {
                l = a.substring(0,i);
                break;
            }
        }
        return l;
    }   
}