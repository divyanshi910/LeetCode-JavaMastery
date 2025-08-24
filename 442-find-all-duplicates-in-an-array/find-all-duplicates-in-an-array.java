class Solution {
    //SC O(n)
    public List<Integer> findDuplicatesOld(int[] nums) {
        List<Integer> result=new ArrayList<>();
        Map<Integer,Integer> map=new HashMap<>();
        int count=0;
        for(int i:nums){
             map.put(i,map.getOrDefault(i,0)+1);
              if(map.get(i)==2){
                result.add(i);
            } 
        }
        return result;
    }
   //SC O(1) approach 2
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1; // Map value to index

            if (nums[index] < 0) {
                // If already negative, it’s a duplicate
                result.add(Math.abs(nums[i]));
            } else {
                // Mark as visited by negating the value at that index
                nums[index] = -nums[index];
            }
        }

        return result;
    }


}