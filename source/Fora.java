class Fora extends Condicionais{
    public void BestLoopEver(String a,String b,String c,String d,String e,VetorVariavel v){
            //a = código todo;b = atribuição;c=condição;d=incremento;e=escopo;
            Token t = new Token();
            String ab = "{";
            b = ab.concat(b).concat(";}");
            d = ab.concat(d).concat(";}");
            t.InterpretaEscopo(b,v);
            while(this.getCondicao(c,v)){
                t.InterpretaEscopo(e,v);
                t.InterpretaEscopo(d,v);
            }
    }
}
