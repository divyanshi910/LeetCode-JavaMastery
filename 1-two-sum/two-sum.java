class Solution {
    public int[] twoSum(int[] nums, int target) {
        //nlogn timeC , O(N) spaceComplexity
        int aux[]=Arrays.copyOf(nums,nums.length);
        Arrays.sort(nums);
        int first=-1;
        int second=-1;
        int a=0;
        int b=nums.length-1;
        
        while(a<b){
           int s=nums[a]+nums[b];
            if(s==target){
                first=nums[a];
                second=nums[b];
                a++;
                b--;
                break;
            }
            else if(s>target){
                b--;
            }
            else if(s<target){
                a++;
            }
        }
        int firstIndex=-1;
        int secondIndex=-1;
        for(int i=0;i<aux.length;i++){
        if(firstIndex==-1 && aux[i]==first){
            firstIndex=i;
        }
        else
        if(secondIndex==-1 && aux[i]==second){
            secondIndex= i;
        }
        }
        return new int[]{firstIndex,secondIndex};
    }
}