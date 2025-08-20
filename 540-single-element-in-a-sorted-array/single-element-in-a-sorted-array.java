class Solution {
    //this takes O(n) so not good
    public int singleNonDuplicateXOR(int[] nums) {
        int r=0;
        for(int i:nums){
            r^=i;
        }
        return r;
    }
    //binary search approach
    public int singleNonDuplicate(int[] nums){
        int low=0;
        int high=nums.length-1;
        while(low<high){
            int mid=low+(high-low)/2;
            if (mid % 2 == 1) mid--; //to make pairs we need even mid
            if(nums[mid]==nums[mid+1]){
                low=mid+2; // Single element is after this pair
            }
            else{
                high=mid; // Single element is before or at mid
            }
        }
        return nums[low];
    }
}