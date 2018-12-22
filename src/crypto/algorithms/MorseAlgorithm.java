package crypto.algorithms;

public class MorseAlgorithm implements CryptoAlgorithm {
    /*available punctuation*/
    private static final String PUNCTUATIONS = ".,!?";

    @Override
    public String enc(String message, String key) {
        StringBuilder out = new StringBuilder();
        char[] letters = new char[message.length()];
        message.getChars(0, message.length(), letters, 0  );

        MorseAlphabet morseCode;
        String strLetter;
        for (char letter : letters){
            strLetter = Character.toString(letter);
            if(Character.isLetter(letter)){
                morseCode = MorseAlphabet.valueOf(strLetter.toUpperCase());
                out.append(morseCode.toString());
            } else if(Character.isDigit(letter)) {
                morseCode = MorseAlphabet.NUMBER;
                out.append(morseCode.toString(strLetter));
            }else if(MorseAlgorithm.PUNCTUATIONS.contains(Character.toString(letter))){
                morseCode = MorseAlphabet.PUNCTUATION;
                out.append(morseCode.toString(strLetter));
            }else{
                out.append(letter);
            }
            if(letter == ' '){
                out.append("     ");
            } else{
                out.append(' ');
            }

        }
        return out.toString();
    }

    @Override
    public String dec(String message, String key) {
        StringBuffer out = new StringBuffer();
        MorseAlphabet[] alphabet = MorseAlphabet.values();
        String[] words = message.split("       ");
        String[] letters;
        String morseCode;
        for (int i = 0; i < words.length; i++){
            letters = words[i].split(" ");
            for (int j=0;j< letters.length;j++){
                morseCode = letters[j];
                out.append(MorseAlphabet.getValue(morseCode));
            }
            if(i != words.length - 1){
                out.append(' ');
            }
        }
        return out.toString();
    }

}
