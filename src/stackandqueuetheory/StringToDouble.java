package stackandqueuetheory;

public class StringToDouble{
	public double oneLetterNumber(String a) {
		double tmp;
		if (a.length()>=2) {
			try {
				tmp = Double.parseDouble(a.substring(1));
			} catch (Exception e) {
				return -1;
			}
			return tmp;
		}
		return -1;
	}
}
