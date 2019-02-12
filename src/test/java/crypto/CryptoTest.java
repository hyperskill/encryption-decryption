package crypto;

import org.junit.Assert;
import org.junit.Test;

public class CryptoTest {

    @Test
    public void encrypt() {
        // GIVEN
        final String message = "Welcome to hyperskill!";
        final int key = 5;

        // WHEN
        String result = Crypto.encrypt(message, key);

        // THEN
        Assert.assertEquals("\\jqhtrj%yt%m~ujwxpnqq&", result);
    }

    @Test
    public void decrypt() {
        // GIVEN
        final String message = "\\jqhtrj%yt%m~ujwxpnqq&";
        final int key = 5;

        // WHEN
        String result = Crypto.decrypt(message, key);

        // THEN
        Assert.assertEquals("Welcome to hyperskill!", result);
    }
}