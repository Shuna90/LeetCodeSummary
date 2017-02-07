380. Insert Delete GetRandom O(1)
/*

Design a data structure that supports all following operations in average O(1) time.

insert(val): Inserts an item val to the set if not already present.
remove(val): Removes an item val from the set if present.
getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
*/

ArrayList<Integer> list;
    HashMap<Integer, Integer> map;
    Random random;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        list = new ArrayList<Integer>();
        random = new Random();
        map = new HashMap<Integer, Integer>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)){
            return false;
        }
        map.put(val, list.size());
        list.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)){
            return false;
        }
        int index = map.get(val);
        if (index < list.size()){
            int lastone = list.get(list.size() - 1);
            list.set(index, lastone);
            map.put(lastone, index);
        }
        map.remove(val);
        list.remove(list.size() - 1);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }






    ArrayList<Integer> nums;
	    HashMap<Integer, Set<Integer>> locs;
	    java.util.Random rand = new java.util.Random();
	    /** Initialize your data structure here. */
	    public RandomizedSet() {
	        nums = new ArrayList<Integer>();
	        locs = new HashMap<Integer, Set<Integer>>();
	    }
	    
	    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
	    public boolean insert(int val) {
	        boolean contain = locs.containsKey(val);
	        if ( ! contain ) locs.put( val, new HashSet<Integer>() ); 
	        locs.get(val).add(nums.size());        
	        nums.add(val);
	        return ! contain ;
	    }
	    
	    /** Removes a value from the set. Returns true if the set contained the specified element. */
	    public boolean remove(int val) {
	        boolean contain = locs.containsKey(val);
	        if ( ! contain ) return false;
	        int loc = locs.get(val).iterator().next();
                locs.get(val).remove(loc);
	        if (loc < nums.size() - 1 ) {
	            int lastone = nums.get(nums.size() - 1 );
	            nums.set( loc , lastone );
	            locs.get(lastone).remove(nums.size() - 1);
	            locs.get(lastone).add(loc);
	        }
	        nums.remove(nums.size() - 1);
	        if (locs.get(val).isEmpty()) locs.remove(val);
	        return true;
	    }
	    
	    /** Get a random element from the set. */
	    public int getRandom() {
	        return nums.get( rand.nextInt(nums.size()) );
	    }
	}