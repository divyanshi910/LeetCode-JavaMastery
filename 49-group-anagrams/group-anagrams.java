class Solution {
    //brute force Approach 1 (n^2 *nlogn)
    boolean isAnagram(String first,String second){
        if(first.length()!=second.length()){
            return false;
        }
        char []x=first.toCharArray();
        char []y=second.toCharArray();
        Arrays.sort(x);
        Arrays.sort(y);
        return Arrays.equals(x,y); //if same so it return true otherwise false
    }
    public List<List<String>> bruteForcegroupAnagrams(String[] strs) {
        List<List<String>> bigList=new ArrayList<>();
        for(String word:strs){
            boolean added=false; //flag to check it is already in the list
            for(List<String> smallList :bigList){
                if(isAnagram(smallList.get(0),word)){
                    smallList.add(word);
                    added =true;
                    break;
                }
            }
            if(!added){
                List<String> newSmallList=new ArrayList<>();
                newSmallList.add(word);
                bigList.add(newSmallList);
            }
        }
        return bigList;
    }
    //Approach 2 hashing TC: n* nlogn
     public List<List<String>> groupAnagramsOld(String[] strs){
     Map<String,List<String>> map=new HashMap<>();
          for(String word:strs) //n
          {
        char []w=word.toCharArray();
        Arrays.sort(w);//NlogN
        String key=new String(w);
        //key is string and value is list
        //map key ko rakhega
        map.computeIfAbsent(key,k->new ArrayList<>()).add(word);
        //map takes constant space time
     }
     return new ArrayList<>(map.values()); //these are small lis that is value
     }
     //approach 3
      public List<List<String>> groupAnagrams(String[] strs){
         Map<String,List<String>> map=new HashMap<>();
        for(String word:strs){
            int countArr[]=new int[26]; //constant space
            for(char c: word.toCharArray()){
                countArr[c-'a']++; //frequency count
            }
            StringBuilder sb=new StringBuilder(); //
            for(int k:countArr){
                sb.append(k).append('#'); //1#1#1#
            }
            String key=sb.toString();
             map.computeIfAbsent(key,k->new ArrayList<>()).add(word);
        }
        return new ArrayList<>(map.values());
      }
}