class Solution {
    //using stack and stringbuilder 
    public String removeDuplicatesStack(String s) {
        Stack<Character> stack = new Stack<>();
        for(char single:s.toCharArray()){
            if(stack.isEmpty() || single != stack.peek()){
            stack.push(single);
            }
            else{
                stack.pop();
            }
        }
        String result = "";
        while(!stack.isEmpty()){
            result+=stack.pop();
        }
        return new StringBuilder(result).reverse().toString();
    }
    //using only stringBuilder
     public String removeDuplicates(String s) {
        StringBuilder stack = new StringBuilder();
        for(char single:s.toCharArray()){
             if(stack.length()==0 || single != stack.charAt(stack.length()-1)){
            stack.append(single);
            }
            else{
                stack.deleteCharAt(stack.length()-1);
            }
        }
        return stack.toString();
     }
}