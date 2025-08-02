class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        
        boolean sameSize = false;
        for(int i=0;i<asteroids.length;i++){
            sameSize = false;
            //left and right movement
            while(!stack.isEmpty() && (asteroids[i]<0 && stack.peek()>0 )){
                //checking collision
                //pop smaller one
                if(Math.abs(asteroids[i])>stack.peek()){
                    stack.pop();
                    continue;
                }
                else if(Math.abs(asteroids[i])==stack.peek()){
                    stack.pop();
                    
                }
                sameSize = true; //dont push both
                break;
            }
            if(!sameSize){
            stack.push(asteroids[i]);//push the bigger one
            }
        }
        int result[] = new int[stack.size()];
        for(int i = result.length-1;i>=0;i--){
            result[i]= stack.pop();
        }
        return result;
    }
}