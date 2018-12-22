package crypto.algorithms;

public class CaesarAlgorithm implements CryptoAlgorithm {
    @Override
    public String enc(String originalStr, String key){
        int offset  = Integer.parseInt(key);
        return offsetAll(originalStr, offset);
    }

    @Override
    public String dec(String originalStr, String key){
        int offset  = Integer.parseInt(key);
        return offsetAll(originalStr, -offset);
    }

    private String offsetAll(String originalStr, int offset){
        StringBuilder out = new StringBuilder();
        char[] letters = new char[originalStr.length()];
        originalStr.getChars(0, originalStr.length(), letters, 0  );

        for (int letter : letters){
            letter = (letter + offset);
            out.append((char)letter);
        }

        return out.toString();
    }
}
