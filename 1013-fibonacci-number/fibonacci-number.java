// Top Down memoization
//TC O(N) SC O(N)
//class Solution { //using dp to optimize the code ,
  //  Map<Integer, Integer> cache=new HashMap<>();

    //public int fib(int n) {
        //base case
      // if(n==0 ||n==1){
        //return n;
       //} 
       //value is exist in cache or not 
       //if(cache.containsKey(n))
       //{
        //value is in the cache , dont compute it return the pre-computed result
        //return cache.get(n);
       //}
       //if key is not present in the cache then do the following
       //int result=fib(n-1) + fib(n-2); //recurence relation
       //cache.put(n,result);
       //return result;
    //}
//}
class Solution{ //Bottom up approach tabulation
    public int fib(int n){
        if(n<=1){
            return n;
        }
        //1.start with base case
        //2.maintain array
        int dp[]=new int[n+1]; 
        //fill the base case
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n]; 
    }
}