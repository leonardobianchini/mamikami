class Se extends Condicionais {
	public boolean ifi(String c, String d,VetorVariavel v) {
		if(this.getCondicao(c,v)) {
			Token t = new Token();
			t.InterpretaEscopo(d,v);
			return true;
		} else {
			return false;
		}
	}
}