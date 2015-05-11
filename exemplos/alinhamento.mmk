main() {
	i = 0;
	j = 1;
	uaiou(i < 3) {
		ifi(i == 0) {
			printiln("Zero");
		}
		ifi(i != 0) {
			printiln("Outro");
		}
		i = i + 1;
	}
	ifi(i == 3) {
		ifi(j == 0) {
			printiln("ok!");
		}
		ifi(j != 0) {
			printiln("erro");
		}
	}
}
