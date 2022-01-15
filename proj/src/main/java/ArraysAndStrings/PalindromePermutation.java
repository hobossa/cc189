package ArraysAndStrings;

// Given a string, write a function to check if it is a permutation of a palindrome.
// A palindrome is a word or phrase that is the same forwards and backwards. A Permutation
// is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.
// EXAMPLE
// Input:       Taco Coa
// Output:      True (permutations: "taco cat", "atco cta", etc.)
// Hints: #106, #121, #134, #136

public class PalindromePermutation {
    static class PartialPPInfo {
        boolean isPartialPP;
        String strRemain;
    }

    // start of version 1
    // assume the String only contains 26 characters and ' '(space)
    // time O(N), space O(N)
    // issue:
    // I misunderstand what a permutation of a palindrome is.
    // I thought we can only do permutation in each word not the whole string.
    // My way is similar to the solution 2, whatever, leave the wrong code here to remind myself
    // that getting the question crystal clear first is important.
    public static boolean isPermutationOfPalindrome_v1(String str) {
        String[] words = str.split(" ");
        int i = 0;
        int j = words.length - 1;
        boolean startLonger = true;
        String remain = "";
        String wordStart, wordEnd;

        while (i <= j) {
            if (startLonger) {
                wordStart = remain;
                wordEnd = words[j];
                j--;
            } else {
                wordStart = words[i];
                wordEnd = remain;
                i++;
            }
            startLonger = wordStart.length() > wordEnd.length();
            PartialPPInfo info = startLonger ? is2WordsPartialPP(wordStart, wordEnd) : is2WordsPartialPP(wordEnd, wordStart);
            if (!info.isPartialPP) {
                return false;
            }
            remain = info.strRemain;
        }
            return isWordPP(remain);
    }

    public static int charIndex(char c) {
        if (Character.isUpperCase(c)) {
            c = Character.toLowerCase(c);
        }
        int index = c - 'a';
        if (index < 0 || index > 25) {
            index = -1;
        }
        return index;
    }

    // check is this word a PalindromePermutation
    public static boolean isWordPP(String word) {
        int[] charCount = new int[26];
        for (int i = 0; i < word.length(); i++) {
            int index = charIndex(word.charAt(i));
            if (index != -1) {
                charCount[index]++;
            }
        }
        int countOdd = 0;
        for (int count : charCount) {
            if (count % 2 != 0) {
                countOdd++;
            }
        }
        // At most one count is odd.
        return countOdd < 2;
    }

    public static PartialPPInfo is2WordsPartialPP(String wordA, String wordB) {
        assert (wordA.length() >= wordB.length());
        PartialPPInfo info = new PartialPPInfo();
        int[] charCount = new int[26];
        for (int i = 0; i < wordA.length(); i++) {
            int index = charIndex(wordA.charAt(i));
            if (index != -1) {
                charCount[index]++;
            }
        }
        info.isPartialPP = true;
        for (int i = 0; i < wordB.length(); i++) {
            int index = charIndex(wordB.charAt(i));
            if (index != -1) {
                charCount[index]--;
                if (charCount[index] < 0) {
                    info.isPartialPP = false;
                }
            }
        }
        if (info.isPartialPP) {
            StringBuilder strBuilder = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                int count = charCount[i];
                while (count-- > 0) {
                    strBuilder.append((char) ('a' + i));
                }
            }
            info.strRemain = strBuilder.toString();
        }
        return info;
    }
    // end of version 1

    // solutions from book
    public static class Common {

        public static int getCharNumber(Character c) {
            int a = Character.getNumericValue('a');
            int z = Character.getNumericValue('z');

            int val = Character.getNumericValue(c);
            if (a <= val && val <= z) {
                return val - a;
            }
            return -1;
        }

        public static int[] buildCharFrequencyTable(String phrase) {
            int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
            for (char c : phrase.toCharArray()) {
                int x = getCharNumber(c);
                if (x != -1) {
                    table[x]++;
                }
            }
            return table;
        }

    }

    // solution 1
    public static boolean checkMaxOneOdd(int[] table) {
        boolean foundOdd = false;
        for (int count : table) {
            if (count % 2 == 1) {
                if (foundOdd) {
                    return false;
                }
                foundOdd = true;
            }
        }
        return true;
    }

    public static boolean isPermutationOfPalindrome_s1(String phrase) {
        int[] table = Common.buildCharFrequencyTable(phrase);
        return checkMaxOneOdd(table);
    }

    // solution 2
    public static boolean isPermutationOfPalindrome_s2(String phrase) {
        int countOdd = 0;
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        for (char c : phrase.toCharArray()) {
            int x = Common.getCharNumber(c);
            if (x != -1) {
                table[x]++;

                if (table[x] % 2 == 1) {
                    countOdd++;
                } else {
                    countOdd--;
                }
            }
        }
        return countOdd <= 1;
    }

    // solution 3 using bit vector to save memory
    /* Toggle the ith bit in the integer. */
    public static int toggle(int bitVector, int index) {
        if (index < 0) return bitVector;

        int mask = 1 << index;
        if ((bitVector & mask) == 0) {
            bitVector |= mask;
        } else {
            bitVector &= ~mask;
        }
        return bitVector;
    }

    /* Create bit vector for string. For each letter with value i,
     * toggle the ith bit. */
    public static int createBitVector(String phrase) {
        int bitVector = 0;
        for (char c : phrase.toCharArray()) {
            int x = Common.getCharNumber(c);
            bitVector = toggle(bitVector, x);
        }
        return bitVector;
    }

    /* Check that at most one bit is set by subtracting one from the
     * integer and ANDing it with the original integer. */
    public static boolean checkAtMostOneBitSet(int bitVector) {
        return (bitVector & (bitVector - 1)) == 0;
    }

    public static boolean isPermutationOfPalindrome_s3(String phrase) {
        int bitVector = createBitVector(phrase);
        return checkAtMostOneBitSet(bitVector);
    }


    // end of solutions from book

    public static void main(String[] args) {
        String[] strings = {"Rats live on no evil star",
                "A man, a plan, a canal, panama",
                "A man, a plsan, a canal, panama",
                "Lleve",
                "Tacotac",
                "Taco Coa",
                "asda"};
        for (String str : strings) {
            System.out.println(str + " : " + isPermutationOfPalindrome_v1(str));
        }
    }
}
