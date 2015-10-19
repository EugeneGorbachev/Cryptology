package console;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eugene on 10/19/2015.
 */
public abstract class DecoderBehavior implements Cipher {
    List<Character> alphabet = new ArrayList<Character>();
    Language language;

    public abstract String encrypt(String string);

    public abstract String decrypt(String string);

    public List<Character> getAlphabet() {
        return alphabet;
    }

    public void setAlphabet(List<Character> alphabet) {
        this.alphabet = alphabet;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        alphabet.clear();
        switch (language) {
            case ENG:
                for (char c = 'a'; c <= 'z'; c++) {
                    alphabet.add(c);
                }
                break;
            case RUS:
                for (char c = 'à'; c <= 'å'; c++) {
                    alphabet.add(c);
                }
                alphabet.add('¸');
                for (char c = 'æ'; c <= 'ù'; c++) {
                    alphabet.add(c);
                }
                alphabet.add('ú');
                for (char c = 'û'; c <= 'ÿ'; c++) {
                    alphabet.add(c);
                }
                break;
        }
        this.language = language;
    }
}
