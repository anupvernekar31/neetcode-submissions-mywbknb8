class Solution {

    public void findCombination(int ind, int target, int[] arr, List<List<Integer>> ans, List<Integer> ds) {
        // Base case: if we have considered all elements in the array
        if (ind == arr.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(ds));  // Add the current combination to the result
            }
            return;
        }

        if (arr[ind] <= target) {
            ds.add(arr[ind]);  
            findCombination(ind, target - arr[ind], arr, ans, ds);  
            ds.remove(ds.size() - 1);
        }

        findCombination(ind + 1, target, arr, ans, ds);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();  // To store the result
        List<Integer> ds = new ArrayList<>();  // To store a current combination
        findCombination(0, target, candidates, ans, ds);  // Start the recursive search
        return ans;  // Return all valid combinations
    }
}