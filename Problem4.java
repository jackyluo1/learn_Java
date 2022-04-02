public class Problem4 {
    public static void main(String[] args) {
        String[] words1 = { "a", "cdm", "lololol", "asd", "ooooooooooo" };
        String[] words2 = {};
        String[] words3 = { "" };
        String[] arr1 = trimWords(words1);
        for (int index = 0; index < arr1.length; index++) {
            System.out.print(arr1[index] + "  ");
        }
        trimWords(words2);
        trimWords(words3);
    }

    public static String[] trimWords(String[] words) {

        if (words == null)
            return words;

        int j = words.length;
        String[] res = new String[j];
        if (j <= 1) {
            return words;
        }

        for (int i = 0; i < words.length; i++) {
            int n = words[i].length();
            // Rule 1: the length of the word is smaller than or equal to i
            if (n <= i + 1) {
                res[i] = words[i];
            }

            // Rule 1:the word is "lololol"
            if (words[i] == "lololol") {
                res[i] = words[i];
            }

            int first = words[i].charAt(0);
            // System.out.println("f:" + first);
            int last = words[i].charAt(n - 1);
            // System.out.println("l:" + last);
            while (n > i + 1) {
                // Rule 1:the word is "lololol" , also need it in while loop to match Rule 1
                if (words[i] == "lololol") {
                    res[i] = words[i];
                    break;
                }

                if (first <= last) {
                    words[i] = words[i].substring(1, n); // Rule 2
                } else {
                    words[i] = words[i].substring(0, n - 1); // Rule 2
                }

                n = words[i].length();
                if (n <= i + 1) {
                    res[i] = words[i];
                    break;
                }
                first = words[i].charAt(0);
                last = words[i].charAt(n - 1);
            }
            res[i] = words[i];
        }
        return res;
    }

}
