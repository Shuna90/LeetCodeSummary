public class TwoSum {
    
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    List<Integer> list = new ArrayList<Integer>();
    
    // Add the number to an internal data structure.
	public void add(int number) {
	    if (map.containsKey(number)){
	        map.put(number, map.get(number) + 1);
	    }else{
	        map.put(number, 1);
	        list.add(number);
	    }
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
	    for (int i = 0; i < list.size(); i++){
	       int num1 = list.get(i);
	       int num2 = value - num1;
	        if (map.containsKey(num2)){
	            if (num2 != num1 || map.get(num2) > 1){
	                return true;
	            }
	        }
	    }
	    return false;
	}
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);