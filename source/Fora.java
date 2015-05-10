class Fora extends Condicionais{
    public void javapp(String a,String b,String c,String d,VetorVariavel v){
            //a = código todo;b=condição;c =incremento; d = escopo;
            Token t = new Token();
            for(int i = 0; i < a.length(); i++){
                if(a.charAt(i) == '=')
                    t.TokenAtribuicaoValor(a,i,t.TokenAtribuicaoNome(a,i,v),v);
            }
            if(getCondicao(b, v))
                t.InterpretaEscopo(d,v);


    }
}
