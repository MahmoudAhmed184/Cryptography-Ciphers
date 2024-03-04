package Ciphers;

public final class CaesarCipher {
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";    
    private static final int ALPHABET_SIZE = ALPHABET.length();

    public static String encrypt(String plaintext, int key) {
        return applyCaesarCipher(plaintext, key, true);
    }

    public static String decrypt(String ciphertext, int key) {
        return applyCaesarCipher(ciphertext, key, false);
    }

    private static String applyCaesarCipher(String text, int key, boolean isEncryption){
        int shift = isEncryption ? key : -key;
        
        var result = new StringBuilder(text.length());
        
        for (char character : text.toCharArray()){
            if (!Character.isLetter(character)){
                result.append(character);
            }
            else {
                char shiftedCharacter = shiftCharacter(character, shift);

                result.append(shiftedCharacter);
            }
        }
        return result.toString();
    }

    private static char shiftCharacter(char character, int shift) {
        int index = ALPHABET.indexOf(Character.toLowerCase(character));
        
        int shiftedIndex = Math.floorMod(index + shift, ALPHABET_SIZE);
        
        char shiftedCharacter = ALPHABET.charAt(shiftedIndex);
        return Character.isUpperCase(character) ? Character.toUpperCase(shiftedCharacter) : shiftedCharacter;
    }
}