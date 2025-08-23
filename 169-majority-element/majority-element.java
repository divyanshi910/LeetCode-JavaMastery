class Solution {
    //approach 1 brute force
    public int majorityElementBF(int[] nums) {
        int n=nums.length;
        for(int i=0;i<nums.length;i++){
            int count=0;
            for(int j=0;j<nums.length;j++){
                if(nums[i]==nums[j]){
                    count++;
                }
            }
            if(count>n/2){
                return nums[i];
            }
        }
        return -1;
    }
    //approach 2 hashing O(N) and O(N)
    public int majorityElementapproach(int[] nums){
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            if(map.get(nums[i])>n/2){
                return nums[i];
            }
        }
        return -1;
    }
    //approach 3 Boyer -Moore volting app
    //O(N) O(1)
     public int majorityElement(int[] nums){
        int count=0;
        int majElement=0;
        for(int num:nums){
            if(count==0){
                majElement=num;
            }
            if(num==majElement){
                count++;
            }
            else{
                count--;
            }
        }
        return majElement;
     }
}