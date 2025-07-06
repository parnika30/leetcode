class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Stack<Double> st = new Stack<>();
        int n = position.length;
    
        double[][] cars = new double[n][2]; //position, time

        for(int i=0; i<n; i++){
            double time = (double)(target - position[i]) / speed[i];
            cars[i][0] = position[i];
            cars[i][1] = (double)time;
        }
        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));

        st.push(cars[0][1]); //Always push the first car’s time to the stack
        for(int i =1; i<n;i++){
            if(st.isEmpty() || cars[i][1] > st.peek()){ 
                st.push(cars[i][1]);
            }
        }

        return st.size();

    }
}

//agar next car after the top element of the stack chota ya equal hai, to car will join the fleet. so only push into the stack when the next car time is greater than top element of the stack.