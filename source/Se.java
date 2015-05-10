class Se extends Condicionais {
	public void ifi(String c, String d,VetorVariavel v) {
		if(this.getCondicao(c,v)) {
			Token t = new Token();
			t.InterpretaEscopo(d,v);
		}
	}
}