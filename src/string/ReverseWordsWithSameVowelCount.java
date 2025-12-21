package string;

// TODO: Resolve Fenwick tree
public class ReverseWordsWithSameVowelCount {

    public static void main(String[] args) {
        String rev = reverseWords("cat and mice");
        System.out.println(rev);
    }

    static public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder builder = new StringBuilder(s.length());

        int target = vowelCount(words[0]);

        builder.append(words[0]);

        for (int i = 1; i < words.length; i++) {
            builder.append(' ');
            if (vowelCount(words[i]) == target) {
                words[i] = reverse(words[i]);
            }
            builder.append(words[i]);
        }

        return builder.toString();
    }

    static private String reverse(String word) {
        StringBuilder r = new StringBuilder(word.length());
        for (int i = word.length() - 1; i >= 0; i--) {
            r.append(word.charAt(i));
        }
        return r.toString();
    }

    static private int vowelCount(String word) {
        int count = 0;

        for (char c : word.toCharArray()) {
            switch (c) {
                case 'a', 'e', 'i', 'o', 'u':
                    count++;
            }

        }

        return count;
    }
}
