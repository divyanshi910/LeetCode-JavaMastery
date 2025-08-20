class Solution {
    //Approach 1 brute force as timeComplexity is O(N^2)
    public int BruteForce(int[] height) {
        int max=0;
        //area
        //width
        //min height
        //2 index i,j width=i-j
        //minHeight= min(heigh[i],height[j])
        //area=minHeight*widhth
        for(int i=0;i<height.length;i++){
            for(int j=i+1;j<height.length;j++){
                int h=Math.min(height[i],height[j]);
                int w=j-i;
                int area=h*w;
                max=Math.max(area,max);
            }
        }
        return max; 
    }
    //Approach 2 using two pointer so we can work in only one traversal
    //O(N)
    public int maxArea(int[] height){
        int left=0;
        int right=height.length-1;
        int max=0;
        while(left<right){
            int h=Math.min(height[left],height[right]);
            int w=right-left;
            int area=h*w;
            max=Math.max(area,max);
            if(height[left]<height[right]){
                left++;
            }
            else{
                right--;
            }
        }
    
    return max;
    }
}