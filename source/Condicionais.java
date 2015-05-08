class Condicionais {
    private double antestoken,depoistoken;
    /*parametros
    1-Uma string contendo os parametros para saber o que tem dentro dos ()
    2-Um booleano para testar se as condiçoes são verdadeiras.Ex: a <b || a > b, caso seja true a tar
    primeira sentença ele retornaria true sem precisar mais nenhum teste porque true || alguma coisa é = true,
    mas caso seja a < b && a>b e a primeira sentença seja true ele ainda tem que testar a segunda sentença  e verificar,
    no caso daria true && false e retornaria false.
    3- um int para saber quantos tokes ainda restam para testar
    */
    private Token t = new Token();
    private boolean EuSouReal(String a, VetorVariavel v) {
        int i = 0;
        if (a.contains("true")) {
            return true;
        } else if (a.contains("false")) {
            System.out.println("Serio mesmo que você escreveu false como condicional?");
            return false; //Serio isso?
        } else {
            try {
                if (v.getValor(a) > 0) {
                    return true;
                }
            } catch (NullPointerException e) {
                if (Double.valueOf(a) > 0) {
                    return true;
                }
            } catch (NumberFormatException j) {
                
            }
        }
        while(i < a.length()) {
                if (a.charAt(i) == '=' && a.charAt(i+1) == '=') {
                String b = a.substring(0,i).replaceAll("\\s+","");
                int j = i;
                while(j < (a.length()) && a.charAt(j) != '|'  && a.charAt(j) != '&') j++;
                String c = a.substring(i+2, j).replaceAll("\\s+","");
                i = j;
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
                if (m == n) {
                    return true;
                }
            } else if (a.charAt(i) == '<') {
                if(a.charAt(i+1) == '=') {
                    String b = a.substring(0,i).replaceAll("\\s+","");
                    int j = i;
                    while(j < (a.length()) && a.charAt(j) != '|'  && a.charAt(j) != '&') j++;
                    String c = a.substring(i+2, j).replaceAll("\\s+","");
                    i = j;
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
                    }
                }
            } else if (a.charAt(i) == '>') {
                
            } else if (a.charAt(i) == '&') {
                
            } else if (a.charAt(i) == '|') {
                
            }
            i++;
        }
        return false;
    }
    public boolean getCondicao(String a, VetorVariavel v) {
        return this.EuSouReal(a,v);
    }
    public boolean  CadeiadeTokens(String parametros,boolean bool,int qtdtokens){//não façam isso e casa crianças!!!!
                int oi;
                try{
                    oi = Integer.parseInt(parametros);
                }finally{}
                if(oi != 0){
                    return true;
                }
                if(oi == 0){
                    return false;
                }

            return false;
    }
}
