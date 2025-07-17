class Solution {
    public int climbStairs(int n) {
     
        //choice 1(take 1 step)
        int dp[]=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
    
       return dp[n];
    }
}
   //choice 2
    //    if(n<=1){
    //     return 1;
    //    }
    //    int count1=climbStairs(n-1);
    //    int count2=climbStairs(n-2);
    //    return first + second;
  