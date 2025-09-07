class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //Tc is O(n+n)as while loop inside for is going maximum for n elements
        //SC is O(n-k+1) but that is asked so sc is O(1)
        int n=nums.length;
        int res[]=new int[n-k+1];
        Deque<Integer>dequeue=new ArrayDeque<>();
        for(int i=0;i<k;i++){
            while(!dequeue.isEmpty() && nums[dequeue.peekLast()]<=nums[i]){
                dequeue.pollLast();//deleting index which has less value than current value
                //dequeue is in descending order
            }
            dequeue.offerLast(i);//adding index
        }
        res[0]=nums[dequeue.peekFirst()];
        for(int i=1;i<n-k+1;i++){
            if(!dequeue.isEmpty()&& dequeue.peekFirst()<=(i-1)){
                dequeue.pollFirst();
            }
            while(!dequeue.isEmpty() && nums[dequeue.peekLast()]<=nums[i+k-1]){
                dequeue.pollLast();//deleting index which has less value than current value
            }
            dequeue.offerLast(i+k-1);//adding index
            res[i]=nums[dequeue.peekFirst()];
        }
        return res;
    }
}