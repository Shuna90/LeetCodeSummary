371. Sum of Two Integers
/*
Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

Example:
Given a = 1 and b = 2, return 3.
*/

public int getSum(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;
        while (b != 0){
            int carry = a & b;
            a ^= b;
            b = carry << 1;
        }
        return a;
    }

public int getSum(int a, int b) {
	return (b == 0) ? a : getSum(a ^ b, (a & b) << 1);
}

public int getSubtract(int a, int b) {
	while (b != 0) {
		int borrow = (~a) & b;
		a = a ^ b;
		b = borrow << 1;
	}
	
	return a;
}