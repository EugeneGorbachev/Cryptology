package console;

/**
 * Created by Eugene on 10/16/2015.
 */
public class Main {
    public static void main (String[] args) {
        CaesarDecoder caesarCipher = new CaesarDecoder(-34, Language.RUS);
        System.out.println(caesarCipher.encrypt("Àààÿÿß"));
        System.out.println(caesarCipher.decrypt(caesarCipher.encrypt("AaazzZ")));

        VigenereDecoder vigenereCipher = new VigenereDecoder("lemon", Language.ENG);
        System.out.println(vigenereCipher.encrypt("attackatdawn"));
        System.out.println(vigenereCipher.decrypt(vigenereCipher.encrypt("attackatdawn")));
    }
}
