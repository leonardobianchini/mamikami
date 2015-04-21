class Token {
	private String tokens;

	public Token() {
		tokens = "=+-/*%";
	}
	public void InterpretaEscopo(String a, VetorVariavel v) {
		for (int i = 0;i < a.length(); i++) {
			if (tokens.toLowerCase().contains(a.valueOf(a.charAt(i)))) {
				if (a.charAt(i) == '=' && a.charAt(i+1) == '=') {
                    i++;
                    /*
                    Depois mais eu arrumo isso, momentaneamente funcionará para diferenciar igualdade
                    Vejamos dessa maneira, criando uma funcao que verifica palavras reservadas
                    não é necessario verificar igualdade =D    
                    */
                } else if (a.charAt(i) == '=') {
                    this.TokenAtribuicaoValor(a,this.TokenAtribuicaoNome(a,i,v),i);
				}
			}
		}
	}
    public VetorVariavel TokenAtribuicaoValor(String a, VariavelTemp v, int b) {
        int i = b;
        while(a.charAt(i) != ';') {
            i++;
            if (a.charAt(i) == '+') {
                v.setValor(this.TokenSoma(a,b,i,0));
            } else if (a.charAt(i) == ';') {
                a = a.substring(b, i);
                break;
            }
        }
        return null;
    }
    public double TokenSoma(String a, int i, int j, double valor) {
        while(i < a.length() && i > 0) {
            //System.out.println(getPalavra(i+1,j-1,a));
            break;
        }
        return 0;
    }
    public String getPalavra(int i, int j, String a) {
        while(i <= j) {
            if (a.charAt(i) == ' ') {
                i++;
            }else if (a.charAt(j) == ' ') {
                j--;
            } else {
                return a.substring(i,j+1);
            }
        }
        return a;
    }
    public VariavelTemp TokenAtribuicaoNome(String a, int i, VetorVariavel v) {
        String b = a;
        int j = i-1, k = 0;
        while(j >= 0) {
            if (b.charAt(j) != ' ') {
                k = 1;
            } else if(b.charAt(j) == ' ' && k == 1){
                b = b.substring(j+1,i);
                return v.setNovaVariavel(b);
            }
            j--;
        }
        return null;
    }
	public int getNVariaveis(String[] args) {
		int i = 0, j = 0;
		while(i < args.length) {
			if (args[i].toLowerCase().contains("=")) {
				j++;
			}
            i++;
		}
		return j;
	}
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
    			b = b.substring(j+1,i);
    			break;
    		}
    	}
    	return b;
    }
    public String getParametrosFuncao(String a) {
    	String b = a;
    	int i = 0, j = 0, k = 0;
    	while(i < a.length()) {
    		if(b.charAt(i) == '(') {
    			j++;
    		} else if(b.charAt(i) == ')') {
    			j--;
    		} if (j > 0 && k == 0) {
    			k = i;
    		} else if(j == 0 && k > 0) {
    			b = b.substring(k+1, i);
    			break;
    		}
    		i++;
    	}
    	return b;
    }
    //converte uma função apartir de uma palavra espeficica, procurando por seus escopos e retornando
    //apenas seus escopos em forma de uma string.
    ///Sei que isso está uma bosta mais está fazendo o que eu quero, mais tarde eu arrumo, ou quebro em
    ///funções menores, o que não iria diminuir o tempo de execução, HU3HU3HU3HU3HU3
   	public String FuncaoParaString(String[] a, String b) {
    	for (int i = 0; i < a.length ; i++) {
    		if(a[i].toLowerCase().contains(b)) {
    			if(!a[i].toLowerCase().contains(";")) {
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
    												c = c.concat(a[m].substring(0,n)); 
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