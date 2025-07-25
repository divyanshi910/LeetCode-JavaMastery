class Solution {
    //using 2 pointers
    public boolean backspaceCompare2pointers(String s, String t) {
        int i=s.length()-1;
        int j=t.length()-1;  
        int skipS=0;
        int skipT=0;
        while(i>=0 ||j>=0){
        while(i>=0){
            if(s.charAt(i) =='#'){
                skipS++;
                i--;
            }
            else if(skipS>0){
                skipS--;
                i--;
            }
            else{
                break;
            }  
        }
           while(j>=0){
            if(t.charAt(j) =='#'){
                skipT++;
                j--;
            }
             else if(skipT>0){
                skipT--;
                j--;
            }
            else{
                break;
            }
        }
        if(i>=0 && j>=0){
            if(s.charAt(i)!=t.charAt(j)){
                return false;
            }
        }
        else {
                // If one is valid and other is not
                if (i >= 0 || j >= 0) {
                    return false;
                }
            }
            i--;
            j--;
        }
        return true;
    }
    //using stack
    public boolean backspaceCompareStack(String s, String t) {
         Stack<Character> stackS = new Stack<>();
        Stack<Character> stackT = new Stack<>();
        for(char singleChar:s.toCharArray()){
            if(singleChar!='#'){
                stackS.push(singleChar);
            }
            else if(!stackS.isEmpty()){
                stackS.pop();
            }
        }
         for(char singleChar:t.toCharArray()){
            if(singleChar!='#'){
                stackT.push(singleChar);
            }
            else if(!stackT.isEmpty()){
                stackT.pop();
            }
        }
        return stackS.equals(stackT);
    }
    //using stringbuilder
     public boolean backspaceCompare(String s, String t) {
        String first = remainInStack(s);
        String second = remainInStack(t);
        return first.equals(second);
     }
     String remainInStack(String str){
        StringBuilder stack = new StringBuilder();
         for(char singleChar:str.toCharArray()){
            if(singleChar!='#'){
                stack.append(singleChar);
            }
            else if(stack.length()>0){
                stack.deleteCharAt(stack.length()-1);
            }
        }
        return stack.toString();
     }
   
}