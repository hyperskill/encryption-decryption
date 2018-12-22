package crypto.algorithms;

public class VigenereAlgorithm implements CryptoAlgorithm{
    @Override
    public String enc(String message, String key) {
        message = message.toUpperCase();
        key = key.toUpperCase();
        StringBuilder out = new StringBuilder();
        message = message.toUpperCase();
        for (int i = 0, j = 0; i < message.length(); i++)
        {
            char c = message.charAt(i);
            if (c < 'A' || c > 'Z'){
                out.append(c);
            }else{
                out.append((char) ((c + key.charAt(j) - 2 * 'A') % 26 + 'A'));
                j = ++j % key.length();
            }
        }
        return out.toString();
    }

    @Override
    public String dec(String message, String key) {
        message = message.toUpperCase();
        key = key.toUpperCase();
        StringBuilder out = new StringBuilder();
        message = message.toUpperCase();
        for (int i = 0, j = 0; i < message.length(); i++)
        {
            char c = message.charAt(i);
            if (c < 'A' || c > 'Z'){
                out.append(c);
            }else{
                out.append((char) ((c - key.charAt(j) + 26) % 26 + 'A'));
                j = ++j % key.length();
            }
        }
        return out.toString();
    }
}
