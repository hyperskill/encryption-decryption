package encryptdecrypt;

public class Main {
    public static void main(String[] args) {
        Crypto crypto = new Crypto();
        DataProcess dataProcess = new DataProcess(args);

        switch (dataProcess.getAlgorithm()) {
            case "unicode":
                crypto.setCipher(new UnicodeAlg());
                crypto.doMagic(dataProcess);
                break;
            case "shift":
                crypto.setCipher(new ShiftAlg());
                crypto.doMagic(dataProcess);
                break;
        }
    }
}
