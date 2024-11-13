import java.util.Scanner;

public class SpoonerismGenerator {

    public static void main(String[] args) {
        run();
    }

    public static String getWord(int num) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter word " + num + ": ");
        String word = scanner.nextLine();
        return word;
    }

    public static boolean vowelIndex(String word, int[] index) {
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U' || 
                ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                index[0] = i;
                return true;
            }
        }
        return false;
    }

    public static void run() {
        String word1 = getWord(1);
        String word2 = getWord(2);

        int[] index1 = new int[1];
        int[] index2 = new int[1];

        boolean hasVowel1 = vowelIndex(word1, index1);
        boolean hasVowel2 = vowelIndex(word2, index2);

        if (!hasVowel1 || !hasVowel2 || index1[0] == 0 || index2[0] == 0) {
            System.out.println(word1 + " and " + word2 + " are not good words to spoonerize.");
        } else {
            String newWord1 = word2.substring(0, index2[0]) + word1.substring(index1[0]);
            String newWord2 = word1.substring(0, index1[0]) + word2.substring(index2[0]);
            System.out.println(word1 + " and " + word2 + " spoonerized are " + newWord1 + " " + newWord2);
        }
    }
}
