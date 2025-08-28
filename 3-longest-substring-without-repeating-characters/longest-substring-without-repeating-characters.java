class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set=new HashSet<>();
        int max=0;
        int left=0;
        for(int right=0;right<s.length();right++){
            while(set.contains(s.charAt(right))){
                //remove the left most and slide the window
                set.remove(s.charAt(left));
                left++;
            }
                set.add(s.charAt(right));
                max=Math.max(max,right-left+1);//to calculate length l-r+1;
        }
       return max;
    }
}