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
    //Retorna quantas vezes a String aparece em um determinado vetor
    public int getQtdPalavra(String[] args, String a) {
    	int i=0;
    	while(args[i].toLowerCase().contains(a)) {
            i++;
        }
    	return i;
    }
    //remove uma palavra de uma string, no caso a
    public String RemovePalavra(String args, String a) {
    	int i=0;
    	String b = args;
    	while(i <= ((args.length())-(a.length()))) {
    		if(b.substring(i,(i+(a.length()))).equals(a)) {
    			return b.substring(0,i).concat(b.substring(i+(a.length()),args.length()));
    		}
    		i++;
    	}
    	return args;
    }
    public String getRetornoFuncao(String a) {
    	int i=0,j=1;
    	String b = a;
    	while(j <= a.length()) {
    		if (b.equals("int")||b.equals("double")||
    		b.equals("bool")||b.equals("String")|| b.equals("void")) {
    			return b;
    		}
    		if(a.charAt(i) == ' ') {
    			i++;
    		}
    		j++;
    		b = a.substring(i,j);
    	}
    	return b;
    }
    public String getNomeFuncao(String a) {
    	String b = a;
    	int i = 0, j = 0;
    	while(i < a.length()){
    		if(b.charAt(i) != '(') {
    			i++;
    			j = i-1;
    		} else if(b.charAt(j) != ' ') {
    			j--;
    		}else {
    			b = b.substring(j,i);
    			break;
    		}
    	}
    	return b;
    }
    public String getParametrosFuncao(String a) {
    	String b = a;
    	int i = 0;
    	while(i < a.length()) {
    		if(b.charAt(i) != '(') {
    			i++;
    		} else {
    			b = b.substring(i+1, a.length());
    			break;
    		}
    	}
    	return b;
    }
   	public String ProcuraMain(String[] a) {
    	for (int i = 0; i < a.length ; i++) {
    		System.out.println("OI");
    		if(a[i].toLowerCase().contains("main")) {
    			System.out.println("Bolhinho");
    			for (int j = 0; j < a[i].length();j++ ) {
    				if (a[i].charAt(j) == '{') {
    					System.out.println("bulacha");
    					int l = 0;
    					for (int k = j; k < a.length; k++) {
    						System.out.println("Caramelo");
    						if (a[k].toLowerCase().contains("{")) {
    							l++;
    						}
    						if (a[k].toLowerCase().contains("}") && l != 0) {
    							l--;
    						} else {
    							System.out.println("Caramelo");
    							String b = "";
    							for (int m = (k - j);m < j ; m++) {
    								b = b.concat(a[m]);
    							}
    							return b;
    						}
    					}
    				}
    			}
    		}
    	}
    	System.out.println("??");
    	return null;
    }
}
