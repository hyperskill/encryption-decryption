package crypto;


import java.io.*;
import java.util.Scanner;

public class Crypto {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int key = 0;
        String mess = "";
        String operation = "enc";
        String fileIn = "";
        String fileOut = "";
        if(args.length == 6) {
            if (args[0].equals("-mode")) {
                operation = args[1];
            }
            if (args[2].equals("-key")) {
                key = Integer.parseInt(args[3]);
            }
            mess = args[args.length - 1];
        }else if(args.length == 8) {
            if (args[0].equals("-mode")) {
                operation = args[1];
            }
            if (args[2].equals("-key")) {
                key = Integer.parseInt(args[3]);
            }
            mess = args[args.length - 1];
            if (args[4].equals("-in")) {
                fileIn = args[5];
            }
            if (args[6].equals("-out")) {
                fileOut = args[7];
            }
            BufferedReader br = null;
            try {
                br = new BufferedReader(new FileReader(new File(fileIn)));
                mess = br.readLine();
                br.close();
            } catch (IOException e) {
                System.out.println("Input file doesn't exist");
                e.printStackTrace();

            }

        }else {
            mess = sc.nextLine();
            key = sc.nextInt();
        }
        StringBuilder sb = new StringBuilder(mess);

        for (int i = 0; i < sb.length(); i++) {
            if(operation.equals("enc")) {
                sb.setCharAt(i, (char) (sb.charAt(i) + key));
            }else{
                sb.setCharAt(i, (char) (sb.charAt(i) - key));
            }
        }
        try(FileWriter fw = new FileWriter(new File(fileOut))) {
            fw.write(sb.toString());
            fw.flush();
        } catch (IOException e) {
            System.out.println("Output file name was not found");
            e.printStackTrace();
        }
        System.out.println(sb);
    }
}
