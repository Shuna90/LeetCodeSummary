public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new LinkedList<String>();
        if (nums == null || nums.length == 0){
            return res;
        }
        String s = nums[0] + "";
        int index = 0;
        //StringBuilder sb = new StringBuilder();
        //sb.append(String.valueOf(nums[0]));
        for (int i = 1; i < nums.length; i++){
            if (nums[i] == nums[i - 1] + 1){
                continue;
            }else{
                if (i - index == 1){
                    res.add(s);
                }else{
                    res.add(s + "->" + nums[i - 1]);
                }
                index = i;
                s = nums[i] + "";
                //sb.append("->");
                //sb.append(String.valueOf(nums[i - 1]));
                //res.add(sb.toString());
            }
        }
        if (nums.length - 1 - index == 0){
            res.add(s);
        }else{
            res.add(s + "->" + nums[nums.length - 1]);
        }
        return res;
    }
}