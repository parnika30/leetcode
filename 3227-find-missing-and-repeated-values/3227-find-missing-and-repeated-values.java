class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        HashSet<Integer> set = new HashSet<>();
        int miss =0;
        int repeat = 0;
        ArrayList<Integer> ls = new ArrayList<>();
        for (int[] row : grid) {
            for (int num : row) {
                if (!set.contains(num)) {
                    set.add(num);
                } else {
                    repeat = num;
                }
            }
        }

        int n = grid.length * grid[0].length; // Total expected numbers from 1 to n
        for (int i = 1; i <= n; i++) {
            if (!set.contains(i)) {
                miss = i;
                break;
            }
        }

        // Add the found values to the list
        ls.add(repeat);
        ls.add(miss);

        // Convert list to int array
        return ls.stream().mapToInt(i -> i).toArray();
    }
}