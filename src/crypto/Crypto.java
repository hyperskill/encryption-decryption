package crypto;

public class Crypto {
    public static void main(String[] args) {
        String mode = "";
        String text = "";
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
                case "-data":
                    if (i+1 < args.length)
                        text = args[i+1];
                    break;
            }
        }

        if (mode.isEmpty()||text.isEmpty()) return;

        System.out.println(encode(mode, text, key));
    }

    private static String encode(String mode, String text, int key)
    {
        String enctext = "";
        for (char c : text.toCharArray()) {
            enctext += (char)((int)c+ (mode.equals("enc")?key:mode.equals("dec")?key*-1:0));
        }
        return enctext;
    }


}
