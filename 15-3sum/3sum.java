class Solution {
   //brute force O(N^3)
    public List<List<Integer>> threeSumBruteForce(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(triplet); // Sort to handle duplicates
                        result.add(triplet);
                    }
                }
            }
        }

        return new ArrayList<>(result);
    }

//Tc: O(N^2) approach 2
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums==null || nums.length<3){
            return new ArrayList<>();
        }
        Set<List<Integer>> result=new HashSet<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){  //-2 becoz we need 3 elements
            //find other two elements using 2 sum approach
            int left=i+1;
            int right=nums.length-1;
            while(left<right){
            int sum=nums[i] + nums[left] + nums[right];
            if(sum==0){
                //add in result
                List<Integer> list=new ArrayList<>();
                list.add(nums[i]);
                list.add(nums[left]);
                list.add(nums[right]);
                result.add(list);
            //result.add(Arrays.asList(nums[i] ,nums[left],nums[right]));
                
                left++;
                right--;
            }
            else if(sum>0){
                right--;
            }
            else if(sum<0){
                left++;
            }
        }
        }
        return new ArrayList<>(result);
    }
}