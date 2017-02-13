386. Lexicographical Numbers

/*
Given an integer n, return 1 - n in lexicographical order.

For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].

Please optimize your algorithm to use less time and space. The input size may be as large as 5,000,000.
*/
public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new LinkedList<Integer>();
        int cur = 1;
        for (int i = 1; i <= n; i++){
            res.add(cur);
            if (cur * 10 <= n){
                cur = cur * 10;
            }else if (cur % 10 != 9 && cur + 1 <= n){
                cur++;
            }else{
                while ((cur / 10) % 10 == 9){
                    cur /= 10;
                }
                cur = cur / 10 + 1;
            }
        }
        return res;
    }