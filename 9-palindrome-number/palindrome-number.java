class Solution {
    public boolean isPalindrome(int x) {
        if(x<0 || (x%10==0 && x!=0)){
            return false;
        }
        int cpy=x;
        int r=0;
        while(x!=0){
            int k=x%10;
             r=r*10+k;
            x=x/10;
        }
        return (r==cpy);
    }
}