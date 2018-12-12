package translater;

public class Encrypter extends Translater {
	public Encrypter(String message, int key) {
		super(message,key);
	}
	public char symbolChange(char incomeWord) {
		return (char)((incomeWord+key)%127);
	}
}
