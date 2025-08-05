class Solution {
    //approach 1
    public List<List<Integer>> subsets1(int[] nums) {
        List<Integer> smallList=new ArrayList<>();
         List<List<Integer>> bigList=new ArrayList<>(); 
         helper(nums,0,smallList,bigList);
         return bigList;
    }
    void helper(int []nums,int index,List<Integer> smallList,List<List<Integer>> bigList){ //void because we dont need to return a address as we are storing address

    //fake basecase as recursion will exhaust.
    if(index>nums.length){
        return;
    }

         bigList.add(new ArrayList<>(smallList));
        for(int i=index;i<nums.length;i++){
           
            smallList.add(nums[i]);
            helper(nums,i+ 1,smallList,bigList); //dubara chalegi. that is tree recursion. at every turn three or two or 1 branches will open depending on if statement.
            // from here backtracking will start.
            smallList.remove(smallList.size()-1); //remove the last index element.
            
        }
    }
    //approach 2 bit manipulation
     public List<List<Integer>> subsets(int[] nums) {
        int subsets = 1 << nums.length; //2^nums
         List<List<Integer>> bigList=new ArrayList<>(); 
         for(int n=0;n<subsets;n++){
             List<Integer> smallList=new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                if((n&(1<<i))!=0){
                    smallList.add(nums[i]);
                }
               
            }
             bigList.add(smallList);
         }
         return bigList;
     }
     }
