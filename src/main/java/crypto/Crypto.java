package crypto;

import java.util.*;

public class Crypto {

    private static final String ENCRYPTION = "enc";
    private static final String DECRYPTION = "dec";

    private static final String MODE_KEY = "-mode";
    private static final String CRYPTO_KEY = "-key";
    private static final String DATA_KEY = "-data";

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {

        final Map<String, String> params = parseArgs(args);
        prepareParams(params);

        String mode = params.get(MODE_KEY);
        String data = params.get(DATA_KEY);
        int key = Integer.parseInt(params.get(CRYPTO_KEY));
        String outputString;

        switch (mode) {
            case ENCRYPTION: outputString = encrypt(data, key);
                break;
            case DECRYPTION: outputString = decrypt(data, key);
                break;
            default:
                throw new UnsupportedOperationException("Operation '" + mode + "' is not supported.");
        }

        System.out.println(outputString);
    }

    private static Map<String,String> parseArgs(String[] args) {
        Map<String, String> params = new HashMap<>();
        params.put(MODE_KEY, null);
        params.put(CRYPTO_KEY, null);
        params.put(DATA_KEY, null);

        for (int i = 0; i < args.length; i++) {

            String key = args[i];

            if (!key.startsWith("-")) {
                throw new RuntimeException("The parameter key must contains the prefix '-'");
            }

            if (params.containsKey(key)) {
                i++;
                String value = (i < args.length) ? args[i] : null;
                params.put(key, value);
            } else {
                throw new RuntimeException("Unsupported key");
            }
        }

        return params;
    }

    public static void prepareParams (Map<String, String> params) {
        params.putIfAbsent(MODE_KEY, ENCRYPTION);

        if (params.get(CRYPTO_KEY) == null) {
            System.out.println("Enter key:");
            params.put(CRYPTO_KEY, SCANNER.nextLine());
        }

        if (params.get(DATA_KEY) == null) {
            System.out.println("Enter data string:");
            params.put(DATA_KEY, SCANNER.nextLine());
        }
    }

    public static String encrypt(String message, int key) {
        char[] sourceData = message.toCharArray();
        char[] transformData = new char[sourceData.length];

        for (int i = 0; i < sourceData.length; i++) {
            transformData[i] = (char) (sourceData[i] + key);
        }

        return new String(transformData);
    }

    public static String decrypt(String message, int key) {
        char[] sourceData = message.toCharArray();
        char[] transformData = new char[sourceData.length];

        for (int i = 0; i < sourceData.length; i++) {
            transformData[i] = (char) (sourceData[i] - key);
        }

        return new String(transformData);
    }
}
