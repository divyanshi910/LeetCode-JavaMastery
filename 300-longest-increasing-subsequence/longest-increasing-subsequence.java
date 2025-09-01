/*
//Approach 1 Brute force solution
class Solution {
    public int lengthOfLIS(int[] nums) {
       return helper(nums,0,-1);
    }
    //index refers to current index
    //prevIndex refers to prev index
    int helper(int nums[], int index, int prevIndex){
        //base case
        if(nums.length==index){
            return 0;
        }
        //We have 2 choices
        //1.choice Pick It
        //i am on the first element(0th index) so thats why prevIndex==-1
        int pick=0;
        if(prevIndex==-1 || nums[index]>nums[prevIndex]){
            pick= 1 + helper(nums,index+1,index);
        }
        //2.Choice not pick it
        int notPick= helper(nums,index+1,prevIndex);
        return Math.max(pick,notPick);
    }
}
*/
/* Memoirzation
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] cache=new int[nums.length][nums.length];
       return helper(nums,0,-1,cache);
    }
    //index refers to current index
    //prevIndex refers to prev index
    int helper(int nums[], int index, int prevIndex, int[][] cache){
        //base case
        if(nums.length==index){
            return 0;
        }
        //Before doing calculations
        if(cache[index][prevIndex+1]!=0){
            return cache[index][prevIndex+1];
        }
        //Calc Done here
        //We have 2 choices
        //1.choice Pick It
        //i am on the first element(0th index) so thats why prevIndex==-1
        int pick=0;
        if(prevIndex==-1 || nums[index]>nums[prevIndex]){
            pick= 1 + helper(nums,index+1,index ,cache);
        }
        //2.Choice not pick it
        int notPick= helper(nums,index+1,prevIndex, cache);
        //Calc Result store in cache
        cache[index][prevIndex+1]= Math.max(pick,notPick);
        return cache[index][prevIndex+1];
    }
}
*/
//Approach 3 Tabulation
class Solution {
    public int lengthOfLIS(int[] nums) {
        int finalMax=0;
        int dp[] =new int[nums.length]; //LIS count maintain
        for(int i=0;i<nums.length;i++){ //move to next index
            int max=0;
            for(int j=0;j<i;j++){ //checking the previous
                if(nums[i]>nums[j]){
                    if(dp[j]>max){
                        max=dp[j];
                    }
                }
            }
            dp[i]= max+1;
            if(dp[i]>finalMax){
                finalMax=dp[i];
            }
        }
        return finalMax;
    }
}
