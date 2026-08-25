class Solution {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }

        int start = 0;
        int maxLength = 1;

        for (int i = 0; i < s.length(); i++) {
            // Even-length palindrome
            int low = i - 1;
            int high = i;

            while (low >= 0 && high < s.length()
                    && s.charAt(low) == s.charAt(high)) {

                if (high - low + 1 > maxLength) {
                    start = low;
                    maxLength = high - low + 1;
                }

                low--;
                high++;
            }

            // Odd-length palindrome
            low = i;
            high = i;

            while (low >= 0 && high < s.length()
                    && s.charAt(low) == s.charAt(high)) {

                if (high - low + 1 > maxLength) {
                    start = low;
                    maxLength = high - low + 1;
                }

                low--;
                high++;
            }
        }

        return s.substring(start, start + maxLength);
    }
}