# Cryptography Ciphers

## Introduction
- This repository is dedicated to the implementation of various cryptographic ciphers in Java. The first class we have implemented is the `CaesarCipher` class in the `Ciphers` package. This class provides methods to encrypt and decrypt text using the Caesar Cipher algorithm.

## Getting Started
- This code has been developed using Visual Studio Code. Welcome to the realm of Java in Visual Studio Code! Here’s a roadmap to assist you in embarking on your journey of writing Java code in Visual Studio Code. 
- If you're new to Java or Visual Studio Code, here's a guide to help you get started on your coding journey:

    ### Folder Structure
    - The workspace contains two folders by default, where:
        - `src`: the folder to maintain sources
        - `lib`: the folder to maintain dependencies

    - Meanwhile, the compiled output files will be generated in the `bin` folder by default. If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

    ### Dependency Management
    - The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).

## Installation
- To clone and set up the development environment for this repository, follow these steps:

1. Clone the repository: `git clone https://github.com/MahmoudAhmed184/Cryptography-Ciphers.git`
2. Open the project in your preferred Java IDE.
3. Ensure that your IDE is set up with the correct JDK version (JDK 8 or above is recommended).

## Usage
The `CaesarCipher` class in the `Ciphers` package can be used to encrypt and decrypt text using the Caesar Cipher algorithm. Here's an example of how to use it:

```java
import Ciphers.CaesarCipher;

public class Main {
    public static void main(String[] args) {
        String encryptedText = CaesarCipher.encrypt("Hello, World!", 5);
        System.out.println("Encrypted Text: " + encryptedText);
        System.out.println("Decrypted Text: " + CaesarCipher.decrypt(encryptedText, 5));
    }
}
```
## Contributing
- Contributions are welcome! Please feel free to submit a pull request or open an issue if you find a bug or have a feature request.