package crypto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Crypto  {
    public static void main(String[] args) throws IOException {
        String mode = "";
        String filein = "";
        String fileout = "";
        int key = 0;
        for (int i = 0; i < args.length; i++) {
            switch (args[i])
            {
                case "-mode":
                    if (i+1 < args.length)
                        mode = args[i+1];
                    break;
                case "-key":
                    if (i+1 < args.length)
                        key = Integer.parseInt(args[i+1]);
                    break;
                case "-in":
                    if (i+1 < args.length)
                        filein = args[i+1];
                    break;
                case "-out":
                    if (i+1 < args.length)
                        fileout = args[i+1];
                    break;
            }
        }

        if (mode.isEmpty()||filein.isEmpty()||fileout.isEmpty()||!new File(filein).exists()) return;

        FileInputStream fi = new FileInputStream(filein);
        FileOutputStream fo = new FileOutputStream(fileout);

        while (fi.available() > 0 )
        {
            int data = fi.read();
            fo.write(data+ (mode.equals("enc")?key:mode.equals("dec")?key*-1:0));
        }

    }

    /*private static String encode(String mode, String text, int key)
    {
        String enctext = "";
        for (char c : text.toCharArray()) {
            enctext += (char)((int)c+ (mode.equals("enc")?key:mode.equals("dec")?key*-1:0));
        }
        return enctext;
    }*/


}
