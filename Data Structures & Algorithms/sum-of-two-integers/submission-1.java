class Solution {
    public int getSum(int a, int b) {
        
        while (b != 0) {
            // sum without carry
            int sum = a ^ b;
            
            // carry
            int carry = (a & b) << 1;
            
            // update values
            a = sum;
            b = carry;
        }
        
        return a;
    }
}