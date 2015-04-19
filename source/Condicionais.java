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
    public boolean  CadeiadeTokens(String parametros,boolean bool,int qtdtokens){//não façam isso e casa crianças!!!!
                int oi;
                try{
                    oi = Integer.parseInt(parametros);
                }catch(Exception a){
                    return false;
                }
                if(oi != 0){
                    return true;
                }
                if(oi == 0){
                    return false;
                }

            return false;
    }
}
