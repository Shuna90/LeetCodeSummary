448. Find All Numbers Disappeared in an Array
Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.



no extra space: do something in the array inside, 
				better maintain the origenal value or able to calculate. 
				nagative
O(n) run time: scan constant times

public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ret = new ArrayList<Integer>();
        int n = nums.length;
        for (int i = 0; i < n; i++){
            int val = Math.abs(nums[i]) - 1;
            if (nums[val] > 0){
                nums[val] = - nums[val];
            }
        }
        for (int i = 1; i <= n; i++){
            if (nums[i - 1] > 0){
                ret.add(i);
            }
        }
        return ret;
    }