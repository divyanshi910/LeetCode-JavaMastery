class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int result[] = new int[nums.length];
        for(int i=2*nums.length-1;i>=0;i--){
            while(!stack.isEmpty() && nums[stack.peek()]<=nums[i%nums.length]){
                stack.pop();
            }
            result[i%nums.length]=(stack.isEmpty()? -1 : nums[stack.peek()]);
            stack.push(i%nums.length);//to make it in range and we are storing indexes in stack
        }
        return result;
    }
}