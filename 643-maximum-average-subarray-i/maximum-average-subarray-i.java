class Solution {
    //approach 1 Brute force O(N^2)
    public double findMaxAverageBruteForce(int[] nums, int k) {
        double max=Double.NEGATIVE_INFINITY;
        for(int i=0;i<=nums.length-k;i++){
            int sum=0;
            for(int j=i;j<i+k;j++){
                sum =sum +nums[j];
            }
            max =Math.max(max,(double)sum/k);
        }
        return max;
    }
    //sliding window approach 2
    //TC O(N)
     public double findMaxAverage(int[] nums, int k){
        double sum=0.0;
        //pick first k sum
        for(int i=0;i<k;i++){
            sum=sum + nums[i];
        }
        double max= (double)sum/k;
        // for(int i=k;i<nums.length;i++){
        //     sum = sum - nums[i-k] + nums[i];
        for(int i=1;i<nums.length-k+1;i++){
            sum = sum - nums[i-1] + nums[i+k-1];
            max= Math.max(max,(double)sum/k);
        }
        return max;
     }
}