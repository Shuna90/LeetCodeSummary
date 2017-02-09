42. Trapping Rain Water

/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
*/

public int trap(int[] height) {
        int leftmax = 0, rightmax = 0;
        int l = 0, r = height.length - 1;
        int res = 0;
        while (l <= r){
            leftmax = Math.max(leftmax, height[l]);
            rightmax = Math.max(rightmax, height[r]);
            if (leftmax < rightmax){
                res += leftmax - height[l];
                l++;
            }else{
                res += rightmax - height[r];
                r--;
            }
        }
        return res;
    }