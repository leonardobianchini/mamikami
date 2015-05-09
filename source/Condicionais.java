class Condicionais {
    /*parametros
    1-Uma string contendo os parametros para saber o que tem dentro dos ()
    2-Um booleano para testar se as condiçoes são verdadeiras.Ex: a <b || a > b, caso seja true a tar
    primeira sentença ele retornaria true sem precisar mais nenhum teste porque true || alguma coisa é = true,
    mas caso seja a < b && a>b e a primeira sentença seja true ele ainda tem que testar a segunda sentença  e verificar,
    no caso daria true && false e retornaria false.
    3- um int para saber quantos tokes ainda restam para testar
    */
    private Token t = new Token();
    private boolean Igual(String b, String c, VetorVariavel v) {
        double m = 0, n = 1;
        try {
            n = v.getValor(b);
        } catch (Exception e) {
           n = Double.valueOf(b);
        }
        try {
            m = v.getValor(c);
        } catch (Exception e) {
            m = Double.valueOf(c);
        }
        if (n == m) {
            return true;
        } else {
            return false;
        }
    }
    private boolean MenorIgual(String b, String c, VetorVariavel v) {
        double m = 0, n = 1;
        try {
            n = v.getValor(b);
        } catch (Exception e) {
           n = Double.valueOf(b);
        }
        try {
            m = v.getValor(c);
        } catch (Exception e) {
            m = Double.valueOf(c);
        }
        if (n <= m) {
            return true;
        } else {
            return false;
        }
    }
    private boolean MaiorIgual(String b, String c, VetorVariavel v) {
        double m = 0, n = 1;
        try {
            n = v.getValor(b);
        } catch (Exception e) {
           n = Double.valueOf(b);
        }
        try {
            m = v.getValor(c);
        } catch (Exception e) {
            m = Double.valueOf(c);
        }
        if (n >= m) {
            return true;
        } else {
            return false;
        }
    }
    private boolean Maior(String b, String c, VetorVariavel v) {
        double m = 0, n = 1;
        try {
            n = v.getValor(b);
        } catch (Exception e) {
           n = Double.valueOf(b);
        }
        try {
            m = v.getValor(c);
        } catch (Exception e) {
            m = Double.valueOf(c);
        }
        if (n > m) {
            return true;
        } else {
            return false;
        }
    }
    private boolean Menor(String b, String c, VetorVariavel v) {
        double m = 0, n = 1;
        try {
            n = v.getValor(b);
        } catch (Exception e) {
           n = Double.valueOf(b);
        }
        try {
            m = v.getValor(c);
        } catch (Exception e) {
            m = Double.valueOf(c);
        }
        if (n < m) {
            return true;
        } else {
            return false;
        }
    }
    // Que merda em?
    public boolean Operacao(String a, VetorVariavel v, int i) {
        boolean condicao = false;
        String b, c;
        while(i < a.length()) {
            if (a.charAt(i) == '=' && a.charAt(i+1) == '=') {
                int j = i-1;
                while(j > 0 && a.charAt(j) != '|' && a.charAt(j) != '&') j--;
                if (j == 0) {
                    b = a.substring(j,i);
                } else {
                    b = a.substring(j+1,i);
                }
                j = i;
                while(j < a.length() && a.charAt(j) != '|' && a.charAt(j) != '&') j++;
                c = a.substring(i+2,j);
                condicao = this.Igual(b,c,v);
            } else if (a.charAt(i) == '<') {
                if(a.charAt(i+1) == '=') {
                    int j = i-1;
                    while(j > 0 && a.charAt(j) != '|' && a.charAt(j) != '&') j--;
                    if (j == 0) {
                        b = a.substring(j,i);
                    } else {
                        b = a.substring(j+1,i);
                    }
                    j = i;
                    while(j < a.length() && a.charAt(j) != '|' && a.charAt(j) != '&') j++;
                    c = a.substring(i+2,j);
                    condicao =  this.MenorIgual(b,c,v);
                } else {
                    int j = i-1;
                    while(j > 0 && a.charAt(j) != '|' && a.charAt(j) != '&') j--;
                    if (j == 0) {
                        b = a.substring(j,i);
                    } else {
                        b = a.substring(j+1,i);
                    }
                    j = i;
                    while(j < a.length() && a.charAt(j) != '|' && a.charAt(j) != '&') j++;
                    c = a.substring(i+1,j);

                    condicao =  this.Menor(b,c,v);
                }
            } else if (a.charAt(i) == '>') {
                if (a.charAt(i+1) == '=') {
                    int j = i-1;
                    while(j > 0 && a.charAt(j) != '|' && a.charAt(j) != '&') j--;
                    if (j == 0) {
                        b = a.substring(j,i);
                    } else {
                        b = a.substring(j+1,i);
                    }
                    j = i;
                    while(j < a.length() && a.charAt(j) != '|' && a.charAt(j) != '&') j++;
                    c = a.substring(i+2,j);
                    condicao =  this.MaiorIgual(b,c,v);
                } else {
                    int j = i-1;
                    while(j > 0 && a.charAt(j) != '|' && a.charAt(j) != '&') j--;
                    if (j == 0) {
                        b = a.substring(j,i);
                    } else {
                        b = a.substring(j+1,i);
                    }
                    j = i;
                    while(j < a.length() && a.charAt(j) != '|' && a.charAt(j) != '&') j++;
                    c = a.substring(i+1,j);
                    condicao =  this.Maior(b,c,v);
                }
            } else if (a.charAt(i) == '&') {
                if (condicao) {
                    return this.Operacao(a,v,i+2);
                } else {
                    return false;
                }
            } else if (a.charAt(i) == '|') {
                if (!condicao) {
                    return this.Operacao(a,v,i+2);
                } else {
                    return true;
                }
            }
            i++;
        }
        return condicao;
    }
    private boolean EuSouReal(String a, VetorVariavel v) {
        if (a.equals("true")) {
            return true;
        } else if (a.equals("false")) {
            System.out.println("Serio mesmo que você escreveu false como condicional?");
            return false; //Serio isso?
        } else {
            try {
                if(a.equals("")){
                    return false;
                }else if (v.getValor(a) > 0) {
                    return true;
                }
            } catch (java.lang.NumberFormatException e) {
                if (Double.valueOf(a) > 0) {
                    return true;
                }
            } catch (Exception j) {

            }
        }
        return this.Operacao(a,v,0);
    }
    public boolean getCondicao(String a, VetorVariavel v) {
        return this.EuSouReal(a,v);
    }
}
