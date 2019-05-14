package encryptdecrypt;

class Crypto {
    private Cipher cipher;

    void setCipher(Cipher cipher) {
        this.cipher = cipher;
    }

    void doMagic(DataProcess dataProcess) {
        if (dataProcess.getOperation().equals("enc")) {
            this.cipher.encrypt(dataProcess);
        } else {
            this.cipher.decrypt(dataProcess);
        }
    }
}
