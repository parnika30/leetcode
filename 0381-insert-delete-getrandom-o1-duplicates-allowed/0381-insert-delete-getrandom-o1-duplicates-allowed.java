class RandomizedCollection {

    List<Integer> list;
    Map<Integer, HashSet<Integer>> map;
    Random rand;

    public RandomizedCollection() {
        list = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        HashSet<Integer> set;
        boolean flag;
        if(map.containsKey(val)){
            set = map.get(val);
            flag = false;
        }else{
            set = new HashSet<>();
            flag = true;
        }

        set.add(list.size());
        list.add(val);
        map.put(val, set);
        return flag;
    }
    
    public boolean remove(int val) {
        HashSet<Integer> set;
        if(!map.containsKey(val)){ 
            return false;
        }
        else {
            set = map.get(val);
        }

        int remIdx = -1;
        for(int i : set){
            remIdx = i;
            break;
        }

        set.remove(remIdx);
        map.put(val, set);

        //list se remove krna hai 
        if(remIdx == list.size()-1){ //last index pe hai 
            list.remove(list.size()-1);
        } else{ //swapping logic
            list.set(remIdx, list.get(list.size()-1));
            list.remove(list.size()-1);

            //map k corres jo set hai, usko change karna hai
            int newVal = list.get(remIdx); //removed ind ke val ko nikalo
            HashSet<Integer> temp = map.get(newVal); 
            temp.remove(list.size()); //purani inde -> last index
            temp.add(remIdx);
            map.put(newVal, temp);
        }

        return true;
    }
    
    public int getRandom() {
        int n = rand.nextInt(list.size());
        return list.get(n);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */