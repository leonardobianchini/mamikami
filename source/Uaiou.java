class Uaiou extends Condicionais{

    public void Loop(String a,String b,VetorVariavel v){
        Token t = new Token();
        if(getCondicao(a, v))
            t.InterpretaEscopo(a,v);
    }
}
