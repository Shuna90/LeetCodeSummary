204. Count Primes
public int countPrimes(int n) {
        if (n <= 1){
            return 0;
        }
        int count = 0;
        boolean[] prime = new boolean[n + 1];
        for (int i = 2; i < n; i++){
            if (!prime[i]){
                count++;
                for (int j = i; j < n; j += i ){
                    prime[j] = true;
                }
            }
        }
        return count;
    }