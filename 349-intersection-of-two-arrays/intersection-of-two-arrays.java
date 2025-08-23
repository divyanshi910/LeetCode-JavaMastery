class Solution {
    public int[] intersectionBrute(int[] nums1, int[] nums2) {
        Set <Integer> set=new HashSet<>();
        for(int i:nums1){
            for(int j:nums2){
                if(i==j){
                    set.add(i);
                    break;
                }
            }
        }
        int [] result=new int[set.size()];
        int index=0;
        for(int i:set){
            result[index++]=i;
        }
        return result;
    }
    //using hashing Time: O(n + m) Space: O(n)
    public int[] intersection(int[] nums1, int[] nums2){
        Set <Integer> set=new HashSet<>();
        Set <Integer> setResult=new HashSet<>();
        for(int i:nums1){
            set.add(i);
        }
        for(int i:nums2){
            if(set.contains(i)){
                setResult.add(i);
            }
        }
        int [] result=new int[setResult.size()];
        int index=0;
        for(int i:setResult){
            result[index++]=i;
        }
        return result;
    }
}