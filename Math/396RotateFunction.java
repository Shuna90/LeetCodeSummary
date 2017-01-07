396. Rotate Function

public int maxRotateFunction(int[] A) {
        int sum = 0;
        int size = A.length;
        int F = 0;
        for (int i = 0; i < size; i++){
            sum += A[i];
            F += i * A[i];
        }
        int max = F;
        for (int i = size - 1; i > 0; i--){
            F = F + sum - size * A[i];
            max = Math.max(max, F);
        }
        return max;
    }