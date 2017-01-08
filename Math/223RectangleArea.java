223. Rectangle Area
public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area1 = (C - A) * (D - B);
        int area2 =  (G - E) * (H - F);
        if (A >= G || B >= H || C <= E || D <= F){
            return area1 + area2;
        }
        int length = Math.min(C, G) - Math.max(A, E);
        int height = Math.min(D, H) - Math.max(B, F);
        int join = length * height;
        return area1 + area2 - join;
    }
}