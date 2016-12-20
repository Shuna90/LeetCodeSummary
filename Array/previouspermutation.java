public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers that's previous permuation
     */
    public ArrayList<Integer> previousPermuation(ArrayList<Integer> nums) {
		// write your code
		int k = -1, l = -1, max = -1;
		int size = nums.size();
		int[] arr = new int[size];
		for (int i = 0; i < size; i++){
		    arr[i] = nums.get(i);
		}
		ArrayList<Integer> res = new ArrayList<Integer>();
		for (int i = size - 2; i >= 0; i--){
		    if (arr[i] > arr[i + 1]){
		        k = i;
		        break;
		    }
		}
		if (k == -1){
		    reverse(arr, 0, size - 1);
		    addAll(res, arr);
		    return res;
		}
		for (int i = size - 1; i > k; i--){
		    if (arr[i] < arr[k] && arr[i] > max){
		        max = arr[i];
		        l = i;
		    }
		}
		swap(arr, k, l);
		reverse(arr, k + 1, size - 1);
		addAll(res, arr);
		return res;
    }
    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    public void reverse(int[] nums, int i, int j){
        while (i < j){
            swap(nums, i, j);
            i++;
            j--;
        }
    }
    public void addAll(ArrayList<Integer> res, int[] arr){
        for (int i = 0; i < arr.length; i++){
            res.add(arr[i]);
        }
    }
}
