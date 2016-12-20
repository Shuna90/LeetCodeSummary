public class Solution {
    int min = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount <= 0){
            return 0;
        }
        Arrays.sort(coins);
        dfs(coins, amount, coins.length - 1, 0);
        return min == Integer.MAX_VALUE ? -1 : min;
    }
    public void dfs(int[] coins, int amount, int index, int count){
        if (amount == 0){
            if (count < min){
                min = count;
            }
            return;
        }
        if (index == -1){
            return;
        }
        int num = amount / coins[index];
        if (num == 0){
            dfs(coins, amount, index - 1, count);
            return;
        }
        for (int j = num; j >= 0; j--){
            if (count + j > min){
                break;
            }
            dfs(coins, amount - (j * coins[index]), index - 1, count + j);
        }
    }
}