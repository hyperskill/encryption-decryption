package encryptdecrypt;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

class DataProcess {
    private String algorithm;
    private String operation = "enc";
    private String dataOutFile = null;
    private String data = "";
    private int key = 0;

    String getAlgorithm() {
        return algorithm;
    }

    String getOperation() {
        return operation;
    }

    String getDataOutFile() {
        return dataOutFile;
    }

    String getData() {
        return data;
    }

    int getKey() {
        return key;
    }

    DataProcess(String[] args) {
        boolean checker = false;
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-mode": {
                    this.operation = args[++i];
                    break;
                }
                case "-key": {
                    this.key = Integer.parseInt(args[++i]);
                    break;
                }
                case "-data": {
                    this.data = args[++i];
                    checker = true;
                    break;
                }
                case "-in": {
                    this.data = DataProcess.dataFromFile(args[++i]);
                    checker = true;
                    break;
                }
                case "-out": {
                    this.dataOutFile = args[++i];
                    break;
                }
                case "-alg": {
                    this.algorithm = args[++i];
                    break;
                }
            }
        }
        if (!checker) {
            Scanner sc = new Scanner(System.in);
            this.data = sc.nextLine();
            this.key = sc.nextInt();
            sc.close();
        }
    }

    private static String dataFromFile(String dataInFile) {
        StringBuilder str = new StringBuilder();
        try {
            FileReader in = new FileReader(dataInFile);
            Scanner scanner = new Scanner(in);
            while (scanner.hasNext()) {
                str.append(scanner.nextLine()).append("\n");
            }
        } catch (FileNotFoundException e) {
            System.out.println("There is no file with such a name: " + dataInFile);
        }
        return str.toString();
    }
}
