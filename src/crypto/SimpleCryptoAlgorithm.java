package crypto;public class SimpleCryptoAlgorithm implements CryptoAlgorithm {

    @Override
    public String encryption(String message, String key) {
        String encrypt = "";
        int secretKey = 0;
        try {
            secretKey = Integer.parseInt(key);
        } catch (NumberFormatException ex) {
            System.out.println("Error: For the simple algorithm, the key must be a number");
        }
        for (int i = 0; i < message.length(); i++) {
            int index = message.charAt(i);

            if (index != -1) {
                int newIndex = index + secretKey;
                char c = (char) newIndex;
                encrypt += c;
            } else {
                encrypt += String.valueOf(index);;
            }
        }
        return encrypt;    }

    @Override
    public String decryption(String encryptedMessage, String key) {
        String encrypt = "";
        int secretKey = 0;
        try {
            secretKey = Integer.parseInt(key);
        } catch (NumberFormatException ex) {
            System.out.println("Error: For the simple algorithm, the key must be a number");
        }
        for (int i = 0; i < encryptedMessage.length(); i++) {
            int index = encryptedMessage.charAt(i);

            if (index != -1) {
                int newIndex = index - secretKey;
                char c = (char) newIndex;
                encrypt += c;
            } else {
                encrypt += String.valueOf(index);;
            }
        }
        return encrypt;
    }
}
