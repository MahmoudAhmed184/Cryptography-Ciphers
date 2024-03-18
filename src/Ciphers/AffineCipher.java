package Ciphers;

public class AffineCipher {
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private static final int ALPHABET_SIZE = ALPHABET.length();

    /**
     * Encrypts the given plaintext using the Affine cipher.
     *
     * @param plaintext The text to be encrypted.
     * @param alpha The multiplicative key for the cipher.
     * @param beta The additive key for the cipher.
     * @return The encrypted text.
     */
    public static String encrypt(String plaintext, int alpha, int beta) {
        return applyAffineCipher(plaintext, alpha, beta);
    }

    /**
     * Decrypts the given ciphertext using the Affine cipher.
     *
     * @param ciphertext The text to be decrypted.
     * @param alpha The multiplicative key for the cipher.
     * @param beta The additive key for the cipher.
     * @return The decrypted text.
     * @throws IllegalArgumentException if 'alpha' is not coprime with the size of the alphabet.
     */
    public static String decrypt(String ciphertext, int alpha, int beta) {
        int modInverse = findModInverse(alpha);
        if (modInverse == -1) {
            throw new IllegalArgumentException("The alpha value must be coprime with the alphabet size.");
        }
        beta = -beta * modInverse;
        return applyAffineCipher(ciphertext, modInverse, beta);
    }

    /**
     * Applies the Affine cipher to the given text.
     *
     * @param text The text to be encrypted or decrypted.
     * @param alpha The multiplicative key for the cipher.
     * @param beta The additive key for the cipher.
     * @return The result of applying the Affine cipher to the text.
     */
    private static String applyAffineCipher(String text, int alpha, int beta) {
        StringBuilder result = new StringBuilder(text.length());
        for (char character : text.toCharArray()) {
            if (Character.isLetter(character)) {
                char shiftedCharacter = shiftCharacter(character, alpha, beta);
                result.append(shiftedCharacter);
            } else {
                result.append(character);
            }
        }
        return result.toString();
    }

    /**
     * Shifts a character using the Affine cipher.
     *
     * @param character The character to be shifted.
     * @param alpha The multiplicative key for the cipher.
     * @param beta The additive key for the cipher.
     * @return The shifted character.
     */
    private static char shiftCharacter(char character, int alpha, int beta) {
        int index = ALPHABET.indexOf(Character.toLowerCase(character));
        int shiftedIndex = Math.floorMod((alpha * index + beta), ALPHABET_SIZE);
        char shiftedCharacter = ALPHABET.charAt(shiftedIndex);
        return Character.isUpperCase(character) ? Character.toUpperCase(shiftedCharacter) : shiftedCharacter;
    }

    /**
     * Finds the modular multiplicative inverse of a given number under modulo ALPHABET_SIZE.
     * The modular multiplicative inverse of 'alpha' under modulo ALPHABET_SIZE is a number 'x' such that
     * the product 'alpha' * 'x' is congruent to 1 modulo ALPHABET_SIZE.
     *
     * @param alpha The number to find the modular multiplicative inverse of.
     * @return The modular multiplicative inverse of 'alpha' under modulo ALPHABET_SIZE, or -1 if it does not exist.
     */
    private static int findModInverse(int alpha) {
        for (int possibleInverse = 0; possibleInverse < ALPHABET_SIZE; ++possibleInverse) {
            if ((alpha * possibleInverse) % ALPHABET_SIZE == 1) {
                return possibleInverse;
            }
        }
        return -1;
    }
}
