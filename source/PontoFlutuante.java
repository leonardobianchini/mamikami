class PontoFlutuante extends Variavel{
    private double valor;

    public void setValor(String valoratribuicao){
        this.valor = Double.parseDouble(valoratribuicao);
    }

    public Object getValor(){
        return this.valor;
    }

}
