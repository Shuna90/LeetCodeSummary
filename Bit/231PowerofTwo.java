231. Power of Two
public boolean isPowerOfTwo(int n) {
        return (n & (n - 1)) == 0 && (n > 0);
    }