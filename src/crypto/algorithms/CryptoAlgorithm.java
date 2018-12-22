package crypto.algorithms;

import java.util.Optional;

public interface CryptoAlgorithm {
    String enc(String offset, String key);
    String dec(String offset, String key);
}
