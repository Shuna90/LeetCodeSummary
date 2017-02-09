215. Kth Largest Element in an Array

/*
Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

For example,
Given [3,2,1,5,6,4] and k = 2, return 5.

Note: 
You may assume k is always valid, 1 ≤ k ≤ array's length.
*/
public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, k, 0, nums.length - 1);
    }
    public int findKthLargest(int[] nums, int k, int start, int end){
        if (start > end){
            return -1;
        }
        int pivot = nums[end];
        int left = start;
        for (int i = start; i < end; i++){
            if (nums[i] > pivot){
                swap(nums, left++, i);
            }
        }
        swap(nums, left, end);
        int count = left - start + 1;
        if (count == k){
            return nums[left];
        }else if (count > k){
            return findKthLargest(nums, k, start, left - 1);
        }else{
            return findKthLargest(nums, k - count, left + 1, end);
        }
    }
    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }