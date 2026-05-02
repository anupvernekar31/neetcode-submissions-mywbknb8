class Solution {
    public int missingNumber(int[] nums) {
    //     int n= nums.length;
    //     int asum = ((n+1) * n)/2;
    //     int sum=0;

    //     for(int num: nums){
    //         sum+=num;
    //     }

    //     return asum-sum;
        
    // }

        int sum = nums.length, n = nums.length;

        for(int i=0;i<n;i++){
            sum += i - nums[i];
        }
        return sum;
    }
}