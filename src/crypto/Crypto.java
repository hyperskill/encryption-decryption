package crypto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

interface ICrypto
{
    byte[] encrypt(byte[] data, String key);
    byte[] decrypt(byte[] data, String key);
}

class CryptoShift implements ICrypto
{
    @Override
    public byte[] encrypt(byte[] data, String key) {

        String text = "";
        for (int i = 0; i < data.length; i++) {
            text += (char)(data[i] + Integer.parseInt(key));
        }
        return text.getBytes();
    }
    @Override
    public byte[] decrypt(byte[] data, String key) {

        String text = "";
        for (int i = 0; i < data.length; i++) {
            text += (char)(data[i] - Integer.parseInt(key));
        }
        return text.getBytes();
    }
}

class Crypter
{
    private ICrypto alg;

    public Crypter(String alg) throws Exception
    {
        switch (alg.toLowerCase()) {
            case "shift":
                this.alg = new CryptoShift();
                break;
            default:
                throw new Exception("Invalid algorithm");
        }
    }

    public byte[] crypt(byte[] data, String key, String mode)
    {
        if (mode.toLowerCase().equals("enc"))
            return alg.encrypt(data, key);
        if (mode.toLowerCase().equals("dec"))
            return alg.decrypt(data, key);
        return null;
    }

}


public class Crypto  {
    public static void main(String[] args) throws IOException, Exception {
        String mode = "";
        String filein = "";
        String fileout = "";
        String alg = "";
        String key = "";
        for (int i = 0; i < args.length; i++) {
            switch (args[i])
            {
                case "-mode":
                    if (i+1 < args.length)
                        mode = args[i+1];
                    break;
                case "-key":
                    if (i+1 < args.length)
                        key = args[i+1];
                    break;
                case "-in":
                    if (i+1 < args.length)
                        filein = args[i+1];
                    break;
                case "-out":
                    if (i+1 < args.length)
                        fileout = args[i+1];
                    break;
                case "-alg":
                    if (i+1 < args.length)
                        alg = args[i+1];
                    break;
            }
        }

        if (mode.isEmpty()||filein.isEmpty()||fileout.isEmpty()||!new File(filein).exists()) return;

        FileInputStream fi = new FileInputStream(filein);
        FileOutputStream fo = new FileOutputStream(fileout);

        byte[] data = new byte[fi.available()];
        fi.read(data,0,fi.available());
        Crypter cr = new Crypter(alg);
        byte[] cryptodata = cr.crypt(data, key, mode);
        if (cryptodata == null) System.out.println("Invalid mode");
        fo.write(cryptodata);


    }
}

