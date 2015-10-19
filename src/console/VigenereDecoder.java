package console;

/**
 * Created by Eugene on 10/16/2015.
 */
public class VigenereDecoder extends DecoderBehavior {
    private String key;

    public VigenereDecoder(String key, Language lang) {
        this.key = key;
        this.setLanguage(lang);
    }

    public String encrypt(String string) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            char stringChar = Character.toLowerCase(string.charAt(i)), keyChar = Character.toLowerCase(key.charAt(i % key.length()));
            int index, stringCharIndex = alphabet.indexOf(stringChar), keyCharIndex = alphabet.indexOf(keyChar);
            if (stringCharIndex >= 0 && keyCharIndex >= 0) {
                index = (stringCharIndex + keyCharIndex) % alphabet.size();
                result.append(Character.toUpperCase(alphabet.get(index)));
            }
            else {
                result.append(Character.toUpperCase(stringChar));
            }
        }
        return result.toString();
    }

    public String decrypt(String string) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            char stringChar = Character.toLowerCase(string.charAt(i)), keyChar = Character.toLowerCase(key.charAt(i % key.length()));
            int index, stringCharIndex = alphabet.indexOf(stringChar), keyCharIndex = alphabet.indexOf(keyChar);
            if (stringCharIndex >= 0 && keyCharIndex >= 0) {
                index = (stringCharIndex - keyCharIndex + alphabet.size()) % alphabet.size();
                result.append(Character.toUpperCase(alphabet.get(index)));
            }
            else {
                result.append(Character.toUpperCase(stringChar));
            }
        }
        return result.toString();
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
