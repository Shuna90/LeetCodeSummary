DP Summary


		o
	o   	o
o 	 	o 	 	o 

triangle

divid and conque 
public int findMin(List<List<Integer>> triangle, int i, int j){
        if (i == triangle.size()){
            return 0;
        }
        List<Integer> list = triangle.get(i);
        if (j > list.size()){
            return 0;
        }
        if (hashmap....){
        	return ......
    	}
        int res = list.get(j);
        int left = findMin(triangle, i + 1, j);
        int right = findMin(triangle, i + 1, j + 1);
        HashMap....Math.min(left, right) ...
        return Math.min(left, right) + res;
    }
memorization

build up from small problem to large problem

1. memorization
2. iterative

abstract
initial
fuction
return result

matrix DP:
    2 dimension
sequence DP
two sequence DP
    2 dimension
backpack DP

find the maximum, minimum, sum, product of......
True of False



1 dimension












