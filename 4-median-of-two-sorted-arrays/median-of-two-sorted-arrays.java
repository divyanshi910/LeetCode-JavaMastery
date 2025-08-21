class Solution {
    public int[] merge(int[]num1, int []num2){
        int n1=num1.length;
        int n2=num2.length;
        int i=0,j=0;
        int k = 0;
        int [] result = new int[n1+n2];
        while(i<n1 && j<n2){
            if(num1[i]<num2[j]){
                result[k] = num1[i];
                i++;
                k++;
            }
            else{
                result[k] = num2[j];
                j++;
                k++;
            }
        }
         while(i<n1){
            result[k]=num1[i];
            i++;
            k++;
         }
         while(j<n2){
            result[k]=num2[j];
            j++;
            k++;
         }
         return result;
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
       int r[] = merge(nums1,nums2);
        int low = 0, high = r.length;
        if(high%2==1){
            return r[high/2];
        }
        else{
            return (r[high/2-1]+r[high/2])/2.0;
        }
    }
}