class MyCircularQueue {
    int []arr; //contains the data for queue
    //maintain front and rear
    int front;
    int rear;
    int size;
    int count;
    public MyCircularQueue(int k) {
        size=k;
        arr=new int[k];
        front= 0;
        rear=0;
        count=0;
    }
    //Tc O(1) SC O(1)
    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }
        arr[rear]=value;
        rear = (rear + 1) % size ;//within the range
        count++;
        return true;
    }
     //Tc O(1) SC O(1)
    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        front = (front+1) % size;
        count--;
        return true;
    }
     //Tc O(1) SC O(1)
    public int Front() {
        if(isEmpty()){
            return -1;
        }
        return arr[front];
    }
     //Tc O(1) SC O(1)
    public int Rear() {
        if(isEmpty()){
            return -1;
        }
        return arr[(rear-1 + size) % size];
    }
     //Tc O(1) SC O(1)
    public boolean isEmpty() {
        return count==0;
    }
     //Tc O(1) SC O(1)
    public boolean isFull() {
        return count == size;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */