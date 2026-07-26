class Solution {
    // public int findMin(int[] arr) {
    //     int low = 0, high = arr.length - 1;
    //     int ans = Integer.MAX_VALUE;
    //     while (low <= high) {
    //         int mid = (low + high) / 2;

    //         if(arr[low]<=arr[high]){
    //             ans = Math.min(ans, arr[low]);
    //             break;
    //         }

    //         //if left part is sorted:
    //         if (arr[low] <= arr[mid]) {
    //             // keep the minimum:
    //             ans = Math.min(ans, arr[low]);

    //             // Eliminate left half:
    //             low = mid + 1;

    //         } else { //if right part is sorted:

    //             // keep the minimum:
    //             ans = Math.min(ans, arr[mid]);

    //             // Eliminate right half:
    //             high = mid - 1;
    //         }
    //     }
    //     return ans;
    // }


    public int findMin(int[] nums) {

        // Initialize low and high pointers
        int low = 0, high = nums.length - 1;

        // Binary search loop
        while (low < high) {

            // Calculate mid index
            int mid = low + (high - low) / 2;

            // Check which half to discard
            if (nums[mid] > nums[high]) {

                // Minimum lies in right half
                low = mid + 1;

            } else {

                // Minimum lies in left half (including mid)
                high = mid;
            }
        }

        // Return the minimum element
        return nums[low];
    }
}