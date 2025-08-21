class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int end = Integer.MIN_VALUE;
        //finding max k
        for(int i=0;i<piles.length;i++){
            if(piles[i]>end){
                end = piles[i];
            }
        }
        //binary search
        int k = -1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(isEatingBananasValid(piles,mid,h)){
                k = mid;
                end = mid-1;//search start to mid so trying to reduce k
            }
            else{
                start = mid+1;//search mid to end so trying to increase k as k is invalid
            }
        }
        return k;
    }
    boolean isEatingBananasValid(int piles[],int eatingSpeed,int hours){
        int hoursSpent = 0;
        for(int i=0;i<piles.length;i++){
            hoursSpent+=piles[i]/eatingSpeed;
            if(piles[i] % eatingSpeed!=0){
                hoursSpent +=1;
            }
            if(hoursSpent>hours){
                return false;
            }
        }
        return true;
    }
}