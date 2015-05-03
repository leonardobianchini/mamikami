class Inteiro extends Variavel{
    private int valor;

    public void setValor(String valoratribuicao){
        this.valor = Integer.parseInt(valoratribuicao);
    }

    public Object getValor(){
        return this.valor;
    }
}
