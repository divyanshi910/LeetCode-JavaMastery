class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack=new Stack<>();
        int result[] = new int[temperatures.length];
        for(int i=temperatures.length-1;i>=0;i--){
            while(!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]){
                stack.pop();
            }
            result[i]=(stack.isEmpty()?0:(stack.peek()-i));
            stack.push(i);//storing index inside stack
        } 
        return result;
    }
}