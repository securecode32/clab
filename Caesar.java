import java.util.Scanner;

public class Caesar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a word: ");
        String word = sc.nextLine();
        System.out.println("Enter the key: ");
        int k = sc.nextInt();
        System.out.println("Original Word: " + word);

        char[] cipher = new char[word.length()];
        System.out.println("Plain Text: " + word);

        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (Character.isAlphabetic(currentChar)) {
                int currentIndex = currentChar - 'A';
                int shiftedIndex = (currentIndex + k) % 26;
                cipher[i] = (char) ('A' + shiftedIndex);
            } else {
                cipher[i] = currentChar;
            }
        }
        String cipheredWord = new String(cipher);
        System.out.println("Ciphered Text: " + cipheredWord);
    }
}