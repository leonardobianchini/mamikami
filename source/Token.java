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
   	public String FuncaoParaString(String[] a, String b) {
    	for (int i = 0; i < a.length ; i++) {
    		if(a[i].toLowerCase().contains(b)) {
    			if(a[i].toLowerCase().contains("{")) {
    				int l = 0;
    				for (int j = i;j < a.length; j++) {
    					for (int k = 0; k < a[j].length(); k++) {
    						if(a[j].charAt(k) == '{') {
    							l++;
    						} else if(a[j].charAt(k) == '}') {
    							l--;
    							if (l == 0) {
    								String c = "";
    								for (int m = i;m <= j; m++) {
    									if(m > i) {
    										c = c.concat(a[m]);
    									} else if(m == i) {
    										for (int n = 0; n < a[m].length(); n++) {
    											if(a[m].charAt(n) == '{') {
    												c = c.concat(a[m].substring(n,a[m].length()));
    											}
    										}
    									} else {
    										for (int n = 0; n < a[m].length(); n++) {
    											if(a[m].charAt(n) == '}') {
    												c = c.concat(a[m].substring(n,a[m].length())); 
    											}
    										}
    									}
    								}
    								return c;
    							}
    						}
    					}
    				}
    			}
    		}
    	}
    	return null;
    }
}