class Solution {
    public int countSubstrings(String s) {

        int low, high, count = 0;

        for(int i=0;i<s.length();i++){
            // for even length
            low = i-1;
            high = i;

            while(low >=0 && high < s.length() && s.charAt(low) == s.charAt(high)){
                count++;
                low--;
                high++;
            }

            low = i;
            high = i;

            while(low >=0 && high < s.length() && s.charAt(low) == s.charAt(high))  {
                count++;
                low--;
                high++;
            }
        }
        return count;
        
    }
}
