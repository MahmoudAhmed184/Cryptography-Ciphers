import Ciphers.CaesarCipher;

public class Main {
    public static void main(String[] args) {
        String encryptedText = CaesarCipher.encrypt("Mahmoud Ahmed", 5);
        System.out.println("EncryptedText: " + encryptedText);
        System.out.println(CaesarCipher.decrypt(encryptedText, 5));
    }
}