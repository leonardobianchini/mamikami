class Fora extends Condicionais{
    public void BestLoopEver(String a,String b,String c,String d,String e,VetorVariavel v, int aux, int aux2){
            //a = código todo;b = atribuição;c=condição;d=incremento;e=escopo;
            Token t = new Token();
            System.out.println(e);
            System.out.println(c);
            t.TokenAtribuicaoValor(a,aux,t.TokenAtribuicaoNome(a,aux,v),v);
            System.out.println(this.getCondicao(c,v));
            while(this.getCondicao(c,v)){
                t.InterpretaEscopo(e,v);
                t.TokenAtribuicaoValor(a,aux2,t.TokenAtribuicaoNome(a,aux2,v),v);
            }
    }
}
