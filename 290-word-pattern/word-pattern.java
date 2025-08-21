class Solution {
    public boolean wordPattern(String pattern, String s) {
        String strs []=s.split(" ");
        if(strs.length !=pattern.length()){
            return false;
        }
        //Declare 2 hashmap
        Map<Character,String> map1=new HashMap<>();
        Map<String,Character> map2=new HashMap<>();
        for(int i=0;i<pattern.length();i++){
            char singleChar=pattern.charAt(i);
            String word=strs[i];
            //a exist in first map1
            if(map1.containsKey(singleChar)){
                String mapWord=map1.get(singleChar); //a(key)--.dog,find value
                //  if(!mapWord==(word)) it compares the reference in String case
                if(!mapWord.equals(word)){ //here it comapres character by character value
                    return false;//invalid
                }
            }
            else{
                //if key not found
                map1.put(singleChar,word); // a key -->word
            }
            //now do the same for map2
            if(map2.containsKey(word)){
                Character pt= map2.get(word);
                if(!pt.equals(singleChar)){
                    return false;
                }
            }
            else{
                map2.put(word,singleChar);
            }
        }
        return true;
    }
}