class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();

        for(int i=0;i<nums.length;i++){
            hs.add(nums[i]);
        }

        int longest = 0;

        for(int i=0;i<nums.length;i++){
            int item = nums[i];
            if(!hs.contains(item -1)){
                int count =1;
                int x =item;

                while(hs.contains(x+1)){
                    count++;
                    x= x+1;
                }
                longest = Math.max(longest, count);
            }
        }
        return longest;
    }
}
