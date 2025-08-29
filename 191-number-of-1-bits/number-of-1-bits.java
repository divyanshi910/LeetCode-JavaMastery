class Solution {
    public int hammingWeightApp1(int n) {
        return Integer.bitCount(n); //Tc:O(1)constant  SC: O(1)
    }
    //approach2 TC O(number of 1 bits) SC: O(1)
    public int hammingWeight(int n) {
        int count=0;
        while(n>0){
            n = n & (n-1); //bit masking eg 11 & 10=10 so new n=10 then 10&9=9 then 9 & 8=0 so count=3;
            count++;
        }
        return count;
    }
}