// class Solution {
//     public int rob(int[] money) {
//         return rob(money , 0);
// }

//     public int rob(int[] money, int houseNo) {
//         //base case
//         if(houseNo>=money.length){
//             return 0;
//         }
//         //choice -1 rob the current house and then skip the next house
//         int choice1 = money[houseNo] + rob(money, houseNo + 2);

//         //int choice-2 not pick the current house,just move to next house
//         int choice2 = rob(money, houseNo + 1);
//         int result = Math.max(choice1, choice2);
//         return result;
//     }
// }
class Solution {
    public int rob(int[] money) {
        Integer [] cache = new Integer[money.length];
        return rob(money , 0, cache);
}

    public int rob(int[] money, int houseNo, Integer cache[]) {
        //base case
        if(houseNo>=money.length){
            return 0;
        }
        //before doing choice 1 first check is it already compute it
        if(cache[houseNo]!=null){
            return cache[houseNo];
        }
        //choice -1 rob the current house and then skip the next house
        int choice1 = money[houseNo] + rob(money, houseNo + 2, cache);

        //int choice-2 not pick the current house,just move to next house
        int choice2 = rob(money, houseNo + 1, cache);
        int result = Math.max(choice1, choice2);
        cache[houseNo] = result;
        return result;
    }
}