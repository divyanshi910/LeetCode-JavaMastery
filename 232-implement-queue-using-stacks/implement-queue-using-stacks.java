class MyQueue {
    Stack<Integer> inStack; //for push
    Stack<Integer> outStack; //for pop and peek
    public MyQueue() {
        inStack=new Stack<>();
        outStack=new Stack<>();
    }
    //TC O(1)
    public void push(int x) {
        inStack.push(x);
    }
    //first shift the element
    void shiftElements(){
        if(outStack.isEmpty()){
            while(!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
        }
    }
    //O(N)
    public int pop() {
        shiftElements();
        return outStack.pop();
    }
      //O(N)
    public int peek() {
         shiftElements();
      return  outStack.peek();
    }
    //O(1)
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */