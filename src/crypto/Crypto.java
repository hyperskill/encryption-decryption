package crypto;

import java.util.Scanner;

public class Crypto {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
	// write your code here
	String mode = "enc";
        String data = "";
        int key = 0;
        String input = "";
        String output = "";
        String typeOfAlgorithm = "";
        Algorithm algorithm;
        boolean inputToFile = false;
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-mode":
                    mode = args[++i];
                    break;
                case "-key":
                    key = Integer.parseInt(args[++i]);
                    break;
                case "-data":
                    data = args[++i];
                    break;
                case "-in":
                    input = args[++i];
                    inputToFile = true;
                    break;
                case "-out":
                    output = args[++i];
                    break;
                case "-alg":
                    typeOfAlgorithm = args[++i];
                    break;
            }
        }

        if (inputToFile) {
            try {
                data = FileOperations.readData(input);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        if (mode.equals("enc")) {
            algorithm = new ConcreteEncryption();
            data = algorithm.implementAlgorithm(data,typeOfAlgorithm, key);
        } else if (mode.equals("dec")) {
            algorithm = new ConcreteDecryption();
            data = algorithm.implementAlgorithm(data,typeOfAlgorithm, key);
        }

        if (output.isBlank()) {
            System.out.println(data);
        } else {
            FileOperations.printData(output, data);
        }
    }
}
