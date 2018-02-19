public class Palindrome {

    public static boolean isPalindromeIterative(String word) {
        if (word.equals("") || word.length() < 2)
            return true;

        char[] letters = word.toCharArray();
        int left = 0;
        int right = letters.length - 1;

        while (left < right) {
            char temp = letters[left];
            letters[left] = letters[right];
            letters[right] = temp;
            left++;
            right--;
        }

        return word.equals(new String(letters));
    }

    public static boolean isPalindromeRecursive(String word) {
        if (word.equals("") || word.length() < 2)
            return true;

        String reversed = reverse(word);
        return word.equals(reversed);
    }

    private static String reverse(String word) {
        if (word.length() < 2)
            return word;

        return reverse(word.substring(1)) + word.charAt(0);
    }
}
