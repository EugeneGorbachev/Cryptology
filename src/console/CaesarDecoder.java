package console;

/**
 * Created by Eugene on 10/16/2015.
 */
public class CaesarDecoder extends DecoderBehavior {
    private int shift;

    public CaesarDecoder(int shift, Language lang) {
        this.shift = shift;
        this.setLanguage(lang);
    }

    public String encrypt(String string) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            boolean isUpper = Character.isUpperCase(c);// Memorize character case
            c = Character.toLowerCase(c);// Convert to lower case
            int index = alphabet.indexOf(c);
            if (index >= 0) {// If character in alphabet
                //index = (index + this.shift) % alphabet.size();// In case of only positive shift's value use this
                index = Math.abs(index + this.shift % alphabet.size() + alphabet.size()) % alphabet.size();
                if (isUpper) {// If character was in upper case, then convert to upper
                    result.append(Character.toUpperCase(alphabet.get(index)));
                }
                else {// else append in lower case
                    result.append(alphabet.get(index));
                }
            }
            else {// If character not in alphabet
                if (isUpper) {// If character was in upper case, then convert to upper
                    result.append(Character.toUpperCase(c));
                }
                else {// else append in lower case
                    result.append(c);
                }
            }
        }
        return result.toString();
    }

    public String decrypt(String string) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            boolean isUpper = Character.isUpperCase(c);// Memorize character case
            c = Character.toLowerCase(c);// Convert to lower case
            int index = alphabet.indexOf(c);
            if (index >= 0) {// If character in alphabet
                index = Math.abs(index - this.shift % alphabet.size() + alphabet.size()) % alphabet.size();
                if (isUpper) {// If character was in upper case, then convert to upper
                    result.append(Character.toUpperCase(alphabet.get(index)));
                }
                else {// else append in lower case
                    result.append(alphabet.get(index));
                }
            }
            else {// If character not in alphabet
                if (isUpper) {// If character was in upper case, then convert to upper
                    result.append(Character.toUpperCase(c));
                }
                else {// else append in lower case
                    result.append(c);
                }
            }
        }
        return result.toString();
    }

    public int getShift() {
        return shift;
    }

    public void setShift(int shift) {
        this.shift = shift;
    }
}
