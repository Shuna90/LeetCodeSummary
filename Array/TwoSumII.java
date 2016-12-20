public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        if (numbers == null || numbers.length == 0){
            return res;
        }
        int s = 0, e = numbers.length - 1;
        while (s < e){
            if (numbers[s] + numbers[e] == target){
                res[0] = s + 1;
                res[1] = e + 1;
                return res;
            }else if (numbers[s] + numbers[e] < target){
                s++;
            }else{
                e--;
            }
        }
        return res;
    }
}