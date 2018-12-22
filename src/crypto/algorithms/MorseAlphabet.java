package crypto.algorithms;

public enum MorseAlphabet {
//    static MorseAlphabet va
    A {
        @Override
        public String toString() {
            return ".-";
        }
    },
    B {
        @Override
        public String toString() {
            return "-...";
        }
    },
    C {
        @Override
        public String toString() {
            return "-.-.";
        }
    },
    D {
        @Override
        public String toString() {
            return "−..";
        }
    },
    E {
        @Override
        public String toString() {
            return ".";
        }
    },
    F {
        @Override
        public String toString() {
            return "..-.";
        }
    },
    G {
        @Override
        public String toString() {
            return "--.";
        }
    },
    H {
        @Override
        public String toString() {
            return "....";
        }
    },
    I {
        @Override
        public String toString() {
            return "..";
        }
    },
    J {
        @Override
        public String toString() {
            return ".---";
        }
    },
    K {
        @Override
        public String toString() {
            return "-.-";
        }
    },
    L {
        @Override
        public String toString() {
            return ".-..";
        }
    },
    M {
        @Override
        public String toString() {
            return "--";
        }
    },
    N {
        @Override
        public String toString() {
            return "-.";
        }
    },
    O {
        @Override
        public String toString() {
            return "---";
        }
    },
    P {
        @Override
        public String toString() {
            return ".--.";
        }
    },
    Q {
        @Override
        public String toString() {
            return "--.-";
        }
    },
    R {
        @Override
        public String toString() {
            return ".-.";
        }
    },
    S {
        @Override
        public String toString() {
            return "...";
        }
    },
    T {
        @Override
        public String toString() {
            return "-";
        }
    },
    U {
        @Override
        public String toString() {
            return "..-";
        }
    },
    V {
        @Override
        public String toString() {
            return "...-";
        }
    },
    W {
        @Override
        public String toString() {
            return ".--";
        }
    },
    X {
        @Override
        public String toString() {
            return "-..-";
        }
    },
    Y {
        @Override
        public String toString() {
            return "-.--";
        }
    },
    Z {
        @Override
        public String toString() {
            return "--..";
        }
    },
    NUMBER{
        public String toString(String num) {
            return new String[]{
                    "−−−−−",
                    ".−−−−",
                    "..---",
                    "...--",
                    "....-",
                    ".....",
                    "-....",
                    "--...",
                    "---..",
                    "----.",
                    "-----",
            }[Integer.parseInt(num)];
        }
    },
    PUNCTUATION{
        public String toString(String punct) {
            switch (punct){
                case ".": return ".-.-.-";
                case ",": return "--..--";
                case "?": return "..--..";
                case "!": return "-.-.--";
                default: return "";
            }
        }
    };
    String toString(String num){
        return toString();
    }
    static String getValue(String code){
        MorseAlphabet[] alphabet = MorseAlphabet.values();
        for(int i=0; i < alphabet.length; i++){
            if(alphabet[i] == MorseAlphabet.NUMBER){
                for(int j = 0; j < 10; j++){
                    if(MorseAlphabet.NUMBER.toString(Integer.toString(j)).equals(code)){
                        return Integer.toString(j);
                    }
                }
            } else if(alphabet[i] == MorseAlphabet.PUNCTUATION) {
                    switch (code){
                        case ".-.-.-": return ".";
                        case "--..--": return ",";
                        case "..--..": return "?";
                        case "-.-.--": return "!";
                        default: return "";
                    }

            }else if(alphabet[i].toString().equals(code)){
                return alphabet[i].name();
            }
        }
        return null;
    }
}
