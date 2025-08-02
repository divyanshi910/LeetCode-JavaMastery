class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        for(char i:num.toCharArray()){
            while(!stack.isEmpty() && k>0 && i<stack.peek()){
                stack.pop();
                k--;
            }
            stack.push(i);
        }
        //convert stack to stringbuilder
        StringBuilder s = new StringBuilder();
        while(!stack.isEmpty()){
            if(k>0){ //remove k elements from right side
                stack.pop();
                k--;
            }
            else{
                s.insert(0,stack.pop());
            }
        }
        //remove the leading zeroes
        while(s.length()>0 && s.charAt(0)=='0'){
            s.deleteCharAt(0);
        }
        return (s.length()==0)?"0": s.toString();
    }
}