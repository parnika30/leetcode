class RandomizedSet {
    List<Integer> list;
    Map<Integer, Integer> map; //val, ind
    Random rand;

    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        if(!map.containsKey(val)){
            map.put(val, list.size());
            list.add(val);
            return true;
        }
        return false;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;

        //swap the remove with last ele in the list 
        int index = map.get(val);
        int last = list.get(list.size()-1);
        list.set(index, last);
        map.put(last, index);
        list.remove(list.size()-1);
        map.remove(val);
        return true;
    }
    
    public int getRandom() {
        int n = rand.nextInt(list.size());
        return list.get(n);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */