package crypto;public interface CryptoAlgorithm {
    String encryption(String message, String key);
    String decryption(String encryptedMessage, String key);
}
