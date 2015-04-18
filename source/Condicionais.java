class Condicionais{
    private double antestoken,depoistoken;//variáveis para pegar o que tem antes e depois do token :D

    public boolean TesteDeCondicao(String testeifi){
        String  a = getParametrosFuncao(testeifi);/*usando sua função para pegar o que tem dentro dos parenteses */
        for(int i=0;i<testeifi.length();i++){
            if(testifi[i].testetoLowerCase().contains(ifi)){/*testar até achar a palavra reservada ifi*/
                // pega só o retorno da sua função e procura tokens
                //se você fez um algoritmo n² eu também posso
                for(int j=0;j < a.length();i++ ){
                        if(a[j].contains("<")){
                            antestoken = a[j-1];
                            depoistoken = a[j+1];
                            
                            if(antestoken < depoistoken)
                                return true;
                            else
                                return false;
                        }
                        else if(a.contains("<=")){
                            antestoken = a[j-1];
                            depoistoken = a[j+1];
                            if(antestoken <= depoistoken)
                                return true;
                            else
                                return false;
                        }
                        else if(a[j].contains(">")){
                            antestoken = a[j-1];
                            depoistoken = a[j+1];
                            if(antestoken > depoistoken)
                                return true;
                            else
                                return false;
                        }
                        else if(a[j].contains(">=")){
                            antestoken = a[j-1];
                            depoistoken = a[j+1];
                            if(antestoken >= depoistoken)
                                return true;
                            else
                                return false;
                        }
                        else if(a[j].contains("==")){
                            antestoken = a[j-1];
                            depoistoken = a[j+1];
                            if(antestoken == depoistoken)
                                return true;
                            else
                                return false;
                        }

                }
            }
        }
    }

}
