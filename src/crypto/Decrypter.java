package crypto;

public class Decrypter extends Translater{
	public Decrypter(String message, int key) {
		super(message,key);
	}
	public char symbolChange(char incomeWord) {
		return (char)((incomeWord-key)%127);
	}
}
