class Solution {
    public boolean hasDuplicate(int[] nums) {

        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i: nums){
            if(hm.containsKey(i)){
                return true;
            }
            hm.put(i,1);
        }
        return false;
        
    }
}