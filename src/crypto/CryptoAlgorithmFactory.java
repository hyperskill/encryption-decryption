package crypto;public class CryptoAlgorithmFactory {
    public static CryptoAlgorithm getAlgorithm(String algName) {
        if (algName.equals("aes")) {
            return new AesCryptoAlgorithm();
        } else {
            return new SimpleCryptoAlgorithm();
        }
    }
}
