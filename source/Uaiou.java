class Uaiou extends Condicionais{

    public void Loop(String a,String b,VetorVariavel v){
        Token t = new Token();
        while(getCondicao(a, v)) t.InterpretaEscopo(b,v);
    }
}
