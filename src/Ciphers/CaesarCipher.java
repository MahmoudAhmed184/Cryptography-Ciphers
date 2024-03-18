package Ciphers;

public final class CaesarCipher {
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";    
    private static final int ALPHABET_SIZE = ALPHABET.length();

    /**
     * Encrypts the given plaintext using the Caesar cipher.
     *
     * @param plaintext The text to be encrypted.
     * @param key The shift key for the cipher.
     * @return The encrypted text.
     */
    public static String encrypt(String plaintext, int key) {
        return applyCaesarCipher(plaintext, key);
    }

    /**
     * Decrypts the given ciphertext using the Caesar cipher.
     *
     * @param ciphertext The text to be decrypted.
     * @param key The shift key for the cipher.
     * @return The decrypted text.
     */
    public static String decrypt(String ciphertext, int key) {
        return applyCaesarCipher(ciphertext, -key);
    }

    /**
     * Applies the Caesar cipher to the given text.
     *
     * @param text The text to be encrypted or decrypted.
     * @param shift The shift key for the cipher.
     * @return The result of applying the Caesar cipher to the text.
     */
    private static String applyCaesarCipher(String text, int shift) {
        StringBuilder result = new StringBuilder(text.length());
        for (char character : text.toCharArray()) {
            if (Character.isLetter(character)) {
                char shiftedCharacter = shiftCharacter(character, shift);
                result.append(shiftedCharacter);
            }
            else {
                result.append(character);
            }
        }
        return result.toString();
    }

    /**
     * Shifts a character using the Caesar cipher.
     *
     * @param character The character to be shifted.
     * @param shift The shift key for the cipher.
     * @return The shifted character.
     */
    private static char shiftCharacter(char character, int shift) {
        int index = ALPHABET.indexOf(Character.toLowerCase(character));
        int shiftedIndex = Math.floorMod(index + shift, ALPHABET_SIZE);
        char shiftedCharacter = ALPHABET.charAt(shiftedIndex);
        return Character.isUpperCase(character) ? Character.toUpperCase(shiftedCharacter) : shiftedCharacter;
    }
}
