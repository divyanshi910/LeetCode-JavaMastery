class Solution {
    //brute force TC:O(nlogn)
    public int longestConsecutiveBruteForce(int[] nums) {
      if(nums.length==0){
        return 0;
      }
        Arrays.sort(nums);
        int count=1;
        int maxCount=1;
        for(int i=0;i<nums.length-1;i++){
         int currentNum=nums[i];
         int nextCurrent=nums[i+1];
         if(currentNum==nextCurrent){
            continue;
         }
         else if(nextCurrent==currentNum+1){
            count++;
         }
         else{
            count=1;
         }
         maxCount=Math.max(maxCount,count);
    }
    return maxCount;
}
//Hash set approach O(n)
    public int longestConsecutive(int[] nums){
        Set<Integer> arr=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            arr.add(nums[i]);
        }
        int maxCount=0;
        for(int num:arr){
        //start a new sequence if it does not contain num-1
            if(!arr.contains(num-1)){
                int currentNum=num;
                int count=1;
            
            while(arr.contains(currentNum+1)){
                currentNum++;
                count++;
        }
        maxCount=Math.max(maxCount,count);
            }
        }
        return maxCount;
    }
}

