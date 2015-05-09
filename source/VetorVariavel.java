class VetorVariavel {
	private VariavelTemp[] v;
	public VetorVariavel(int i) {
		v = new VariavelTemp[i];
	}
	public VariavelTemp setNovaVariavel(String a) {
		for (int i = 0;i < v.length; i++) {
			if (v[i] == null) {
				v[i] = new VariavelTemp();
				v[i].setNome(a);
				return v[i];
			}
		}
		return null;
	}
	public VariavelTemp getVariavelPeloNome(String a) {
		for (int i = 0; i < v.length ; i++) {
			try {
				if (v[i].getNome().contains(a)) {
					return v[i];
				}
			} catch(Exception e) {
				continue;
			}
		}
		return null;
	}
	public void setValor(String a, double d) {
		this.getVariavelPeloNome(a).setValor(d);
	}
	public double getValor(String b) {
		return this.getVariavelPeloNome(b).getValor();
	}
	public boolean EuExisto(String b) {
		try {
			this.getValor(b);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}