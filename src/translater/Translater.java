package translater;

public abstract class Translater {
	public String message;
	public int key;
	public Translater(String message, int key) {
		this.message = message;
		this.key = key;
	}
	//TRANSLATING STRING
	public String translate() {
		char[] tempArray = message.toCharArray();
		for (int i = 0; i < tempArray.length; i++) {
			tempArray[i] = symbolChange(tempArray[i]);
		}
		return String.valueOf(tempArray);
	}
	//ABSTRACT SYMBOL CHANGE METHOD
	public abstract char symbolChange(char incomeWord);	
}
