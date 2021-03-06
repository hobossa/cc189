package CH01_ArraysAndStrings;

// Write a method to replace all spaces in a string with '%20'. You may assume that the string
// has sufficient space at the end to hold the additional characters, and that you are given the "true"
// length of the string.
// (Note: If implementing in Java, please use a character array so that you can perform this operation
// in place.)
// EXAMPLE
// Input:     "Mr John Smith     ", 13
// Output:    "Mr%20John%20Smith"
// Hints: #53, #118

public class URLify {

    // time O(N), space O(N)
    public static void URLify_v1(char[] url, int len) {
        // do it from end to start, so that we can do it in place
        int nSpace = 0;
        for (int i = 0; i < len; i++) {
            if (url[i] == ' ') {
                nSpace++;
            }
        }
        int lenAfter = len + 2 * nSpace;
        if (lenAfter < url.length ) {
            url[lenAfter] = '\0';
        }
        lenAfter--;
        for (int i = len-1; i >=0 ; i--) {
            if (url[i] == ' ') {
                url[lenAfter--] = '0';
                url[lenAfter--] = '2';
                url[lenAfter--] = '%';
            } else {
                url[lenAfter--] = url[i];
            }
        }
    }

    // solutions from book
    // Assume string has sufficient free space at the end
    public static void URLify_s1(char[] str, int trueLength) {
        int spaceCount = 0, index, i = 0;
        for (i = 0; i < trueLength; i++) {
            if (str[i] == ' ') {
                spaceCount++;
            }
        }
        index = trueLength + spaceCount * 2;
        if (trueLength < str.length) str[trueLength] = '\0';
        for (i = trueLength - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';
                index = index - 3;
            } else {
                str[index - 1] = str[i];
                index--;
            }
        }
    }

    public static int findLastCharacter(char[] str) {
        for (int i = str.length - 1; i >= 0; i--) {
            if (str[i] != ' ') {
                return i;
            }
        }
        return -1;
    }

    public static String charArrayToString(char[] arr) {
        StringBuilder strBuilder = new StringBuilder();
        for (char c: arr) {
            if (c == '\0') {
                break;
            }
            strBuilder.append(c);
        }
        return strBuilder.toString();
    }

    public static void main(String[] args) {
        String url = "MR John Smith            ";
        char[] arr = url.toCharArray();
        URLify_v1(arr, 13);
        // int trueLength = findLastCharacter(arr) + 1;
        // URLify_s1(arr, trueLength);
        System.out.println(charArrayToString(arr));
    }
}
