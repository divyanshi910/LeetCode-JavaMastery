class Solution {
    int getFirst(int[] nums,int target){
        int low=0;
        int high=nums.length-1;
        int firstIndex=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
            firstIndex=mid;
                high=mid-1;
            }
            else if(nums[mid]<target){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return firstIndex;
    }
    int getLast(int[] nums,int target){
        int low=0;
        int high=nums.length-1;
        int lastIndex=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                lastIndex=mid;
                low=mid+1;
            }
            else if(nums[mid]<target){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return lastIndex;
    }
    public int[] searchRange(int[] nums, int target) {
        int result[]=new int[2];
        result[0]=getFirst(nums,target);
        result[1]=getLast(nums,target);
        return result;
    }
}