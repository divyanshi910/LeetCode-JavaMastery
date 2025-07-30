class Solution {
    //TC 0(N) SC 0(N)
    public int calculate(String s) {
        //maintain a stack(It store a number)
        Stack<Integer> stack=new Stack<>();
        int operand=0;
        char operator='+';//i take + as a default operator
        //scan the expression from left to right
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(Character.isDigit(ch)){//if it is an operand
            operand=operand * 10 + (ch-'0');//to convert '2' to int and operand *10 to convert like '12' to int 12
            }
            if(!Character.isDigit(ch) && ch!=' ' || i==s.length()-1){
                switch(operator){
                    case '+':
                    stack.push(operand);
                    break;
                    case '-':
                    stack.push(-operand);
                    break;
                    case '*':
                    stack.push(stack.pop() * operand);
                    break;
                    case '/':
                    stack.push(stack.pop() / operand);
                    break;
                }
                operator = ch;
                operand = 0;//reset
            }
        }
        int result=0;
         while(!stack.isEmpty()){
                    result = result + stack.pop();
                }
                return result;
    }
}