class MyStack {
    Queue<Integer> queue; //this is interface
    public MyStack() {
        queue=new LinkedList<>();
    }
    //TC 0(N)
    public void push(int x) {
        queue.add(x);
        //for reversing the queue to make a stack
        int size=queue.size();
        for(int i=0;i<size-1;i++){
            queue.add(queue.remove());//remove the front and added it back in rear
        }
    }
      //TC 0(1)
    public int pop() {
        return queue.remove();
    }
      //TC 0(1)
    public int top() {
        return queue.peek();
    }
      //TC 0(1)
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */