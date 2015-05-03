class Bool extends Variavel{
    private Boolean valor;

    public void setValor(String valoratribuicao){
        this.valor  = Boolean.parseBoolean(valoratribuicao);
    }

    public Object getValor(){
        return this.valor;
    }
}
