15. 3Sum

/*
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note: The solution set must not contain duplicate triplets.

For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
*/

public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if (nums == null || nums.length == 0){
            return res;
        }
        Arrays.sort(nums);
        int size = nums.length;
        int sum = 0;
        List<Integer> list;
        for (int i = 0; i < size; i++){
            int left = i + 1, right = size - 1;
            while (left < right){
                sum = nums[i] + nums[left] + nums[right];
                if (sum == 0){
                    list = new ArrayList<Integer>();
                    list.add(i);
                    list.add(left++);
                    list.add(right--);
                    if (!res.contains(list)){
                        res.add(list);
                    }
                }else if (){
                    
                }else{
                    
                }
            }
        }
        return res;
    }