class Se extends Condicionais {
	Token t = new Token();
	public boolean ifi(String c, String d,VetorVariavel v) {
		if(this.getCondicao(c,v)) {
			t.InterpretaEscopo(d,v);
			return true;
		} else {
			return false;
		}
	}
	public void Elsi(String a, VetorVariavel v) {
		t.InterpretaEscopo(a,v);
	}
}