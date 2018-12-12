package crypto;

public class TranslaterFactory {
	public static Translater getTranslater(String cmd, String message, int key) {
		switch (cmd){
		case "dec":
			return new Decrypter(message, key);
		case "enc":
			return new Encrypter(message, key);
		default:
			return null;
		}
	}
}
