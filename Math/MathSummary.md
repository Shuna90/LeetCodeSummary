Summary
Math Problem 

1. integer  
	division
	1. without using multiplication, division and mod operator
	(int dividend, int divisor)
	Pay attention to overflow and edge cases:
		divisor == 0
		divident == 0
		Integer.MIN_VALUE 2147483647 
		Integer.MAX_VALUE -2147483648
		(-2147483648, -1)
	Process:
	sign:	(divident > 0) && (divisor > 0)  =====> true: nagative
			(divident ^ divisor) >>> 31 == 1 =====> true: nagative
	change to positive:		Math.abs((long) divident) 
							Math.abs((long) divisor)
							//Math.abs(-2147483648) = -2147483648
	quotient:	long
				divisor <<= i to speed up
				add sign 
				check overflow
				cast to int

	2. Fraction to Recurring Decimal
	HashMap<remainder, index> to catch recursion
	// same remainder is the begin of recursion


2. sqrt or pow
binary search to reduce find process
pow (double x, int n)
x == 0 n == 0 x == 1 n == 1 
x < 0:	n % 2 == 0
n < 0 ===> 1 / pow(x, -n);
pay attention: very time change to positive, Integer.MIN_VALUE!!!!!
n < 0:	Integer.MIN_VALUE 1/ (pow(x, Integer.MAX_VALUE) * x);