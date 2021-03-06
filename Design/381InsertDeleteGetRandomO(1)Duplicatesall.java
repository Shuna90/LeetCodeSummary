381. Insert Delete GetRandom O(1) - Duplicates allowed

/*
Design a data structure that supports all following operations in average O(1) time.

Note: Duplicate elements are allowed.
insert(val): Inserts an item val to the collection.
remove(val): Removes an item val from the collection if present.
getRandom: Returns a random element from current collection of elements. The probability of each element being returned is linearly related to the number of same value the collection contains.
Example:

// Init an empty collection.
RandomizedCollection collection = new RandomizedCollection();

// Inserts 1 to the collection. Returns true as the collection did not contain 1.
collection.insert(1);

// Inserts another 1 to the collection. Returns false as the collection contained 1. Collection now contains [1,1].
collection.insert(1);

// Inserts 2 to the collection, returns true. Collection now contains [1,1,2].
collection.insert(2);

// getRandom should return 1 with the probability 2/3, and returns 2 with the probability 1/3.
collection.getRandom();

// Removes 1 from the collection, returns true. Collection now contains [1,2].
collection.remove(1);

// getRandom should return 1 and 2 both equally likely.
collection.getRandom();
*/

ArrayList<Integer> nums;
    HashMap<Integer, Set<Integer>> map;
    Random random;
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        random = new Random();
        nums = new ArrayList<Integer>();
        map = new HashMap<Integer, Set<Integer>>();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean res = map.containsKey(val);
        if (!res){
            map.put(val, new LinkedHashSet<Integer>());
        }
        map.get(val).add(nums.size());
        nums.add(val);
        return !res;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)){
            return false;
        }
        int loc = map.get(val).iterator().next();
        map.get(val).remove(loc);
        if (loc < nums.size() - 1){
            int last = nums.get(nums.size() - 1);
            nums.set(loc, last);
            map.get(last).remove(nums.size() - 1);
            map.get(last).add(loc);
        }
        nums.remove(nums.size() - 1);
        if (map.get(val).isEmpty()){
            map.remove(val);
        }
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return nums.get(random.nextInt(nums.size()));
    }