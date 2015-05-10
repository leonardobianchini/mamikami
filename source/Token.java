class Token {
	private String tokens;
	private String[] palavrasReservadas;

	public Token() {
		tokens = "=+-/*%";
	}
    public void InterpretaEscopo(String a, VetorVariavel v) {
        String b;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == '=' && a.charAt(i+1) != '=') {
                this.TokenAtribuicaoValor(a,i,this.TokenAtribuicaoNome(a,i,v),v);
                while(a.charAt(i) != ';') i++;//Só para ele não ficar enrolando
            } else {
                for (int j = i;j < a.length(); j++) {
                    if (a.charAt(j) == ';' || a.charAt(j) == '='||a.charAt(j) == '}' ||
                        a.charAt(j) == '{' || a.charAt(j) == ')') {
                        if (a.charAt(j) == '=') {
                            i = j -1;
                            break;
                        }
                        i = j;
                        break;
                    } else if(a.charAt(j) == '(') {
                        b = a.substring(i,j);
                        if (b.equals("printi")) {
                            i = j;
                            while(a.charAt(j) != ';') j++;
                            Saida s = new Saida();
                            s.imprimir(a.substring((i),(j)),v);
                        } else if(b.equals("printiln")) {
                            i = j;
                            while(a.charAt(j) != ';') j++;
                            Saida s = new Saida();
                            s.imprimirln(a.substring((i),(j)),v);
                        } else if(b.equals("ifi")) {
                            i = j;
                            Se s = new Se();
                            while(a.charAt(j) != ')') j++;
                            String c = a.substring(i+1,j);
                            i = j; j++;
                            int k = 1;
                            while(a.charAt(j) != '}' && k == 0) {
                                j++;
                                if (a.charAt(j) == '{') k++;
                                if (a.charAt(j) == '}' && k != 0) k--;
                            }
                            s.ifi(c,a.substring(i+2,j+1),v);
                        }
                        i = j;
                        break;
                    }
                }
            }
        }
    }
    public VetorVariavel TokenAtribuicaoValor(String a, int b, VariavelTemp vt, VetorVariavel v) {
        int i = b;
        while(a.charAt(i) != ';') {
            i++;
            if (a.charAt(i) == '+') {
                vt.setValor(this.TokenSoma(a,b,i,0,v));
                break;
            } else if (a.charAt(i) == '-') {
                vt.setValor(this.TokenSubtracao(a,b,i,0,v));
                break;
            }else if (a.charAt(i) == '*') {
                vt.setValor(this.TokenMultiplicacao(a,b,i,1,v));
                break;
            } else if (a.charAt(i) == '/') {
                vt.setValor(this.TokenDivisao(a,b,i,1,v));
                break;
            } else if (a.charAt(i) == ';') {
                try {
                    vt.setValor(v.getValor(a.substring(b+1,i)));
                } catch (Exception e) {
                    vt.setValor(Double.valueOf(this.getPalavraNumero(b+1,i-1,a)));
                }
                break;
            }
        }
        return null;
    }
    public double TokenSoma(String a, int i, int j, double valor, VetorVariavel v) {
        String b;
        b = getPalavraNumero(i+1,j-1,a);
        try {
            valor += Double.valueOf(b);
        } catch (Exception e) {
            valor += v.getValor(b);
        }
        i = j;
        while(a.charAt(j) != ';') {
            j++;
            if (a.charAt(j) == '+') {
                return this.TokenSoma(a,i,j,valor,v);
            } else if (a.charAt(j) == '-') {
                return this.TokenSubtracao(a,i,j,valor,v);
            } else if (a.charAt(j) == '*') {
                return this.TokenMultiplicacao(a,i,j,valor,v);
            } else if (a.charAt(j) == '/') {
                return this.TokenDivisao(a,i,j,valor,v);
            } else if (a.charAt(j) == ';') {
                return this.TokenSoma(a,i,j,valor,v);
            }
        }
        return valor;
    }
    public double TokenSubtracao(String a, int i, int j, double valor, VetorVariavel v) {
        String b;
        b = getPalavraNumero(i+1,j-1,a);
        try {
            valor -= Double.valueOf(b);
        } catch (Exception e) {
            valor -= v.getValor(b);
        }
        i = j;
        while(a.charAt(j) != ';') {
            j++;
            if (a.charAt(j) == '+') {
                return this.TokenSoma(a,i,j,valor,v);
            } else if (a.charAt(j) == '-') {
                return this.TokenSubtracao(a,i,j,valor,v);
            } else if (a.charAt(j) == '*') {
                return this.TokenMultiplicacao(a,i,j,valor,v);
            } else if (a.charAt(j) == '/') {
                return this.TokenDivisao(a,i,j,valor,v);
            } else if (a.charAt(j) == ';') {
                return this.TokenSubtracao(a,i,j,valor,v);
            }
        }
        return valor;
    }
    public double TokenMultiplicacao(String a, int i, int j, double valor, VetorVariavel v) {
        String b;
        b = getPalavraNumero(i+1,j-1,a);
        try {
            valor *= Double.valueOf(b);
        } catch (Exception e) {
            valor *= v.getValor(b);
        }
        i = j;
        while(a.charAt(j) != ';') {
            j++;
            if (a.charAt(j) == '+') {
                return this.TokenSoma(a,i,j,valor,v);
            } else if (a.charAt(j) == '-') {
                return this.TokenSubtracao(a,i,j,valor,v);
            } else if (a.charAt(j) == '*') {
                return this.TokenMultiplicacao(a,i,j,valor,v);
            } else if (a.charAt(j) == '/') {
                return this.TokenDivisao(a,i,j,valor,v);
            } else if (a.charAt(j) == ';') {
                return this.TokenMultiplicacao(a,i,j,valor,v);
            }
        }
        return valor;
    }
    public double TokenDivisao(String a, int i, int j, double valor, VetorVariavel v) {
        String b;
        b = getPalavraNumero(i+1,j-1,a);
        try {
            valor /= Double.valueOf(b);
        } catch (Exception e) {
            valor /= v.getValor(b);
        }
        i = j;
        while(a.charAt(j) != ';') {
            j++;
            if (a.charAt(j) == '+') {
                return this.TokenSoma(a,i,j,valor,v);
            } else if (a.charAt(j) == '-') {
                return this.TokenSubtracao(a,i,j,valor,v);
            } else if (a.charAt(j) == '*') {
                return this.TokenMultiplicacao(a,i,j,valor,v);
            } else if (a.charAt(j) == '/') {
                return this.TokenDivisao(a,i,j,valor,v);
            } else if (a.charAt(j) == ';') {
                return this.TokenDivisao(a,i,j,valor,v);
            }
        }
        return valor;
    }
    public String getPalavraNumero(int i, int j, String a) {
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
            if(b.charAt(j) == '{' || b.charAt(j) == ';' || b.charAt(j) == '}') {
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
                                        if (a[m].contains("\"")) {
                                            c = c.concat(this.RemoveEspacosStrings(a[m]));
                                        }else if(m > i) {
    										c = c.concat(a[m].replaceAll("\\s+",""));
    									} else if(m == i) {
    										for (int n = 0; n < a[m].length(); n++) {
    											if(a[m].charAt(n) == '{') {
    												c = c.concat(a[m].substring(n,a[m].length()).replaceAll("\\s+",""));
    											}
    										}
    									}else {
    										for (int n = 0; n < a[m].length(); n++) {
    											if(a[m].charAt(n) == '}') {
    												c = c.concat(a[m].substring(0,n).replaceAll("\\s+",""));
    											}
    										}
    									}
    								}
                                    System.out.println(c);
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
    public String RemoveEspacosStrings(String a) {
        String b = "";
        int i = 0, j = 0, k = 0;
        while(i < a.length()) {
            if (a.charAt(i) == '"' && k == 0) {
                b = b.concat(a.substring(j,i).replaceAll("\\s+",""));
                k++;
                j = i;
            } else if (a.charAt(i) == '"' && k == 1) {
                b = b.concat(a.substring(j,i));
                k--;
                j = i;
            } else if (i == (a.length() -1)) {
                b = b.concat(a.substring(j,i+1).replaceAll("\\s+",""));
                k++;
                j = i;
            }
            i++;
        }
        return b;
    }
}
