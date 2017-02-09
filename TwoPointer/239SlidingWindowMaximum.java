239. Sliding Window Maximum

/*
Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

For example,
Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Therefore, return the max sliding window as [3,3,5,5,6,7].

Note: 
You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.

Follow up:
Could you solve it in linear time?
*/
public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0){
            return new int[0];
        }
        //index
        Deque<Integer> dq = new ArrayDeque<>();
        int index = 0;
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++){
            while (!dq.isEmpty() && dq.peekFirst() < i - k + 1){
                dq.removeFirst();
            }
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
                dq.removeLast();
            }
            dq.addLast(i);
            if (i >= k - 1){
                res[index++] = nums[dq.peekFirst()];
            }
        }
        return res;
    }