class Testeifi{
    private double antestoken,depoistoken;//variáveis para pegar o que tem antes e depois do token :D

    public boolean TesteDeCondicao(String testeifi){
        Token algo = new Token();
        String  a = algo.getParametrosFuncao(testeifi);
        int count=0;
        for(int i=0;i<a.length();i++){
            if(a.equals('<')||a.equals("<=")||a.equals('>')||a.equals(">=")||a.equals("=="))
                count++;
        }
        Condicionais wifi = new Condicionais();
        boolean ret = wifi.CadeiadeTokens(a,false,count);
        return ret;
    }
}
