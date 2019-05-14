package encryptdecrypt;

import java.io.File;
import java.io.FileWriter;

class UnicodeAlg implements Cipher{

    @Override
    public void encrypt(DataProcess dataProcess) {
        int[] numChars = new int[dataProcess.getData().length()];
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numChars.length; i++) {
            numChars[i] = Character.codePointAt(dataProcess.getData(), i);
            result.append((char) (numChars[i] + dataProcess.getKey()));
        }
        if (dataProcess.getDataOutFile() != null) {
            try {
                FileWriter fw = new FileWriter(new File(dataProcess.getDataOutFile()));
                fw.write(result.toString());
                fw.close();
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(result);
        }
    }

    @Override
    public void decrypt(DataProcess dataProcess) {
        int[] numChars = new int[dataProcess.getData().length()];
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numChars.length; i++) {
            numChars[i] = Character.codePointAt(dataProcess.getData(), i);
            result.append((char) (numChars[i] - dataProcess.getKey()));
        }
        if (dataProcess.getDataOutFile() != null) {
            try {
                FileWriter fw = new FileWriter(new File(dataProcess.getDataOutFile()));
                fw.write(result.toString());
                fw.close();
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(result);
        }
    }
}
