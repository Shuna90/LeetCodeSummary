202. Happy Number

/*
19 is a happy number

12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
*/

public boolean isHappy(int n) {
        if (n <= 0){
            return false;
        }
        HashSet<Integer> set = new HashSet<Integer>();
        while (n != 1){
            int count = 0;
            while (n > 0){
                int remain = n % 10;
                count += remain * remain;
                n = n / 10;
            }
            n = count;
            if (set.contains(n)){
                return false;
            }else{
                set.add(n);
            }
        }
        return n == 1;
    }