class Solution {
    //give TLE O(n^2)
    public int findMaxLengthBruteForce(int[] nums) {
        int maxLen = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int count0 = 0;
            int count1 = 0;

            for (int j = i; j < n; j++) {
                if (nums[j] == 0) {
                    count0++;
                } else {
                    count1++;
         }

         if (count0 == count1) {
      maxLen = Math.max(maxLen, j - i + 1); //calculate length of subarray, i:start index,j:end index
                }
            }
        }
        return maxLen;
    }
    //O(N) hash set prefix sum
    public int findMaxLength(int[] nums){
         int sum=0, maxLength=0;
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,-1); //base case
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                nums[i]=-1;
            }
        }
        for(int i=0;i<nums.length;i++){
             sum= sum+nums[i];
            if(map.containsKey(sum)){
                maxLength=Math.max(maxLength,i-map.get(sum));
            }
            else{
                map.put(sum,i);
            }
        }
        return maxLength;
    }
}

    
