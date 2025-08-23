class Solution {
    public int numIdenticalPairsBruteForce(int[] nums) {
        int count=0;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]==nums[j] && i<j){
                    count++;
                }
            }
        }
        return count;
    }
    public int numIdenticalPairs(int[] nums) {
        Map <Integer , Integer> map=new HashMap<>();
        int count=0;
       
        for(int j:nums){
            if(map.containsKey(j)){
                count=count + map.get(j);
            }
            map.put(j,map.getOrDefault(j,0)+1);
        }
        return count;
    }
}