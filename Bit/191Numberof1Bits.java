191. Number of 1 Bits
public int hammingWeight(int n) {
        int count = 0;
        while (n != 0){
            count += n & 1;
            n >>>= 1;
        }
        return count;
    }

public int hammingWeight(int n) {
        int count = 0;
        while (n != 0){
            count++;
            n = n & (n - 1);
        }
        return count;
    }