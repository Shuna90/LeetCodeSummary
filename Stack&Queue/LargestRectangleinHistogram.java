public class Solution {
    public int largestRectangleArea(int[] height) {
        if (height.length == 0){
			return 0;
		}
		Stack<Integer> stack = new Stack<Integer>();
		int i = 0;
		int res = 0;
		while (i < height.length){
			if (stack.isEmpty() || height[i] >= height[stack.peek()]){
				stack.push(i);
				i++;
			}else{
				int index = stack.pop();
				int width = stack.isEmpty() ? i : (i - 1 - stack.peek());
				res = Math.max(res, width * height[index]);
			}
			
		}
		while (!stack.isEmpty()){
			int index = stack.pop();
			int width = stack.isEmpty() ? height.length : (height.length - 1 - stack.peek());
			res = Math.max(res, width * height[index]);
		}
		return res;
    }
}