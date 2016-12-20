public class Solution {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++){
            arr[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(arr, new Comparator<String>(){
            public int compare(String a, String b){
                String ab = a + b;
                String ba = b + a;
                return ba.compareTo(ab);
            }
        });
        for (int i = 0; i < arr.length; i++){
            sb.append(arr[i]);
        }
        int index = 0;
        while (index < sb.length() && sb.charAt(index) == '0'){
            index++;
        }
        if (index == sb.length()){
            return "0";
        }
        return sb.toString();
    }
}