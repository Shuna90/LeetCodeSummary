public class Solution {
    public String getPermutation(int n, int k) {
        k--;
        int factor = 1;
        for (int i = 1; i < n; i++){
            factor *= i;
        }
        int round = n - 1;
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++){
            list.add(i);
        }
        StringBuilder sb = new StringBuilder();
        while (round >= 0){
            int index = k / factor;
            k = k % factor;
            sb.append(list.get(index));
            list.remove(index);
            if (round > 0){
                factor /= round;
            }
            round--;
        }
        return sb.toString();
    }
}
public class Solution {
    public String getPermutation(int n, int k) {
        int factor = 1;
        for (int i = 2; i <= n; i++){
            factor *= i;
        }
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++){
            list.add(i);
        }
        StringBuilder sb = new StringBuilder();
        k--;
        int index = 0;
        for (int i = n - 1; i > 0; i--){
            index = k / factor;
            sb.append(list.remove(index));
            k -= index * factor;
            factor /= i;
        }
        sb.append(list.remove(0));
        return sb.toString();
    }
}