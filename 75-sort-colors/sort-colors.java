class Solution {
    public void swap(int []nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public void sortColors(int[] nums) {
        int first=0;
        int mid=0;
        int last=nums.length-1;
        while(mid<=last){ //cross condition
        if(nums[mid]==0){
            swap(nums,first,mid); //swap first and mid value
            first++;
            mid++;
        }
        else if(nums[mid]==1){
            mid++;
        }
        else if(nums[mid]==2){
            swap(nums,mid,last); //swap mid and high value
            last--;
            
        }
        }
    }
}