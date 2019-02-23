package crypto;

import java.util.*;

public class Crypto {

    private static final String ENCRYPTION = "enc";
    private static final String DECRYPTION = "dec";

    static final String MODE_KEY = "-mode";
    static final String CRYPTO_KEY = "-key";
    static final String DATA_KEY = "-data";

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {

        try {
            final Map<String, String> params = Crypto.parseArgs(args);
            Crypto.prepareParams(params);

            String mode = params.get(MODE_KEY);
            String data = params.get(DATA_KEY);
            String stringKey = params.get(CRYPTO_KEY);

            int key;
            if(isDigit(stringKey)) {
                key = Integer.parseInt(stringKey);
            } else {
                throw new RuntimeException("Encryption key must be an integer.");
            }

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

        } catch (RuntimeException e) {
            System.out.println("Operation failed. An error has occurred: " + e.getMessage());
        }
    }

    public static Map<String,String> parseArgs(String[] args) {
        Map<String, String> params = new HashMap<>();
        params.put(MODE_KEY, null);
        params.put(CRYPTO_KEY, null);
        params.put(DATA_KEY, null);

        int i = 0;
        while(i < args.length) {

            String key = args[i];

            if (isNotKey(args[i])) {
                throw new RuntimeException("The parameter key must contains the prefix '-'");
            }

            if (params.containsKey(key)) {
                i++;

                if (i < args.length && isNotKey(args[i]) && args[i] != null) {
                    params.put(key, args[i]);
                } else  {
                    throw new RuntimeException("Value of parameter " + key + " is not defined");
                }

            } else {
                throw new RuntimeException("Unsupported key");
            }

            if (isNotKey(args[i])) {
                i++;
            }
        }

        return params;
    }

    public static boolean isNotKey(String s) {
        return !s.startsWith("-");
    }

    private static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void prepareParams (Map<String, String> params) {
        params.putIfAbsent(MODE_KEY, ENCRYPTION);

        if (params.get(CRYPTO_KEY) == null || params.get(CRYPTO_KEY).isEmpty()) {
            System.out.println("Enter key:");
            String in = "";
            while (in.isEmpty()) {
                in = SCANNER.nextLine();
                if (in.isEmpty()) {
                    System.out.println("Value cannot be empty. Enter key:");
                }
            }
            params.put(CRYPTO_KEY, in);
        }

        if (params.get(DATA_KEY) == null || params.get(DATA_KEY).isEmpty()) {
            System.out.println("Enter data string:");
            String in = "";
            while (in.isEmpty()) {
                in = SCANNER.nextLine();
                if (in.isEmpty()) {
                    System.out.println("Value cannot be empty. Enter data string:");
                }
            }
            params.put(DATA_KEY, in);
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
