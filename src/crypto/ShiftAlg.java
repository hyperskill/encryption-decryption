package encryptdecrypt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class ShiftAlg implements Cipher {
    private String abc = "abcdefghijklmnopqrstuvwxyz";

    @Override
    public void encrypt(DataProcess dataProcess) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < dataProcess.getData().length(); i++) {
            if (Character.isLetter(dataProcess.getData().charAt(i))) {
                int num = abc.indexOf(dataProcess.getData().charAt(i)) + dataProcess.getKey();
                result.append(abc.charAt(num > abc.length() - 1 ? num - abc.length() : num));
            } else {
                result.append(dataProcess.getData().charAt(i));
            }
        }
        if (!dataProcess.getDataOutFile().isEmpty()) {
            try {
                FileWriter fw = new FileWriter(new File(dataProcess.getDataOutFile()));
                fw.write(result.toString());
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(result);
        }
    }

    @Override
    public void decrypt(DataProcess dataProcess) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < dataProcess.getData().length(); i++) {
            if (Character.isLetter(dataProcess.getData().charAt(i))) {
                int num = abc.indexOf(dataProcess.getData().charAt(i)) - dataProcess.getKey();
                result.append(abc.charAt(num < 0 ? num + abc.length() : num));
            } else {
                result.append(dataProcess.getData().charAt(i));
            }
        }
        if (!dataProcess.getDataOutFile().isEmpty()) {
            try {
                FileWriter fw = new FileWriter(new File(dataProcess.getDataOutFile()));
                fw.write(result.toString());
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(result);
        }
    }
}
