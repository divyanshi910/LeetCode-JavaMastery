class Solution {
    // approach 1 TC:O(N^2) gives TLE
    public boolean containsDuplicateBruteForce(int[] nums) {
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]==nums[j]){
                    return true;
                }
            }
        }
        return false;
    }
    //hash set TC: O(N)
    public boolean containsDuplicate(int[] nums){
       Set<Integer> st=new HashSet<>();
      for(int i=0;i<nums.length;i++){
        if(st.contains(nums[i])){
            return true;
        }
        else{
            st.add(nums[i]);
        }
      }
      return false;
    }
}
        
      
       
