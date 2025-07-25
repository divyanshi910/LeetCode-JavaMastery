class Solution {
    public String removeDuplicates(String s) {
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
}