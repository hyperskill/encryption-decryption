package crypto;

import org.junit.Assert;
import org.junit.Test;
import java.util.Map;

import static crypto.Crypto.*;

public class CryptoTest {

    private static final String MODE_VALUE = "enc";
    private static final String CRYPTO_VALUE = "5";
    private static final String DATA_VALUE = "Welcome to hyperskill!";

    @Test
    public void parseArgsSuccess() {
        // GIVEN
        String[] args = {MODE_KEY, MODE_VALUE, CRYPTO_KEY, CRYPTO_VALUE, DATA_KEY, DATA_VALUE};

        // WHEN
        Map<String,String> result = Crypto.parseArgs(args);

        // THEN
        Assert.assertEquals(MODE_VALUE, result.get(MODE_KEY));
        Assert.assertEquals(CRYPTO_VALUE, result.get(CRYPTO_KEY));
        Assert.assertEquals(DATA_VALUE, result.get(DATA_KEY));
    }

    @Test (expected = RuntimeException.class)
    public void parseArgsWithoutModeValue() {
        // GIVEN
        String[] args = {MODE_KEY, CRYPTO_KEY, CRYPTO_VALUE, DATA_KEY, DATA_VALUE};

        // WHEN
        Map<String,String> result = Crypto.parseArgs(args);

        // THEN
        // RuntimeException
    }

    @Test (expected = RuntimeException.class)
    public void parseArgsWithoutKey() {
        // GIVEN
        String[] args = {"nokey", MODE_VALUE};

        // WHEN
        Map<String,String> result = Crypto.parseArgs(args);

        // THEN
        // RuntimeException
    }

    @Test (expected = RuntimeException.class)
    public void parseArgsWithUnsupportedKey() {
        // GIVEN
        String[] args = {"-unsupportedkey", MODE_VALUE};

        // WHEN
        Map<String,String> result = Crypto.parseArgs(args);

        // THEN
        // RuntimeException
    }

    @Test
    public void encryptSucsees() {
        // GIVEN
        final String message = "Welcome to hyperskill!";
        final int key = 5;

        // WHEN
        String result = Crypto.encrypt(message, key);

        // THEN
        Assert.assertEquals("\\jqhtrj%yt%m~ujwxpnqq&", result);
    }

    @Test
    public void decryptSuccess() {
        // GIVEN
        final String message = "\\jqhtrj%yt%m~ujwxpnqq&";
        final int key = 5;

        // WHEN
        String result = Crypto.decrypt(message, key);

        // THEN
        Assert.assertEquals("Welcome to hyperskill!", result);
    }
}