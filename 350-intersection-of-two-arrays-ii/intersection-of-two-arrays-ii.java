class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map <Integer,Integer> map=new HashMap<>();
        List <Integer> resultList=new ArrayList<>();
        for(int i:nums1){
             map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                resultList.add(num);
                map.put(num, map.get(num) - 1); // Decrease count
            }
        }
        int [] result=new int[resultList.size()];
         for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
       
        return result;
    }
}