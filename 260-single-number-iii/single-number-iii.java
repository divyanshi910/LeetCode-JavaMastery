class Solution {
    public int[] singleNumber(int[] nums) {
        int xor =0;
        int result[] = new int[2];
        for(int i:nums){
            xor^= i; 
            
        }
        int rightmostbit = xor & (-xor);
        for(int i:nums){
            if((i & rightmostbit)==0){
                result[0]^= i;
            }
            else{
                result[1]^= i;
            }
        }
        return result;
    }
}