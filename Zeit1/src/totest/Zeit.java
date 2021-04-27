package totest;
public class Zeit implements ZeitIF {//Hoffe das funktioniert
	
	private int minuten;
	
	
	public Zeit(int min) {
		minuten=min;
		
	}
	public int getMin() {
		if(minuten<0) {
			throw new IllegalArgumentException("Werte kleiner Null sind nicht erlaubt");
		}
			return minuten;
	}
	public double getStunde() {
		if(minuten<1) {
			throw new IllegalArgumentException("Minuten dürfen beim aufruf dieser Funktion nicht kleiner 1 sein");
		}
		return ((double)minuten)/60;
	}
	@Override
	public void addMinuten(int zeit) {
		int temp=minuten+zeit;
		if(temp<0) {
			throw new IllegalArgumentException("ungültiger Wert!");
		}
		minuten += zeit;
		
	}

	
	
	
}
