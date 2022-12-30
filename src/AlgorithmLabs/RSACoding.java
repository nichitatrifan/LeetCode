package AlgorithmLabs;

import java.util.Hashtable;
import java.util.StringTokenizer;


/*
*
*
* Nichita Trifan
* ID: 1027421
* Subject: RSA Algorithm
*
* */

public class RSACoding {

    static int p, q, n, phi, d;
    static int publicKey;
    static String msg = "";

    public static int x;
    public static int y;

    static Hashtable<String,Integer> symbolTable = new Hashtable<String,Integer>();
    static Hashtable<Integer,String> symbolReverseTable = new Hashtable<Integer,String>();

    public static int GCD(int n, int m) {
        if (m==0) {
            return n;
        }
        else {
            return GCD(m, n % m);
        }
    }

    public static int findPrivateKey(int iterations) {

        int d = 1;
        for (int i = 0; i <= iterations;){
            d++;
            if ( GCD(d, phi) == 1 ){
                i++;
            }
        }

        return d;
    }

    public static int euclideanExtended(int a, int b) {
        if (a == 0) {
            x = 0;
            y = 1;
            return b;
        }

        int gcd = euclideanExtended(b % a, a);
        int x1 = x;
        int y1 = y;

        int tmp = b / a;
        x = y1 - tmp * x1;
        y = x1;

        return gcd;
    }

    public static int[] public_key_finder() {
        euclideanExtended(d, phi); // find public key by using extended euclidean algorithm

        return new int[]{x,y};
    }

    public static int modular_power(int base, int exp, int mod) {
        if (base == 0) return 0;
        if (exp == 0) return 1;
        long y;

        if (exp % 2 == 0) {
            y = modular_power(base, exp / 2, mod);
            y = (y * y) % mod;

        } else {
            y = base % mod;
            y = (y * modular_power(base, exp - 1, mod) % mod) % mod;
        }

        return (int) ((y + mod) % mod);
    }

    public static void initTables() {
        symbolTable.put("A",10); symbolTable.put("B",11); symbolTable.put("C",12); symbolTable.put("D",13);
        symbolTable.put("E",14); symbolTable.put("F",15); symbolTable.put("G",16); symbolTable.put("H",17);
        symbolTable.put("I",18); symbolTable.put("J",19); symbolTable.put("K",20); symbolTable.put("L",21);
        symbolTable.put("M",22); symbolTable.put("N",23); symbolTable.put("O",24); symbolTable.put("P",25);
        symbolTable.put("Q",26); symbolTable.put("R",27); symbolTable.put("S",28); symbolTable.put("T",29);
        symbolTable.put("U",30); symbolTable.put("V",31); symbolTable.put("W",32); symbolTable.put("X",33);
        symbolTable.put("Y",34); symbolTable.put("Z",35); symbolTable.put(" ",36); symbolTable.put(",",37);
        symbolTable.put(".",38); symbolTable.put("?",39); symbolTable.put("!",40);

        symbolReverseTable.put(10,"A"); symbolReverseTable.put(11,"B"); symbolReverseTable.put(12,"C"); symbolReverseTable.put(13,"D");
        symbolReverseTable.put(14,"E"); symbolReverseTable.put(15,"F"); symbolReverseTable.put(16,"G"); symbolReverseTable.put(17,"H");
        symbolReverseTable.put(18,"I"); symbolReverseTable.put(19,"J"); symbolReverseTable.put(20,"K"); symbolReverseTable.put(21,"L");
        symbolReverseTable.put(22,"M"); symbolReverseTable.put(23,"N"); symbolReverseTable.put(24,"O"); symbolReverseTable.put(25,"P");
        symbolReverseTable.put(26,"Q"); symbolReverseTable.put(27,"R"); symbolReverseTable.put(28,"S"); symbolReverseTable.put(29,"T");
        symbolReverseTable.put(30,"U"); symbolReverseTable.put(31,"V"); symbolReverseTable.put(32,"W"); symbolReverseTable.put(33,"X");
        symbolReverseTable.put(34,"Y"); symbolReverseTable.put(35,"Z"); symbolReverseTable.put(36," "); symbolReverseTable.put(37,",");
        symbolReverseTable.put(38,"."); symbolReverseTable.put(39,"?"); symbolReverseTable.put(40,"!");
    }

    public static String msgToCode() {

        String returnMsg = "";

        for (int i = 0; i<msg.length(); i++){
            if (i % 2 == 0 && i != 0){
                returnMsg += " ";
            }
            returnMsg += symbolTable.get(String.valueOf(msg.charAt(i)));

        }

        return returnMsg;
    }

    public static void main(String arg[]){
        initTables();
        msg = "I AM FINE! WHAT ABOUT YOU??";

        // p = 9829;
        // q = 9839;

        p = 9967;
        q = 9973;
        n = p*q;
        phi = (p-1)*(q-1); // finding totient

        d = findPrivateKey(52); // find a 'd' so that it is co-prime to 'phi' ( gcd(d,phi) = 1 )
        // you can hard code any other value by yourself if you want to
        // the function finds a private key depending on the number of iterations it makes

        int[] ijArr = public_key_finder();
        publicKey = (ijArr[0] % phi + phi) % phi;

        System.out.println("p: " + p + "\tq: " + q + "\tprivate key: " + d + "\tpublic key: " + publicKey);
        System.out.println("\nGiven text:\n" + msg);

        String msgCode = msgToCode(); // converted message's chars to int codes
        System.out.println("\nDigital message grouping two characters together:\n" + msgCode);

        // encrypting message by using the public key and 'n' value
        String encryptedMessage = "";
        StringTokenizer tokenizer = new StringTokenizer(msgCode);
        while ( tokenizer.hasMoreTokens() ) {
            encryptedMessage += modular_power(Integer.parseInt( tokenizer.nextToken() ), publicKey, n);
            encryptedMessage += " ";
        }
        System.out.println("\nEncryption for the grouped digits:\n" + encryptedMessage);


        // decrypting the message by using 'd' and 'n' values
        tokenizer = new StringTokenizer(encryptedMessage);
        String decryptedMsg = "";
        while ( tokenizer.hasMoreTokens() ) {
            decryptedMsg += modular_power(Integer.parseInt( tokenizer.nextToken() ), d, n);
            decryptedMsg += " ";
        }
        System.out.println("\nDecryption for the above number groups:\n" + decryptedMsg);

        // converting the message from code to chars back
        tokenizer = new StringTokenizer(decryptedMsg);
        String firstChar, secondChar,
                nextToken, codeToMsg = "";
        while (tokenizer.hasMoreTokens()){
            firstChar = "";
            secondChar = "";
            nextToken = tokenizer.nextToken();

            for (int i = 0; i < 2; i++) {
                firstChar += String.valueOf( nextToken.charAt(i) );
            }
            codeToMsg += symbolReverseTable.get(Integer.parseInt(firstChar));

            if (nextToken.length() > 2) {
                for (int i = 2; i < 4; i++) {
                    secondChar += String.valueOf( nextToken.charAt(i) );
                }
                codeToMsg += symbolReverseTable.get(Integer.parseInt(secondChar));
            }
        }

        System.out.println("\nMessage (original text):\n" + codeToMsg);


    } // main

}
