class Solution {
    //approach 1 TC O(N^2), SC O(1)
    public int pivotIndexBruteForce(int[] nums) {
        for(int i=0;i<nums.length;i++){
           int leftSum=0;
            //for left sum
            for(int j=0;j<i;j++){
                leftSum=leftSum+nums[j];
            }
            //for right sum
            int rightSum=0;
            for(int j=i+1;j<nums.length;j++){
                rightSum=rightSum+nums[j];
            }
            if(leftSum==rightSum){
                return i;
            }
        }
        return -1;
    }
    //approach 2 TC O(N), SC: O(1), Pre computation
    public int pivotIndex(int[] nums){
        //pre compute sum
        int totalSum=0;
        for(int i:nums){ //O(N)
            totalSum=totalSum+i;
        }
        int leftSum=0;
        for(int i=0;i<nums.length;i++){ //O(N) but without nesting
            int rightSum = totalSum- leftSum - nums[i]; //minus leftsum then current index
            if(leftSum==rightSum){
                return i; //pivot index
            }
            leftSum= leftSum +nums[i];
        }
        return -1;
    }
}