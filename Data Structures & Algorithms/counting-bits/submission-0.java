class Solution {

/*    // THIS IS BRUTE FORCE TO CALCULATE NUMBER OF SET BITS
    public int countSetBits(int n) {
        int count = 0;

        while (n > 0) {
            count += (n & 1); // check last bit
            n = n >> 1;
        }

        return count;
    }

    
*/

    // // THIS IS OPTIMAL WAY TO CALCULATE NUMBER OF SET BITS
    public int countSetBits(int n) {
        int count = 0; 

        while (n > 0) {
            n &= (n - 1);  
            count++;  
        }
        return count;
    }


    public int[] countBits(int n) {
        int ans[] = new int[n+1];
        for(int i=0;i<=n;i++){
            ans[i] = countSetBits(i);
        }

        return ans;
        
    }
}