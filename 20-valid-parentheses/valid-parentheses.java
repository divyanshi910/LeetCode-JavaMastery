class Solution {
    public boolean compareBracket(char opening , char closing){
        return ((opening=='(' && closing ==')') || (opening=='[' && closing ==']') || (opening=='{' && closing =='}') );
    }
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
           for(int i =0 ;i<s.length();i++){ 
           char bracket = s.charAt(i);
            if(bracket=='(' || bracket=='{' || bracket=='['){
                stack.push(bracket);
            }
            else if(!stack.isEmpty() && compareBracket(stack.peek(),bracket)){
                stack.pop();
            }
            else{
                return false;
            }
        }
        return stack.isEmpty();
    }
}